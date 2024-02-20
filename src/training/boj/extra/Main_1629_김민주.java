package training.boj.extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1629_김민주 {

	private static long A, B, C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		//System.out.println((1.0*(A/C)));
		//double mod = (A / C) - (1.0 * (int)(A / C)); 
//		for (int i = 1; i < B; i++) {
//			mod = (A * mod) - (1.0 * (int)(A * mod));
//		}
		//System.out.println((int)(mod * C));
		System.out.println(power(A % C, B, C));
		
	}
	
	public static long power(long a, long b, long c) {
		if (b == 1) {
			return a;
		}
		
		long res = power(a, b / 2, c) % c ;
		
		if (b % 2 == 0) {
			return (res * res) % c;
		}
		
		else {
			return (((res * res) % c) * a) % c;
		}
	}

}

