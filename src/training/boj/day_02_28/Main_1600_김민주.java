package training.boj.day_02_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_김민주 {
	
	static int K, W, H;
	static int[] drH = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dcH = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[K + 1][H][W];
		for (int h = 0; h < H ; h++) {
			map[h] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		bfs();		
	}

	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i <= K ; i++) {
			visited[i][0][0] = true;
		}
		queue.offer(new int[] {0, 0, 0, K});

		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			if(curr[0] == H - 1 && curr[1] == W - 1) {
				System.out.println(curr[2]);
				System.exit(0);
			}
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if(nr >= 0 && nr < H && nc >= 0 && nc < W && !visited[curr[3]][nr][nc] && map[nr][nc] == 0) {
					visited[curr[3]][nr][nc] = true;
					queue.offer(new int[] {nr, nc, curr[2] + 1, curr[3]});
				}
			}
			if(curr[3] > 0) {
				for (int j = 0; j < 8; j++) {
					int nr = curr[0] + drH[j];
					int nc = curr[1] + dcH[j];
					if(nr >= 0 && nr < H && nc >= 0 && nc < W && !visited[curr[3] - 1][nr][nc] && map[nr][nc] == 0) {
						visited[curr[3] - 1][nr][nc] = true;
						queue.offer(new int[] {nr, nc, curr[2] + 1, curr[3] - 1});
					}
				}
			}
		}
		System.out.println(-1);
	}
}
