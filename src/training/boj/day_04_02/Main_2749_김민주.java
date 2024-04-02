package training.boj.day_04_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_2749_김민주 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int m = 1000000;
		int p = 1500000; // 15 * 10^(k - 1)
		BigInteger N = new BigInteger(br.readLine());
		BigInteger P = new BigInteger("1500000");
		BigInteger target = N.remainder(P);
		int o = target.intValue();
		int[] arr = new int[p + 1];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= p; i++) {
			 arr[i] = (arr[i - 1] + arr[i - 2])%m;
		}
		System.out.println(arr[o]);
		
	}
}
