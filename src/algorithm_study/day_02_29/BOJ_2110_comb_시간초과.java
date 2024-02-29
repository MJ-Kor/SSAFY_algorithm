package algorithm_study.day_02_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110_comb_시간초과 {

	private static int N;
	private static int C;
	private static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[] numbers = new int[C];
		int[] homes = new int[N];
		
		for (int i = 0; i < N; i++) {
			homes[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(homes);
		comb(0, 0, homes, numbers);
		
		System.out.println(max);
	}

	private static void comb(int cnt, int start, int[] homes, int[] numbers) {
		if(cnt == C) {
			getDistance(numbers);
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = homes[i];
			comb(cnt + 1, i + 1, homes, numbers);
		}
	}

	private static void getDistance(int[] numbers) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < C - 1; i++) {
			min = Math.min(min, Math.abs(numbers[i + 1] - numbers[i]));
		}
		max = Math.max(max, min);
	}

}
