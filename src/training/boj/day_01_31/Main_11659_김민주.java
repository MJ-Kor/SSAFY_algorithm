package training.boj.day_01_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11659_김민주 {

	/**
	 * arr: 숫자 저장 배열
	 * dp: 구간 합 저장 배열
	 */
	public static int N;
	public static int M;
	public static int[] arr;
	public static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int i, j;
		dp = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		for (int k = 1; k <= N; k++) {
			arr[k] = Integer.parseInt(st.nextToken());
			
			// dp 생성
			dp[k] = dp[k-1] + arr[k];
		}
		
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			
			// 구간합 구하기
			System.out.println(dp[j] - dp[i-1]);
		}
	}
}
