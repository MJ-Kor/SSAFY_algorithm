package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14002_김민주 {

	private static int[] dp;
	private static int[] arr;
	private static int INT = 1_000_000_001;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N + 1];
		int[] result = new int[N + 1];
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		int len = 0;
		for (int i = 0; i < N; i++) {
			if(arr[i] > dp[len]) {
				len++;
				dp[len] = arr[i];
			}
			else {
				idx = binarySearchLIS(arr[i], 0, len);
				dp[idx] = arr[i];
			}
		}
		printResult(N, len);
	}

	private static void printResult(int N, int len) {
		int[] result = new int[len];
		int idx = 0;
		int max = dp[len];
		System.out.println(len);
		Arrays.sort(arr);
		result[idx] = max;
		idx++;
		for (int i = N - 1; i >= 0; i--) {
			if(max > arr[i]) {
//				System.out.print(arr[i] + " ");
				result[idx] = arr[i];
				idx++;
				max = arr[i];
			}
		}
		for (int i = len - 1; i >= 0; i--) {
			System.out.print(result[i] + " ");
		}
	}

	private static int binarySearchLIS(int value, int start, int end) {
		if(start > end) return start;
		
		int mid = (start + end) / 2;
		
		if(dp[mid] < value) return binarySearchLIS(value, mid + 1, end);
		else return binarySearchLIS(value, start, mid - 1);
	}

}
