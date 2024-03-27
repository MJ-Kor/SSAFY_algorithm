package algorithm_study.day_03_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3649 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while((str = br.readLine()) != null && !str.isEmpty()) {
			int x = Integer.parseInt(str) * 10000000;
			int n = Integer.parseInt(br.readLine());
			int[] numbers = new int[n];
			for (int i = 0; i < n; i++) {
				numbers[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(numbers);

			int start = 0;
			int end = n - 1;
			int max = Integer.MIN_VALUE;
			int sLego = -1;
			int eLego = -1;
			boolean result = false;
			
			while(start < end) {
				int sum = numbers[start] + numbers[end];
				
				if(sum == x) {
					int diff = Math.abs(numbers[start] - numbers[end]);
					if(max < diff) {
						max = diff;
						sLego = numbers[start];
						eLego = numbers[end];
						result = true;

					}
					start += 1;
				} else if (sum > x) {
					end -= 1;
				} else if (sum < x) {
					start += 1;
				}
			}
			
			if(result) {
				System.out.println("yes " + sLego + " " + eLego );
			} else {
				System.out.println("danger");
			}
		}
	}

}
