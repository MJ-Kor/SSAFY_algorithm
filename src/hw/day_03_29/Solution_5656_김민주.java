package hw.day_03_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_김민주 {
	
	private static class Brick{
		int r, c, range;

		public Brick(int r, int c, int range) {
			super();
			this.r = r;
			this.c = c;
			this.range = range;
		}

		@Override
		public String toString() {
			return "Brick [r=" + r + ", c=" + c + ", range=" + range + "]";
		}
	}
	
	private static int min;
	private static int[] numbers;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	private static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			numbers = new int[N];
			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			perm(0, N, R, C);
			System.out.println("#" + test_case + " " + min);
		}
	}

	private static void perm(int cnt, int N, int R, int C) {
		if(cnt == N) {
			int[][] copied = copyArr(map);
			for (int i = 0; i < N ; i++) {
				int ballCol = numbers[i];
				crashBrick(copied, ballCol, R, C);
			}
			// 남아있는 블럭 최소 값 갱신
			min = Math.min(min, remainBrick(copied, R, C));
			return;
		}
		
		for (int i = 0; i < C; i++) {
			numbers[cnt] = i;
			perm(cnt + 1, N, R, C);
		}
	}

	private static int remainBrick(int[][] copied, int R, int C) {
		int cnt = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(copied[r][c] == 0) continue;
				cnt++;
			}
		}
		return cnt;
	}
	
	private static void crashBrick(int[][] copied, int ballCol, int R, int C) {
		boolean[][] visited = new boolean[R][C];
		// 구슬 시작 위치
		int ballRow = 0;
		
		// 깨질 벽돌을 담는 Queue
		Queue<Brick> queue = new ArrayDeque<>();
		
		// 구슬 쏘기
		while(ballRow < R) {
			if(copied[ballRow][ballCol] != 0) {
				visited[ballRow][ballCol] = true;
				queue.offer(new Brick(ballRow, ballCol, copied[ballRow][ballCol]));
				break;
			}
			ballRow++;
		}
		
		// 벽돌 깨기
		while(!queue.isEmpty()) {
			Brick curr = queue.poll();
			copied[curr.r][curr.c] = 0;
			for (int i = 1; i < curr.range; i++) {
				for (int j = 0; j < 4; j++) {
					int nr = curr.r + dr[j] * i;
					int nc = curr.c + dc[j] * i;
					if(indexValid(nr, nc, R, C) && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.offer(new Brick(nr, nc, copied[nr][nc]));
					}
				}
			}
		}
		
		// 벽돌 떨어뜨리기
		fallBrick(copied, R, C);
	}

	private static void fallBrick(int[][] copied, int R, int C) {
		// 벽돌일때, 자신의 아래가 벽돌인 idx까지 움직임
		// 아래 열에서부터 시작
		for (int r = R - 2; r >= 0; r--) {
			for (int c = 0; c < C; c++) {
				if(copied[r][c] != 0) {
					int nr = r + 1;
					for (int i = nr; i <= R; i++) {
						if(i == R) {
							nr = i - 1;
							break;
						}
						if(copied[i][c] != 0) {
							nr = i - 1;
							break;
						}
					}
					if(r != nr) {
						copied[nr][c] = copied[r][c];
						copied[r][c] = 0;
					}
				}
			}
		}
	}
	
	private static boolean indexValid(int nr, int nc, int R, int C) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
		return false;
	}
	
	private static int[][] copyArr(int[][] map) {
		int R = map.length;
		int C = map[0].length;
		int[][] copied = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				copied[r][c] = map[r][c];
			}
		}
		return copied;
	}
}
