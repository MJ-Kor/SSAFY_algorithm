package hw.day_01_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 달팽이 숫자
 * @author SSAFY
 *
 */
public class Solution_1954_김민주 {
	
	// 방향 벡터
	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};
	
	// map
	public static int [][] map;
	
	// 전진 유효성 판단
	public static boolean indexValid(int N, int r, int c) {
		
		// 먼저 인덱스 범위를 벗어나지 않았는가
		if(r >= 0 && r < N && c >= 0 && c < N) {
			
			// 가려는 칸이 비어있는가
			if(map[r][c] == 0)
				return true;
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int cnt = 1;
			int dir = 0;
			int r = 0;
			int c = 0;
			int nr;
			int nc;
			
			// 첫 칸에 넣고 시작
			map[r][c] = cnt;
			while (cnt < N*N) {
				cnt += 1;
				nr = r + dr[dir];
				nc = c + dc[dir];
				
				// 유효성 입증되면 전진
				if(indexValid(N, nr, nc)) {
					if (map[nr][nc] == 0) {
						map[nr][nc] = cnt;
						r = nr;
						c = nc;
					}
				}
				
				// 유효성 입증되지 않으면 방향을 바꿈
				else {
					dir = (dir + 1) % 4;
					nr = r + dr[dir];
					nc = c + dc[dir];
					map[nr][nc] = cnt;
					r = nr;
					c = nc;
				}
			}
			
			// 출력
			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
