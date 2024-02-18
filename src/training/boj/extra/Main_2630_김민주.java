package training.boj.extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2630_김민주 {

	private static int N;
	private static int[][] map;
	private static int white = 0;
	private static int blue = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			map[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		divide(N, 0, 0);
		
		System.out.println(white);
		System.out.println(blue);
		
	}

	public static void divide(int size, int startR, int startC) {
		
		int sum = 0;
		
		for (int r = startR; r < startR + size; r++) {
			for (int c = startC; c < startC + size; c++) {
				sum += map[r][c];
			}
		}
		
		if(sum == 0) {
			white++;
			return;
		}
		
		if(sum == size*size) {
			blue++;
			return;
		}
		
		divide(size/2, startR, startC);
		divide(size/2, startR, startC + size/2);
		divide(size/2, startR + size/2, startC);
		divide(size/2, startR + size/2, startC + size/2);
	}
	
}
