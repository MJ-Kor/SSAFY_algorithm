package training.boj.extra.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940_김민주 {
	
	static class Coordinate{
		int r;
		int c;
		
		public Coordinate(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	private static boolean[][] visited;
	private static int R, C, targetC, targetR;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	private static int[][] map;
	private static Queue<Coordinate> queue = new ArrayDeque<Coordinate>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 2) {
					targetR = r;
					targetC = c;
				} else if(map[r][c] == 1) map[r][c] = -1;
			}
		}
		
		bfs();
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void bfs() {
		
		Coordinate first = new Coordinate(targetR, targetC);
		queue.offer(first);
		int nr, nc;
		map[first.r][first.c] = 0;
		
		while(!queue.isEmpty()) {
			Coordinate now = queue.poll();
			
			visited[now.r][now.c] = true; 
			for (int i = 0; i < 4; i++) {
				nr = now.r + dr[i];
				nc = now.c + dc[i];
				if(nr >= 0 && nr < R && nc >= 0 && nc <C && map[nr][nc] == -1 && visited[nr][nc] == false) {
					queue.offer(new Coordinate(nr, nc));
					map[nr][nc] = map[now.r][now.c] + 1; 
				}
			}
		}
	}

}
