package training.boj.day_02_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_김민주 {

	private static int R, C;
	private static int[][] map;
	private static int[] upDiagonal = {-1, 1};
	private static int[] right = {0, 1};
	private static int[] downDiagonal = {1, 1};

	
	
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
			
		}
		
	}
	
	public static void connectPipe(int start, int col) {
		if(col == C) {
			
		}
		
		// 위, 옆, 아래 순으로 탐색
		for (int row = start; row < start + 2; row++) {
			// 범위를 벗어나거나 벽인 경우는 뛰어 넘음
			if(row >= 0 && row < R && map [row][col] != 0) continue;
			connectPipe(row - 1, col + 1);
			
		}
	}

}

