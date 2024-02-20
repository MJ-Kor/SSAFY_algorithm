package training.boj.day_02_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_김민주 {

	private static boolean[][] visited;
	private static int hour = 0;
	private static int currCnt = 0;
	private static int prevCnt = 0;
	private static int R, C;
	private static int[][] map;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	private static List<int[]> meltPosition = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
	
		for (int r = 0; r < R; r++) {
			map[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		do {
			visited = new boolean[R][C];
			meltPosition.clear();
			cheese(0, 0);
			prevCnt = currCnt;
			currCnt = meltPosition.size();
			if(currCnt != 0) hour++;
			for (int i = 0; i < currCnt; i++) {
				map[meltPosition.get(i)[0]][meltPosition.get(i)[1]] = 0;
			}
		} while(currCnt != 0);
		
		System.out.println(hour);
		System.out.println(prevCnt);
		
	}

	public static void cheese(int r, int c) {
		int nr, nc;
		Queue<int[]> queue = new ArrayDeque<>();
		
		visited[r][c] = true;
		queue.offer(new int[] {r, c});
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int i = 0; i < 4; i++) {
				nr = curr[0] + dr[i];
				nc = curr[1] + dc[i];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
					if(map[nr][nc] == 0) {
						visited[nr][nc] = true;
						queue.offer(new int[] {nr, nc});
					}
					else if(map[nr][nc] == 1) {
						visited[nr][nc] = true;
						meltPosition.add(new int[] {nr, nc});
					}
				}
			}
		}
	}
}
