package training.boj.day_03_27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main_1194_김민주 {
	
	private static int R;
	private static int C;
	private static char[][] map;
	private static boolean[][][] visited;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
 
	public static void main(String[] args) throws Exception {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		int sr = -1;
		int sc = -1;
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				if(map[r][c] == '0') {
					sr = r;
					sc = c;
				}
			}
		}
		
		visited = new boolean[R][C][64];
		
		int result = bfs(sr, sc);
		
		System.out.println(result);
	}
	
private static int bfs(int sr, int sc) {
		
		Queue<int[]> queue = new ArrayDeque<>();
		
		int key = 0;
		
		queue.add(new int[] {sr, sc, key, 0});
		visited[sr][sc][0] = true;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				
				if(nr >= 0 && nr < R && nc >= 0 && nc < C) {

					if(!visited[nr][nc][curr[2]]) {
						if(map[nr][nc] == '.' || map[nr][nc] == '0') {
							visited[nr][nc][curr[2]] = true;
							queue.add(new int[] {nr, nc, curr[2], curr[3] + 1});
						}
						else if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
							visited[nr][nc][curr[2]] = true;
							
							int k = curr[2] | (1 << (map[nr][nc] - 'a'));
							queue.add(new int[] {nr, nc, k, curr[3] + 1});
						}
						else if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {

							if(((1 << (map[nr][nc] - 'A')) & curr[2]) == 1 << (map[nr][nc] - 'A')) {
								visited[nr][nc][curr[2]] = true;
								queue.add(new int[] {nr, nc, curr[2], curr[3] + 1});
							}
						}
						else if(map[nr][nc] == '1') {
							return curr[3] + 1;
						}
					}
				}
			}
		}
		
		return -1;
	}
 
}