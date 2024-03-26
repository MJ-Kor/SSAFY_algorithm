package hw.day_03_26;

import java.util.*;
import java.io.*;

public class Main_4485_김민주 {
	
	private static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[][] map = null;
		int cnt = 1;
		
		while(N != 0) {
			StringBuilder sb = new StringBuilder("Problem ");
			sb.append(cnt).append(": ");
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			sb.append(bfs(map, N));
			System.out.println(sb);
			N = Integer.parseInt(br.readLine());
			cnt++;
		}
	}

	private static int bfs(int[][] map, int N) {
		int[][] check = new int[N][N];
		for(int[] row : check)Arrays.fill(row, Integer.MAX_VALUE);
		Queue<Point> queue = new ArrayDeque<>();
		check[0][0] = map[0][0];
		queue.offer(new Point(0, 0));
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];		
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					int newValue = check[curr.r][curr.c] + map[nr][nc]; 
					if(newValue < check[nr][nc]) {
						check[nr][nc] = newValue;
						queue.offer(new Point(nr, nc));
					}
				}
			}
		}
		return check[N-1][N-1];

	}

}
