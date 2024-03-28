package training.swea.day_03_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263_김민주 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int min = Integer.MAX_VALUE;
			int[] node = new int[N];
			int[][] dp = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					dp[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			init(dp, N);
			
			for (int i = 0; i < N; i++) {
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						dp[r][c] = Math.min(dp[r][i] + dp[i][c], dp[r][c]);
					}
				}
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					node[r] += dp[r][c];
				}
			}
			
			for (int i = 0; i < N; i++) {
				min = Math.min(min, node[i]);
			}
			
			System.out.println("#" + test_case + " " + min);
		}
	}

	private static void init(int[][] dp, int N) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(r == c) continue;
				if(dp[r][c] == 0) {
					dp[r][c] = N;
				}
			}
		}
	}

}
