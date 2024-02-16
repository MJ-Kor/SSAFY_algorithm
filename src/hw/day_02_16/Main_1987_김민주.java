package hw.day_02_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_김민주 {

	private static int max = Integer.MIN_VALUE;
	private static int R, C;
	private static boolean[] alphabet = new boolean[26]; 
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	private static boolean[][] visited;
	private static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str;
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int r = 0; r < R; r++) {
			str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		// 말의 첫번째 위치를 방문 처리, 알파벳 확인 처리
		alphabet[(int)(map[0][0] - 'A')] = true;
		visited[0][0] = true;
		
		// dfs 시작
		dfs(0, 0, 1);
		System.out.println(max);
	}

	public static void dfs(int r, int c, int cnt) {
		int nr, nc;
		
		// 상 우 하 좌 탐색
		for (int i = 0; i < 4; i++) {
			
			nr = r + dr[i];
			nc = c + dc[i];
			
			// nr, nc가 map 안에 있고, 방문하지 않았으며, 해당 위치의 알파벳을 만난 적이 없으면
			if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && !alphabet[(int)(map[nr][nc] - 'A')]) {
				
				// 방문 처리 및 깊이 탐색
				alphabet[(int)(map[nr][nc] - 'A')] = true;
				visited[nr][nc] = true;
				dfs(nr, nc, cnt + 1);
				
				// 탐색이 끝났으면 다시 원상복구
				alphabet[(int)(map[nr][nc] - 'A')] = false;
				visited[nr][nc] = false;
			}
		}
		
		// 더 이상 갈 곳이 없으면, 깊이 탐색 횟수 갱신
		if(max < cnt) max = cnt;
	}
}
