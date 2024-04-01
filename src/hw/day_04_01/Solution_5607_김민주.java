package hw.day_04_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_김민주 {

	private static long P = 1234567891;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			long R = Long.parseLong(st.nextToken());
			long A = factorial(N);
			long B = factorial(R) * factorial(N - R) % P;
			System.out.println("#" + test_case + " " + A * power(B, P - 2) % P);
		}
	}

	private static long factorial(long N) {
		long fac = 1L;
		
		while(N > 1) {
			fac = (fac * N) % P;
			N--;
		}
		return fac;
	}
	
	private static long power(long a, long n) {
		if(n == 1) {
			return a % P;
		}
		long temp = power(a, n / 2);
		if(n % 2 == 1) {
			return temp = (temp * temp % P) * a % P;
		}
		return temp * temp % P;
	}
}
