package training.boj.day_01_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660_김민주 {

	public static int[][] dp;
	public static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		dp = new int[N][N];
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int e = Integer.parseInt(st.nextToken());
				arr[i][j] = e;
				if(i - 1 < 0 && j - 1 >= 0) { 
					dp[i][j] = dp[i][j-1] + e;
				}
				else if(i - 1 >= 0 && j - 1 < 0) {
					dp[i][j] = dp[i-1][j] + e;
				}
				else if (i - 1 < 0 && j - 1 < 0) {
					dp[i][j] = e;
				}
				else {
					dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + e;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken())-1;
			int y1 = Integer.parseInt(st.nextToken())-1;
			int x2 = Integer.parseInt(st.nextToken())-1;
			int y2 = Integer.parseInt(st.nextToken())-1;
			int target;
			if (x1 == x2 && y1 == y2) {
				target = arr[x2][y2];
			}
			else {
				if(x1 - 1 >= 0 && y1 - 1 < 0) { 
					target = dp[x2][y2] - dp[x1 - 1][y2];
				}
				else if(x1 - 1 < 0 && y1 - 1 >= 0) {
					target = dp[x2][y2] - dp[x2][y1 - 1];
				}
				else if (x1 - 1 < 0 && y1 - 1 < 0) {
					target = dp[x2][y2];
				}
				else {
					target = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
				}
			}
			
			System.out.println(target);
		}
		
	}

}
