package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2467_김민주 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] solutions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int low = 0;
		int high = N - 1;
		int sum = 0;
		int ansLow = low;
		int ansHigh = high;
		int min = Integer.MAX_VALUE;
		
		while(low < high) {
			sum = solutions[low] + solutions[high];
			if(min > Math.abs(sum)){
				min = Math.abs(sum);
				ansLow = low;
				ansHigh = high;
			}
			if(sum == 0) {
				break;
			}
			else if(sum < 0) {
				low += 1;
			}
			else {
				high -= 1;
			}
		}
		System.out.println(solutions[ansLow] + " " + solutions[ansHigh]);
	}

}
