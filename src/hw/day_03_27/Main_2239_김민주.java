package hw.day_03_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2239_김민주 {
	
	private static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
	}

	private static List<Point> points = new ArrayList<>();
	private static int[][] map = new int[9][9];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String row = null;
		
		for (int i = 0; i < 9; i++) {
			row = br.readLine();
			for (int j = 0; j < 9; j++) {
				int value = row.charAt(j) - '0';
				map[i][j] = value;
				if(value != 0) continue;
				points.add(new Point(i, j));
			}
		}
		
		perm(0);
		
	}

	private static void perm(int cnt) {
		if(cnt == points.size()) {
			
			StringBuilder row = null;
			
			for (int i = 0; i < 9; i++) {
				row = new StringBuilder();
				for (int j = 0; j < 9; j++) {
					row.append(map[i][j]);
				}
				System.out.println(row);
			}
			System.exit(0);
		}
		
		int row = points.get(cnt).r;
		int col = points.get(cnt).c;
		for (int i = 1; i <= 9; i++) {
			if(promising(row, col, i)) {
				map[row][col] = i;
				perm(cnt + 1);
			}
			
		}
		map[row][col] = 0;
		return;
	}

	private static boolean promising(int row, int col, int i) {
		for (int j = 0; j < 9; j++) {
			if(map[j][col] == i) {
				return false;
			}
		}
		
		for (int j = 0; j < 9; j++) {
			if(map[row][j] == i) {
				return false;
			}
		}
		
		int pointRow = (row/3) * 3;
		int pointCol = (col/3) * 3;
		
		for (int j = pointRow; j < pointRow + 3; j++) {
			for (int k = pointCol; k < pointCol + 3; k++) {
				if(map[j][k] == i) {
					return false;
				}
			}
		}
		
		return true;
	}
		
}
