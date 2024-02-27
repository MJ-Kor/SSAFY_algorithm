package training.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_연습문제2_김민주 {
	
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		dp[1] = 2;
		
		for (int i = 2; i <= N; i++) {
			if(i % 2 == 0) {
				dp[i] = dp[i - 1] * 2 + 1;
			}
			else {
				dp[i] = dp[i - 1] * 2;
			}
		}
		
		System.out.println(dp[N]);
	}
}