package training.boj.day_02_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_김민주 {

	private static int max = Integer.MIN_VALUE;
	private static int R, C;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	private static int[][] map;
	private static List<int[]> start = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 2) start.add(new int[] {r, c});
			}
		}
		
		addWall(0);
		System.out.println(max);
	}
	
	public static void addWall(int cnt) {
		if(cnt == 3) {
			bfs(deepCopy(map));
			return;
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] == 0) {
					map[r][c] = 1;
					addWall(cnt + 1);
					map[r][c] = 0;
				}
			}
		}
	}
	
	public static void bfs(int[][] map) {
		int nr, nc;
		int check = 0;
		boolean[][] visited = new boolean[R][C];
		Queue<int[]> queue = new ArrayDeque<>();
		
		for (int i = 0; i < start.size(); i++) {
			int[] e = start.get(i);
			queue.offer(new int[] {e[0], e[1]});
		}
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int i = 0; i < 4; i++) {
				nr = curr[0] + dr[i];
				nc = curr[1] + dc[i];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] == 0) {
					map[nr][nc] = 2;
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] == 0) check++;
			}
		}
		
		if(check > max) max = check;
	}
	
	public static int[][] deepCopy(int[][] original){
		if (original == null) return null;
		int[][] copied = new int[original.length][original[0].length];
		for (int i = 0; i < copied.length; i++) {
			System.arraycopy(original[i], 0, copied[i], 0, original[0].length);
		}
		return copied;
	}

}
