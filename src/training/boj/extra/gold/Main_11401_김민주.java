package training.boj.extra.gold;

/**
 * 어려운 이항계수 구하기
 * 다시 풀어볼 것
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11401_김민주 {
	
	final static long p = 1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		long numer = factorial(N);
		long denom = factorial(K) * factorial(N - K) % p;
		
		System.out.println(numer * pow(denom, p - 2) % p);
	}

	public static long factorial(long N) {
		long fac = 1L;
		
		while(N > 1) {
			fac = (fac * N) % p;
			N--;
		}
		return fac;
	}

	private static long pow(long base, long expo) {
		if(expo == 1) { 
			return base % p;
		}
		long temp = pow(base, expo / 2);

		if(expo % 2 == 1) {
			return temp = (temp * temp % p) * base % p;
		}
		return temp * temp % p;
	}
}