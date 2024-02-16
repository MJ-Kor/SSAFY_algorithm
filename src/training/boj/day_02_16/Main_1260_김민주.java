package training.boj.day_02_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_김민주 {
	
	private static int N, M, V;
	private static int[][] adjMatrix;
	private static boolean[] dfsVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[N + 1][N + 1];
		dfsVisited = new boolean[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}
		
		dfs(V, adjMatrix);
		System.out.println();
		bfs(V);
		
	}
	
	public static void dfs(int current, int[][] adjMatrix) {
		dfsVisited[current] = true;
		System.out.print(current + " ");
		for (int i = 1; i <= N; i++) {
			if(adjMatrix[current][i] != 0 && !dfsVisited[i]) {
				dfs(i, adjMatrix);
			}
		}
	
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		boolean [] visited = new boolean[N + 1];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");
			
			for (int i = 1; i <= N; i++) {
				if(adjMatrix[current][i] != 0 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
