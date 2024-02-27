package training.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_연습문제1_김민주 {
	
	static int N;
	static int dy[];
	static int db[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dy = new int[N + 1];
		db = new int[N + 1];
		dy[1] = 1;
		db[1] = 1;
		for (int i = 2; i <= N; i++) {
			dy[i] = dy[i - 1] + db[i - 1];
			db[i] = dy[i - 1];
		}
		
		System.out.println(dy[N] + db[N]);
		
	}
}
