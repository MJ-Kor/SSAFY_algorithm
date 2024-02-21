package training.boj.day_02_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15683_김민주 {
	
	static class CCTV{
		int r;
		int c;
		int cctvType;
		public CCTV(int r, int c, int cctvType) {
			super();
			this.r = r;
			this.c = c;
			this.cctvType = cctvType;
		}
	}
	private static int min = Integer.MAX_VALUE;
	private static int N, M;
	private static int[] cctvDirCaseNum = {-1, 4, 2, 4, 4, 1};
	private static int[] numbers;
	private static int[][] map;
	private static int[][] cctv1 = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	private static int[][][] cctv2 = {{cctv1[0], cctv1[2]}, {cctv1[1], cctv1[3]}};
	private static int[][][] cctv3 = {{cctv1[0], cctv1[1]}, {cctv1[1], cctv1[2]}, {cctv1[2], cctv1[3]}, {cctv1[3], cctv1[0]}};
	private static int[][][] cctv4 = {{cctv1[0], cctv1[1], cctv1[2]}, {cctv1[1], cctv1[2], cctv1[3]}, {cctv1[2], cctv1[3], cctv1[0]}, {cctv1[3], cctv1[0], cctv1[1]}};
	private static int[][][] cctv5 = {{cctv1[0], cctv1[1], cctv1[2], cctv1[3]}};
	private static List<CCTV> cctvs = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				// CCTV를 리스트에 저장
				if(map[r][c] != 0 && map[r][c] != 6) { 
					cctvs.add(new CCTV(r, c, map[r][c]));
				}
			}
		}
		numbers = new int[cctvs.size()];
		cctvComb(0);
		System.out.println(min);
	}

	// 각 CCTV가 감시할 수 있는 방향을 조합으로 생성
	public static void cctvComb(int cnt) {
		if(cnt == cctvs.size()) {
			// 다 뽑으면 감시 시작
			monitor(deepCopy(map));
			return;
		}
		for (int i = 0; i < cctvDirCaseNum[cctvs.get(cnt).cctvType]; i++) {
			numbers[cnt] = i;
			cctvComb(cnt + 1);
		}
	}
	
	// CCTV로 감시
	public static void monitor(int[][] map) {
		int blindSpot = 0;
		int cctvSize = cctvs.size();
		// 각 CCTV에 대해 감시, type: CCTV 번호
		for (int i = 0; i < cctvSize; i++) {
			int type = cctvs.get(i).cctvType;
			if(type == 1) {
				int k = 1;
				CCTV cctv = cctvs.get(i);
				int[] cctvDir = cctv1[numbers[i]];
				int nr = cctv.r + cctvDir[0] * k;
				int nc = cctv.c + cctvDir[1] * k;
				while(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 6) {
					if(map[nr][nc] == 0) map[nr][nc] = -1;
					++k;
					nr = cctv.r + cctvDir[0] * k;
					nc = cctv.c + cctvDir[1] * k;
				}
			}else if(type == 2) {
				checkMap(cctvs.get(i), map, cctv2[numbers[i]]);
			}else if(type == 3) {
				checkMap(cctvs.get(i), map, cctv3[numbers[i]]);
			}else if(type == 4) {
				checkMap(cctvs.get(i), map, cctv4[numbers[i]]);
			}else if(type == 5) {
				checkMap(cctvs.get(i), map, cctv5[numbers[i]]);
			}
		}
		
		// 다 감시했으면 사각지대 파악
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(map[r][c] == 0) blindSpot++;
			}
		}
		if(blindSpot < min) min = blindSpot;
	}
	
	// Map에 감시하는 곳 표시
	public static void checkMap(CCTV cctv, int[][] map, int cctvDir[][]) {
		for (int j = 0; j < cctvDir.length; j++) {
			int k = 1;
			int nr = cctv.r + cctvDir[j][0] * k;
			int nc = cctv.c + cctvDir[j][1] * k;
			while(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 6) {
				if(map[nr][nc] == 0) map[nr][nc] = -1;
				++k;
				nr = cctv.r + cctvDir[j][0] * k;
				nc = cctv.c + cctvDir[j][1] * k;
			}
		}
	}
	
	public static int[][] deepCopy(int[][] original){
		if (original == null) return null;
		int[][] copied = new int[original.length][original[0].length];
		for (int i = 0; i < copied.length; i++) {
			System.arraycopy(original[i], 0, copied[i], 0, original[0].length);
		}
		return copied;
	}
	
}
