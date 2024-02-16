package training.swea.day_02_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1247_김민주 {

	static class Coordinate{
		int x;
		int y;
		
		public Coordinate(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Coordinate [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	private static int T, N;
	private static int max;
	private static int[] input;
	private static Coordinate company, home;
	private static Coordinate[] cList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			max = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			input = new int[N];
			for (int i = 0; i < N; i++) {
				input[i] = i;
			}
			cList = new Coordinate[N];
			st = new StringTokenizer(br.readLine());
			company = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 0; i < cList.length; i++) {
				cList[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			
			// NextPermutation으로 모든 방문 순서에 대한 거리를 구하기
			do {
				
				int newDistance = getDistance();
				if(max > newDistance) {
					max = newDistance;
				}
				
			} while(np(input));
			
			System.out.println("#" + test_case + " " + max);
			
		}
	}
	
	public static boolean np(int[] p) {
		final int N = p.length;
		// step1: 교환위치 찾기 (뒤쪽부터 꼭대기를 찾으면 꼭대기 이전이 교환위치가 됨
		int i = N - 1;
		while(i > 0 && p[i - 1] >= p[i]) --i;
		
		if(i == 0) return false; // 현순열의 상태가 가장 큰 순열이므로 np 종료.
		
		// step2: 교환위치(i - 1)에 넣을 값 뒤쪽부터 찾기 (큰 값 중 최소 값)
		int j = N - 1;
		while(p[i - 1] >= p[j]) --j;
		
		// step3: 교환위치 (i - 1) 값과 찾은 위치 (j)값 교환
		swap(p, i - 1, j);
		
		// step4: 꼭대기(i) 위치부터 맨 뒤까지 오름차순 정렬
		int k = N - 1;
		while(i < k) swap(p, i++, k--);
		
		return true;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int getDistance() {
		
		int distance = 0;
		
		for (int i = 0; i < cList.length - 1; i++) {
			distance += (Math.abs(cList[input[i]].x - cList[input[i + 1]].x) + Math.abs(cList[input[i]].y - cList[input[i + 1]].y));
		}
		
		distance += (Math.abs(cList[input[0]].x - company.x) + Math.abs(cList[input[0]].y - company.y));
		distance += (Math.abs(cList[input[N - 1]].x - home.x) + Math.abs(cList[input[N - 1]].y - home.y));
		
		return distance;
	}
	
}
