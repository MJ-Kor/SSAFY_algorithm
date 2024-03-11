package templates.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Permutation {
	
	private static int N;
	private static int R;
	private static int[] numbers;
	private static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		numbers = new int[R];
		isSelected = new boolean[N + 1];
		
		perm(0);
	}

	private static void perm(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			numbers[cnt] = i;
			perm(cnt + 1);
			numbers[cnt] = 0;
			isSelected[i] = false;
		}
	}

}
