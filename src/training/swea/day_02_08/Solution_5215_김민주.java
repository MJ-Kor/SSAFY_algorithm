package training.swea.day_02_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_김민주 {
	
	private static int T, N, L;
	private static int[] tastes, calories;
	private static int maxTaste;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			maxTaste = Integer.MIN_VALUE;
			tastes = new int[N];
			calories = new int[N];
			
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				tastes[n] = Integer.parseInt(st.nextToken());
				calories[n] = Integer.parseInt(st.nextToken());
			}
			
			powerSet(0, 0, 0);
			System.out.println("#" + test_case + " " + maxTaste);
		}
		
	}
	
	public static void powerSet(int cnt, int taste, int calory) {
		if(cnt == N) {
			if(maxTaste < taste && calory <=L) {
				maxTaste = taste;
			}
			return;
		}
		
		powerSet(cnt + 1, taste + tastes[cnt], calory + calories[cnt]);
		powerSet(cnt + 1, taste, calory);
		
	}
}
