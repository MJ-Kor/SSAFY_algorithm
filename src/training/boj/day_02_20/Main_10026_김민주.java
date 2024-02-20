package training.boj.day_02_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_10026_김민주 {

	private static int N;
	private static int cnt1 = 0;
	private static int cnt2 = 0;
	private static char[][] map;
	private static boolean[][] visited;
	
	// 4방 탐색
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str;
		
		map = new char[N][N];
		
		
		for (int r = 0; r < N; r++) {
			str = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
//		for (int r = 0; r < N; r++) {
//			for (int c = 0; c < N; c++) {
//				System.out.print(map[r][c] + " ");
//			}
//			System.out.println();
//		}

		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visited[r][c]) bfs1(r, c);
			}
		}
		
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visited[r][c]) bfs2(r, c);			
			}
		}
		
		System.out.println(cnt1 + " " + cnt2);
		
	}	

	public static void bfs1(int r, int c) {
		int nr, nc;
		char color = map[r][c];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r, c});
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int i = 0; i < 4; i++) {
				nr = curr[0] + dr[i];
				nc = curr[1] + dc[i];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == color) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
		cnt1++;
	}
	
	public static void bfs2(int r, int c) {
		int nr, nc;
		char color = map[r][c];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r, c});
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int i = 0; i < 4; i++) {
				nr = curr[0] + dr[i];
				nc = curr[1] + dc[i];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
					if(color == 'B') {
						if(map[nr][nc] == color) {						
							visited[nr][nc] = true;
							queue.offer(new int[] {nr, nc});
						}
					}
					else {
						if(map[nr][nc] != 'B') {
							visited[nr][nc] = true;
							queue.offer(new int[] {nr, nc});
						}
					}
				}
			}
		}
		cnt2++;
	}
	
}
