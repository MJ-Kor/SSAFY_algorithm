package training.boj.extra.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_김민주 {

	private static int cnt = 0;
	private static int safeMax = Integer.MIN_VALUE;
	private static int N;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	private static int[][] map;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		int localMax = Integer.MIN_VALUE;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] > localMax) {
					localMax = map[r][c];
				}
			}
		}
		
		// 0 ~ 최대 마을 높이
		for(int i = 0; i <= localMax; i++){		
			visited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] > i && !visited[r][c]) {
						cnt++;
						bfs(r, c, i);
					}
				}
			}
			if(cnt > safeMax) {
				safeMax = cnt;
			}
			cnt = 0;
		}
		
		System.out.println(safeMax);
	}

	private static void bfs(int r, int c, int rain) {
		Queue<int[]> queue = new ArrayDeque<>();
		visited[r][c] = true;
		queue.offer(new int[] {r, c});
		
		while(!queue.isEmpty()) {
			int curr[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] > rain) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
	}

}
