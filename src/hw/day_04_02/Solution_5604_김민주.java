package hw.day_04_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_5604_김민주 {
	
	private static HashMap<Long, Long> F = new HashMap<Long, Long>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		long sum = 0;
		for (long i = 0; i < 10; i++) {
			sum += i;
			F.put(i, sum);
		}
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			
//			System.out.println(findDigit(A));
			if(A > 0) {				
				System.out.println("#" + test_case + " " + (f(B) - f(A - 1)));
			} else {
				System.out.println("#" + test_case + " " + (f(B) - f(A)));
			}
			
		}
	}

	private static long findDigit(long num) {
		long cnt = 1;
		while(num / 10 != 0) {
			num /= 10;
			cnt *= 10;
		}
		return cnt ;
	}
	private static long f(long n) {
		if(F.containsKey(n)) return F.get(n);
		if(n < 10) return F.get(n);
		long v = findDigit(n);
		long f = f(n - 1 -(n % v));
		long g = (n / v) * (n % v + 1) + f(n % v);
		long num = f + g;
		F.put(n, num);
		return num;
	}

}
