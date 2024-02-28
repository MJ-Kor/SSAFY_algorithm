package hw.day_02_28;
//

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class Solution_1767_김민주 {
//	
//	private static final class Core{
//		int r, c;
//
//		public Core(int r, int c) {
//			super();
//			this.r = r;
//			this.c = c;
//		}
//		
//	}
//	
//	private static List<Core> cores = new ArrayList<>();
//	private static int N; 
//	private static int maxCore = Integer.MIN_VALUE;
//	private static int minWire = Integer.MAX_VALUE;
//	private static int[] dr = {-1, 0, 1, 0};
//	private static int[] dc = {0, 1, 0, -1};
//	private static int[][] processor;
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = null;
//		
//		int T = Integer.parseInt(br.readLine());
//		for (int test_case = 1; test_case <= T; test_case++) {
//			N = Integer.parseInt(br.readLine());
//			processor = new int[N][N];
//			for (int r = 0; r < N; r++) {
//				st = new StringTokenizer(br.readLine());
//				for (int c = 0; c < N; c++) {
//					int input = Integer.parseInt(st.nextToken());
//					if(input == 1) {
//						processor[r][c] = input;
//					}
//					if(r == 0 || r == N - 1 || c == 0 || c == N - 1) {
//						continue;
//					}
//					cores.add(new Core(r, c));
//				}
//			}
//			
//			isConnected(0, 0, 0);
//			System.out.println("#" + test_case + " " + minWire);
//			maxCore = Integer.MIN_VALUE;
//			minWire = Integer.MAX_VALUE;
//		}
//	}
//
//	private static void isConnected(int idx, int coreNum, int wireLength) {
//		
//		if(idx == cores.size()) {
//			if(coreNum > maxCore) {
//				maxCore = coreNum;
//				minWire = wireLength;
//			}
//			else if(coreNum == maxCore) {
//				minWire = Math.min(minWire, wireLength);
//			}
//			return;
//		}
//		
//		Core idxCore = cores.get(idx);
//		for (int i = 0; i < 4; i++) {
//			int length = 0;
//			int nr = idxCore.r;
//			int nc = idxCore.c;
//			while(true) {
//				nr += dr[i];
//				nc += dc[i];
//				
//				if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
//					break;
//				}
//				
//				if(processor[nr][nc] == 1) {
//					length = 0;
//					break;
//				}
//				
//				length++;
//			}
//			
//			int connect_r = idxCore.r;
//			int connect_c = idxCore.c;
//			
//			for (int j = 0; j < length; j++) {
//				connect_r += dr[i];
//				connect_c += dc[i];
//				processor[connect_r][connect_c] = 1;
//			}
//			
//			if(length == 0) {
//				isConnected(idx + 1, coreNum, wireLength);
//			}
//			else {
//				isConnected(idx + 1, coreNum + 1, wireLength + length);
//		
//				connect_r = idxCore.r;
//				connect_c = idxCore.c;
//				
//				for (int j = 0; j < length; j++) {
//					connect_r += dr[i];
//					connect_c += dc[i];
//					processor[connect_r][connect_c] = 0;
//				}
//			}
//		}
//	}
//}

import java.util.*;
import java.io.*;

class Solution_1767_김민주 {
	static class Core {
		int r, c;

		public Core(int r, int c) {
			this.c = c;
			this.r = r;
		}
	}

	static int N, processor[][], minWire, maxCore;
	static int dc[] = { 0, 0, -1, 1 }; // 상 하 좌 우
	static int dr[] = { -1, 1, 0, 0 };
	static List<Core> coreList;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			processor = new int[N][N];
			coreList = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int in = Integer.parseInt(st.nextToken());
					if (in == 1) {
						processor[i][j] = in;

						// 가장자리에 있는 코어 저장 안함
						if (i == 0 || j == 0 || i == N - 1 || j == N - 1)
							continue;
						coreList.add(new Core(i, j)); // 행, 열
					}

				}
			}

			minWire = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;

			isConnected(0, 0, 0);

			sb.append("#" + t + " " + minWire + "\n");
		}

		System.out.println(sb.toString());
	}

	public static void isConnected(int idx, int coreCnt, int wireCnt) {
		if (idx == coreList.size()) {
			if (maxCore < coreCnt) { // 최대한 많은 core에 연결할 경우
				maxCore = coreCnt;
				minWire = wireCnt;
			} else if (maxCore == coreCnt) { // 전선길이의 합 최소
				minWire = Math.min(wireCnt, minWire);
			}
			return;
		}

		int c = coreList.get(idx).c;
		int r = coreList.get(idx).r;

		for (int dir = 0; dir < 4; dir++) {
			int count = 0, nr = r, nc = c;

			while (true) {
				nr += dr[dir];
				nc += dc[dir];

				// 범위를 벗어나면 멈춤
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
					break;
				}

				// 방해물 존재할 경우 빠져나옴
				if (processor[nr][nc] == 1) {
					count = 0;
					break;
				}

				// 어떠한 방해도 없다면 +1
				count++;
			}

			// count 갯수만큼 1로 채워줌
			int connected_c = c;
			int connected_r = r;

			for (int i = 0; i < count; i++) {
				connected_c += dc[dir];
				connected_r += dr[dir];
				processor[connected_r][connected_c] = 1;
			}

			if (count == 0)
				isConnected(idx + 1, coreCnt, wireCnt);
			else {
				isConnected(idx + 1, coreCnt + 1, wireCnt + count);

				// 원본맵을 다시 0으로 되돌림
				connected_c = c;
				connected_r = r;

				for (int i = 0; i < count; i++) {
					connected_c += dc[dir];
					connected_r += dr[dir];
					processor[connected_r][connected_c] = 0;
				}
			}
		}
	}
}