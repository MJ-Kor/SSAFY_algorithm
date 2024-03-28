package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12738_김민주 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[] LIS = new int[N + 1];
		int[] numbers = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			LIS[i] = 1;
			for (int j = 1; j < i; j++) {
				if(numbers[i] > numbers[j] && LIS[i] <= LIS[j]) {
					LIS[i] = LIS[j] + 1;
				}
			}
		}
		
		int max = LIS[1];
		for (int i = 2; i <= N; i++) {
			max = Math.max(max, LIS[i]);
		}
		
		System.out.println(max);
	}

}
