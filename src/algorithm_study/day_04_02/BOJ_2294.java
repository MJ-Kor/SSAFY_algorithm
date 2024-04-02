package algorithm_study.day_04_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[n + 1];
		int[][] dp = new int[n + 1][k + 1];
		
		for (int i = 1; i <= n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(coin);
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if(i == 1) {
					if(j % coin[i] == 0) dp[i][j] = j / coin[i];
				} else {
					if(j < coin[i]) {
						dp[i][j] = dp[i - 1][j];
					} else {						
						if(j % coin[i] == 0) {
							dp[i][j] = j / coin[i];
						} else {
							if(dp[i - 1][j] == 0 && dp[i][j - coin[i]] + dp[i][coin[i]] == 0) {
								dp[i][j] = 0;
							} else if(dp[i - 1][j] == 0 && dp[i][j - coin[i]] != 0) {
								dp[i][j] = dp[i][j - coin[i]] + dp[i][coin[i]];
							} else if(dp[i - 1][j] != 0 && dp[i][j - coin[i]] == 0) {
								dp[i][j] = dp[i - 1][j];
							} else {								
								dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coin[i]] + dp[i][coin[i]] );
							}
						}
					}
				}
			}
		}
		
		if(dp[n][k] == 0) {
			System.out.println(-1);
		} else {			
			System.out.println(dp[n][k]);
		}
	}

}
