package training.boj.extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_김민주 {

	private static int R, C;
	private static int[][] map;
	private static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str;
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			str = br.readLine();
			for (int c = 0; c < C; c++) {
				if(str.charAt(c) == '.') map[r][c] = 0;
				else if(str.charAt(c) == 'x') map[r][c] = 1;
			}
		}
		for (int r = 0; r < R; r++) {
			if(connectPipe(r, 0)) result++;
		}
		System.out.println(result);	
	}
	
	public static boolean connectPipe(int row, int col) {
		map[row][col] = 1;
		if(col == C - 1) {
			return true;
		}
		if(row - 1 >= 0 && row - 1 < R && map [row - 1][col + 1] == 0) { 
			if(connectPipe(row - 1, col + 1)) return true;
		}
		if(row >= 0 && row < R && map [row][col + 1] == 0) {
			if(connectPipe(row, col + 1)) return true;
		}
		if(row + 1 >= 0 && row + 1 < R && map [row + 1][col + 1] == 0) {
			if(connectPipe(row + 1, col + 1)) return true;
		}
		return false;
	}
}