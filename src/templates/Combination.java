package templates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// nCr: n개중 r개를 뽑는다.
public class Combination {

	private static int N, R;
	private static int[] numbers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		numbers = new int[R];
		
		comb(0, 1);
		
	}

	private static void comb(int cnt, int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

}
