package hw.day_02_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1992_김민주 {

	private static int N;
	private static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		String str;
		map = new int[N][N];		
		for (int r = 0; r < N; r++) {
			str = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		
		quadTree(N, 0, 0);
		
	}
	
	public static void quadTree(int size, int r, int c) {
		
		// 크기가 1일 경우는 무조건 0 아니면 1
		if(size == 1) {
			System.out.print(map[r][c]);
			return;
		}
		
		// 해당 범위의 요소 합을 구해줌
		int sum = 0;
		for (int nr = r; nr < r + size; nr++) {
			for (int nc = c; nc < c + size; nc++) {
				sum += map[nr][nc];
			}
		}
		
		// 모든 요소가 0인지 1인지 판단
		if(sum == 0 || sum == size*size) {
			if(sum == 0) System.out.print(0);
			else System.out.print(1);
			return;
		}
		
		// 요소가 0과 1이 섞여있으면
		int newSize = size / 2;
		// 1사분면
		System.out.print("(");
		quadTree(newSize, r, c);
		// 2사분면
		quadTree(newSize, r, c + newSize);
		// 3사분면
		quadTree(newSize, r + newSize, c);
		// 4사분면
		quadTree(newSize, r + newSize, c + newSize);
		
		System.out.print(")");
	}

}
