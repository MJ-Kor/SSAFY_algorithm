package training.boj.day_02_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010_김민주 {

	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			dp = new int[M + 1][N + 1];
			for (int m = 0; m <= M; m++) {
				for (int n = 0, end = Math.min(m, N); n <= end ; n++) {
					if(n == 0 || n == m) {
						dp[m][n] = 1;
					}
					else {
						dp[m][n] = dp[m - 1][n - 1] + dp[m - 1][n];
					}
				}
			}
			System.out.println(dp[M][N]);
		}
	}
}
