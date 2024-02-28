package hw.day_02_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1767_김민주 {
	
	private static final class Core{
		int r, c;
		int up = 0, down = 0, left = 0, right = 0;

		public Core(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	private static final List<Core> cores = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int[][] processor;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			processor = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					processor[r][c] = Integer.parseInt(st.nextToken());
					if(processor[r][c] == 1) {
						cores.add(new Core(r, c));
					}
				}
			}
		}
	}
	
	private static void perm(int cnt) {
		if(cnt == cores.size()) {
			return;
		}
	}
}
