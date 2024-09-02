package algorithm_study.september.day_09_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1992 {
    private static int N;
	private static int[][] map;
//	private static String[] map;

	public static void main(String[] args) throws NumberFormatException, IOException, IOException {
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


		if(size == 1) {
			System.out.print(map[r][c]);
			return;
		}

		int sum = 0;
		for (int nr = r; nr < r + size; nr++) {
			for (int nc = c; nc < c + size; nc++) {
				sum += map[nr][nc];
			}
		}

		if(sum == 0 || sum == size*size) {
			if(sum == 0) System.out.print(0);
			else System.out.print(1);
			return;
		}

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
