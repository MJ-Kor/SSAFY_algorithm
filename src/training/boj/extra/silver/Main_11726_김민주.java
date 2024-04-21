package training.boj.extra.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11726_김민주 {
	
	private static final int mod = 10_007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N + 1];
		dp[1] = 1;
		if(N == 1) {
			System.out.println(dp[1]);
			System.exit(0);
		}
		dp[2] = 3;
		if(N == 2) {
			System.out.println(dp[2]);
			System.exit(0);
		}
		for (int i = 3; i <= N; i++) {
			dp[i] = ((dp[i - 1] % mod) + ((2 * (dp[i - 2] % mod))% mod) % mod) % mod;
		}
		
		System.out.println(dp[N]);
	}

}
