package training.swea.day_02_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012_김민주 {

		private static int T;
		private static int N;
		private static int[][] synergy;
		private static boolean[] ingredients;
		private static int taste;
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			taste = Integer.MAX_VALUE;
			synergy = new int[N][N];
			ingredients = new boolean[N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					synergy[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			selectIngredient(0, 0);
			System.out.println("#" + test_case + " " + taste);
			
		}
	}

	public static void selectIngredient(int cnt, int start) {
		if(cnt == N / 2) {
			
			int sum_A = 0;
			int sum_B = 0;
			
			for (int i = 0; i < N; i++) {
				if(ingredients[i] == true) {
					for (int j = 0; j < N; j++) {
						if(j != i) { 
							if(ingredients[j] == true) {
								sum_A += synergy[i][j];
							}
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				if(ingredients[i] == false) {
					for (int j = 0; j < N; j++) {
						if(j != i) { 
							if(ingredients[j] == false) {
								sum_B += synergy[i][j];
							}
						}
					}
				}
			}
			int this_taste = Math.abs(sum_A - sum_B);
			if(this_taste < taste) {
				taste = this_taste;
			}
			
		}
		else {
			for (int i = start; i < N; i++) {
				ingredients[i] = true;
				selectIngredient(cnt + 1, i + 1);
				ingredients[i] = false;

			}
		}
	}
	
}

