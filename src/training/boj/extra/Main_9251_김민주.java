package training.boj.extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9251_김민주 {
	
	private static String s1;
	private static String s2;
	private static int[][] dp;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s1 = br.readLine();
		s2 = br.readLine();
		dp = new int[s2.length() + 1][s1.length() + 1];
		
		for (int c = 1; c <= s1.length(); c++) {
			for (int r = 1; r <= s2.length(); r++) {
				if(s1.charAt(c - 1) == s2.charAt(r - 1)) {
					dp[r][c] = dp[r - 1][c - 1] + 1; 
				}
				else {
					dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
				}
			}
		}
		
		System.out.println(dp[s2.length()][s1.length()]);
	}
}
