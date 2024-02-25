package training.boj.extra.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 총 F층
 * 스타트링크 G층
 * 강호 S층
 * S -> G층
 * 
 * U: 위로, D: 아래로
 */
public class Main_5014_김민주_DFS는터짐 {

	private static int F, S, G, U, D;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		visited = new boolean[F + 1];
		
		dfs(0, S);
		
		System.out.println("use the stairs");
	}

	private static void dfs(int cnt, int now) {
		
		if(now == G) {
			System.out.println(cnt);
			System.exit(0);
		}
		
		if(now < 1 || now > F || visited[now]) {
			return;
		}
		
		visited[now] = true;
		dfs(cnt + 1, now + U);
		dfs(cnt + 1, now - D);
	}
	
	
	
}
