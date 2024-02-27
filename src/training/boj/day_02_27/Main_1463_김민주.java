package training.boj.day_02_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_김민주 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N + 1];
		
		dp[1] = 0;
		
		for (int i = 2; i <= N; i++) {
			if((i % 2) == 0 && (i % 3) == 0) {
				dp[i] = Math.min(Math.min(dp[i / 2], dp[i / 3]), dp[i - 1]) + 1;
			} 
			else if ((i % 2) == 0) {
				dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
			}
			else if ((i % 3) == 0) {
				dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
			}
			else {
				dp[i] = dp[i - 1] + 1;
			}
		}
		
		System.out.println(dp[N]);
	}

}
