package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2447_김민주 {
	
	private static int N;	
	private static char[][] stars;
	private static void printStars(int n, int r, int c, boolean blank) {
		

		if(blank) {
			for(int i = r; i < r + n; i++) {
				for(int j = c; j < c + n; j++) {
					stars[i][j] = ' ';
				}
			}
			return;
		}
		
		if(n == 1) {
			stars[r][c] = '*';
			return;
		}
		
		
		int size = n / 3;
		int count = 0;
		
		for(int i = r; i < r + n; i += size) {
			for(int j = c; j < c + n; j += size) {
				count++;
				if(count == 5) {
					printStars(size, i, j, true);
				}
				else {
					printStars(size, i, j, false);
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stars = new char[N][N];
		
		printStars(N, 0, 0, false);
		
		
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				sb.append(stars[r][c]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
	}

}
