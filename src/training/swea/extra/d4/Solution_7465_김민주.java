package training.swea.extra.d4;

/*
 * 15분
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7465_김민주 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int result = 0;
			
			int[][] adjMatrix = new int[V + 1][V + 1];
			boolean[] visited = new boolean[V + 1];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjMatrix[from][to] = 1;
				adjMatrix[to][from] = 1;
			}
			
			for (int i = 1; i <= V; i++) {
				if(!visited[i]) {
					bfs(V, i, visited, adjMatrix);
					result += 1;
				}
			}
			
			System.out.println("#" + test_case + " " + result);
		}
		
	}

	private static void bfs(int V, int start, boolean[] visited, int[][] adjMatrix) {
		Queue<Integer> queue = new ArrayDeque<>();
		visited[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			for (int i = 1; i <= V; i++) {
				if(curr == i) continue;
				if(!visited[i] && adjMatrix[curr][i] == 1) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}

}
