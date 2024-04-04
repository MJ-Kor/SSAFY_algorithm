package hw.day_04_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution_1249_김민주 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static class Point{
		int r, c, value;

		public Point(int r, int c, int value) {
			super();
			this.r = r;
			this.c = c;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", value=" + value + "]";
		}
		
	}
	
	private static int TC, N;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	private static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Solution_1249_김민주().solution();
	}
	
	private void solution() throws IOException {
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			init();
			printResult(tc, getResult());
		}
	}
	
	private static void init() throws IOException {
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
	}

	private void printResult(int tc, int result) {
		System.out.println("#tc" + " " + result);
	}

	private int getResult() {
		Point start = new Point(0, 0, map[0][0]);
		int[][] visited = new int [N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		visited[start.r][start.c] = start.value; 
		Queue<Point> queue = new ArrayDeque<>();
		visited[start.r][start.c] = start.value;
		queue.offer(start);
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				if(idxValid(nr, nc)) {
					int nv = visited[curr.r][curr.c] + map[nr][nc];		
					if(visited[nr][nc] == Integer.MAX_VALUE) {
						visited[nr][nc] = nv;
						queue.offer(new Point(nr, nc, map[nr][nc]));
					} else {						
						if(isMinValue(visited[nr][nc], nv)) {
							visited[nr][nc] = nv;
							queue.offer(new Point(nr, nc, map[nr][nc]));
						}
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(visited[i]));
		}
		return visited[N - 1][N - 1];
	}

	private boolean isMinValue(int old, int value) {
		if(Math.min(old, value) == value) return true;
		return false;
	}

	private boolean idxValid(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
		return false;
	}



}
