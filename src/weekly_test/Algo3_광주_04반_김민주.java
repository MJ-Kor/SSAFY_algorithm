package weekly_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo3_광주_04반_김민주 {

	static int cnt = 0;
	static int R, C;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static char[][] map;
	static boolean[][] visited;
	static List<int[]> person = new ArrayList<>();
	static List<int[]> meltingPoint = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
				if(map[r][c] == 'L') {
					person.add(new int[] {r, c});
				}
			}
		}
		if(bfs()) {
			System.out.println(0);
		}
		else {
			do {
				++cnt;
				for (int r = 0; r < R; r++) {
					for (int c = 0; c < C; c++) {
						if(map[r][c] == 'X') {
							check(r, c);
						}
					}
				}
				
				melt();
				
				if(bfs()) {
					System.out.println(cnt);
					System.exit(0);
				}
				
				meltingPoint.clear();
				visited = new boolean[R][C];
				
			}while(true);
		}
		
	}
	
	private static void check(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {
				meltingPoint.add(new int[] {r, c});
				break;
			}
		}
	}
	
	private static void melt() {
		for (int i = 0; i < meltingPoint.size(); i++) {
			map[meltingPoint.get(i)[0]][meltingPoint.get(i)[1]] = '.';
		}
	}
	
	private static boolean bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		int[] startPerson = person.get(0);
		int[] endPerson = person.get(1);
		
		visited[startPerson[0]][startPerson[1]] = true;
		queue.offer(startPerson);
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			if(curr[0] == endPerson[0] && curr[1] == endPerson[1]) {
				return true;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] != 'X') {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
		return false;
	}
}
