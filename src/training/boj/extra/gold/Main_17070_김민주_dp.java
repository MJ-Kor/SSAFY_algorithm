package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17070_김민주_dp {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][][] dp = new int[N][N][3];
		dp[0][1][0] = 1;
		
		for (int r = 0; r < N; r++) {
			map[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 2; c < N; c++) {
				
				if(map[r][c] == 1) continue;
				
				dp[r][c][0] = dp[r][c - 1][0] + dp[r][c - 1][2];
				
				if(r == 0) {
					continue;
				}
				
				dp[r][c][1] = dp[r - 1][c][1] + dp[r - 1][c][2];
				
				if(map[r - 1][c] == 1 || map[r][c - 1] == 1) {
					continue;
				}
				
				dp[r][c][2] = dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2];
			}
		}
		
		System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
	}

}
