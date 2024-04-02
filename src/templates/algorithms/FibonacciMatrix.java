package templates.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciMatrix {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		long[][] origin = {{1, 1}, {1, 0}};
		
		System.out.println(fibonacciWithMatrix(origin, N - 1));
		
	}
	
	private static long fibonacciWithMatrix(long[][] origin, long N) {
		long[][] m = {{1, 0}, {1, 0}};
		
		long[][] mat = divideAndConquerPower(origin, N);
		
		long result = matmul(mat, m)[1][0];
		
		return result;
	}

	private static long[][] divideAndConquerPower(long[][] origin, long exp) {
		if(exp == 1 || exp == 0) {
			return origin;
		}
		
		long[][] res = divideAndConquerPower(origin, exp / 2);
		
		res = matmul(res, res);
		
		if(exp % 2 == 1) {
			res = matmul(res, origin);
		}
		
		return res;
	}

	private static long[][] matmul(long[][] A, long[][] B) {
		
		long[][] result = new long[2][2];
		
		result[0][0] = A[0][0] * B[0][0] + A[0][1] * B[1][0];
		result[0][1] = A[0][0] * B[0][1] + A[0][1] * B[1][1];
		result[1][0] = A[1][0] * B[0][0] + A[1][1] * B[1][0];
		result[1][1] = A[1][0] * B[0][1] + A[1][1] * B[1][1];
		
		return result;
	}

}
