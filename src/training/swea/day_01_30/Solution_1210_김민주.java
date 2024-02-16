package training.swea.day_01_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_김민주 {
	public static int MAX = 100;
	public static int[][] map = new int[MAX][MAX];

	public static int ladder(int r, int c) {

		if (r == 0) {
			return c;
		}

		map[r][c] = 0;
		
		
		if (c > 0 && map[r][c - 1] == 1) {
			return ladder(r, c - 1);
		} else if (c < 99 && map[r][c + 1] == 1) {
			return ladder(r, c + 1);
		} else {
			return ladder(r - 1, c);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = 10;
		int result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			int num = Integer.parseInt(br.readLine());
			int loc_r = 0;
			int loc_c = 0;
			for (int r = 0; r < MAX; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < MAX; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if (map[r][c] == 2) {
						loc_r = r;
						loc_c = c;
					}
				}
			}
			result = ladder(loc_r, loc_c);
			System.out.println("#" + num + " " + result);
		}
	}

}
