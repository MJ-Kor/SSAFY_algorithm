package hw.day_02_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_김민주 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] color = new int[3][N];
		int[][] dp = new int[3][N];
		
		for (int c = 0; c < N; c++) {
			st = new StringTokenizer(br.readLine());
			for (int r = 0; r < 3; r++) {
				color[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 초기값 설정
		dp[0][0] = color[0][0];
		dp[1][0] = color[1][0];
		dp[2][0] = color[2][0];
		
		// 
		for (int i = 1; i < N; i++) {
			// 지금 선택한게 r인경우, 마지막 선택이 g, b인 경우 중 최소
			dp[0][i] = color[0][i] + Math.min(dp[1][i-1], dp[2][i-1]);
			// 지금 선택한게 g인경우, 마지막 선택이 r, b인 경우 중 최소
			dp[1][i] = color[1][i] + Math.min(dp[0][i-1], dp[2][i-1]); 
			// 지금 선택한게 b인경우, 마지막 선택이 r, g인 경우 중 최소
			dp[2][i] = color[2][i] + Math.min(dp[0][i-1], dp[1][i-1]);
		}
		
		int min = Math.min(dp[0][N-1], dp[1][N-1]);
		System.out.println(Math.min(min, dp[2][N-1]));
	}

}
