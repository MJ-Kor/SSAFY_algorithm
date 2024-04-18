package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_14002_김민주 {

	private static int[] dp;
	private static int[] arr;
	private static int INT = -1_000_000_001;
	
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
		dp[len] = INT;
		for (int i = 0; i < N; i++) {
			if(arr[i] > dp[len]) {
				len++;
				dp[len] = arr[i];
				result[i] = len;
			}
			else {
				idx = binarySearchLIS(arr[i], 0, len);
				dp[idx] = arr[i];
				result[i] = idx;
			}
		}
		
		System.out.println(len);
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		for (int i = N - 1; i >= 0; i--) {
			if(result[i] == len) {
				stack.push(arr[i]);
				len--;
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()+" ");
		}
		System.out.println(sb.toString());
	}

	private static int binarySearchLIS(int value, int start, int end) {
		if(start > end) return start;
		
		int mid = (start + end) / 2;
		
		if(dp[mid] < value) return binarySearchLIS(value, mid + 1, end);
		else return binarySearchLIS(value, start, mid - 1);
	}

}
