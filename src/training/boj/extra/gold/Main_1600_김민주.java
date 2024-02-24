package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_김민주 {

	private static int min = Integer.MAX_VALUE;
	private static int K, R, C;
	private static int[] drH = {-2, -1, 1, 2, 2, 1, -1, -2};
	private static int[] dcH = {1, 2, 2, 1, -1, -2, -2, -1};
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	private static int[][] map;
	private static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		// 말 이동 횟수를 0~K번 사용했을 때 각각 방문맵
		visited = new boolean[K + 1][R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		min = bfs();
		System.out.println(min);
	}

	private static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < K; i++) {			
			visited[i][0][0] = true;
		}
		// r, c, w, k
		queue.offer(new int[] {0, 0, 0, 0});
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			if(curr[0] == R - 1 && curr[1] == C - 1) {
				return curr[2];
			}

			for (int j = 0; j < 4; j++) {
				int nr = curr[0] + dr[j];
				int nc = curr[1] + dc[j];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[curr[3]][nr][nc] && map[nr][nc] == 0) {
					visited[curr[3]][nr][nc] = true;
					queue.offer(new int[] {nr, nc, curr[2] + 1, curr[3]});
				}
			}
			
			// 말처럼 이동할 횟수가 남아 있으면
			if(curr[3] < K) {
				for (int j = 0; j < 8; j++) {
					int nr = curr[0] + drH[j];
					int nc = curr[1] + dcH[j];
					if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[curr[3] + 1][nr][nc] && map[nr][nc] == 0) {
						visited[curr[3] + 1][nr][nc] = true;
						queue.offer(new int[] {nr, nc, curr[2] + 1, curr[3] + 1});
					}
				}
			}
		}
		return -1;
	}

	
	
}
