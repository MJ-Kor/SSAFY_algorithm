package training.boj.extra.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_24416_김민주 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int num = fib(N);
		System.out.println(num + " " + (N - 2));
	}

	private static int fib(int n) {
		
		if(n == 1 || n == 2) {
			return 1;
		}
		else return(fib(n - 1) + fib(n - 2));	
	}
}
