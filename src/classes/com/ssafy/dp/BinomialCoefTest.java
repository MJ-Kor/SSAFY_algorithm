package classes.com.ssafy.dp;

import java.util.Arrays;
import java.util.Scanner;

public class BinomialCoefTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] B = new int[N + 1][K + 1];
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0, end = Math.min(i,  K); j <= end; j++) {
				if(j == 0 || j == i) B[i][j] = 1;
				else B[i][j] = B[i - 1][j - 1] + B[i - 1][j];
			}
			
		}
		for(int[] arr : B) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println(B[N][K]);
	}

}
