package training.boj.extra.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562_김민주 {

	private static int T, I;
	private static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
	private static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
	private static int sRow, sCol, eRow, eCol;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			I = Integer.parseInt(br.readLine());
			visited = new boolean[I][I];
			st = new StringTokenizer(br.readLine());
			sRow = Integer.parseInt(st.nextToken());
			sCol = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			eRow = Integer.parseInt(st.nextToken());
			eCol = Integer.parseInt(st.nextToken());
			int min = bfs();
			System.out.println(min);
		}
	}

	private static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		int min = 0;
		visited[sRow][sCol] = true;
		queue.offer(new int[] {sRow, sCol, 0});
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			if(curr[0] == eRow && curr[1] == eCol) {
				min = curr[2];
				break;
			}
			for (int i = 0; i < 8; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if(nr >= 0 && nr < I && nc >= 0 && nc < I && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc, curr[2] + 1});
				}
			}
		}
		return min;
	}
}
