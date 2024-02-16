package hw.day_02_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * map: 누적 합 저장 2차원 배열
 */
public class Solution_2001_김민주 {

	private static int[][] map;
	private static int T, N, M, x1, x2, y1, y2, sum;
	private static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N + 1][N + 1];
			
			// 누적 합 배열 생성
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					int e = Integer.parseInt(st.nextToken());
					map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1] + e;
				}
			}
			
			// 파리채 영역 이동하여 최대 파리 수 갱신
			for (int i = 1; i <= N + 1 - M; i++) {
				for (int j = 1; j <= N + 1 - M; j++) {
					
					x1 = i;
					y1 = j;
					x2 = x1 + M - 1;
					y2 = y1 + M - 1;
					sum = map[x2][y2] - map[x2][y1 - 1] - map[x1 - 1][y2] + map[x1 - 1][y1 - 1];
					if(max < sum) {
						max = sum;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + max);
			max = 0;
		}
	}
}
