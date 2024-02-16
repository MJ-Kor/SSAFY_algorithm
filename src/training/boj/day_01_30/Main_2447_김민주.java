package training.boj.day_01_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main_2447_김민주 {
	public static char[][] stars;
	public static void star(int n) {
		if (n == 1) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(i == 1 && j == 1) {
						System.out.print(" ");
					}
					else {
						
					}
				}
			}
		}
		
		int size = n / 3;
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		stars = new char[N][N];
		star(N);
	}

}
