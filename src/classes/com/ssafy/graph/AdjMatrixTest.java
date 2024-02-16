package classes.com.ssafy.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int[][] adjMatrix = new int[V][V]; // 0으로 초기화(연결되지 않은 상태로 초기화)
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
			
		}
		
		bfs2(adjMatrix, 0);
		
	}
	
	static void bfs(int[][] adjMatrix, int start) {
		int V = adjMatrix.length;
		
		// 1. 큐와 방문관리 배열 준비
		Queue<Integer> queue = new ArrayDeque<>();
		boolean [] visited = new boolean[V];
		
		// 2. 시작 임의의정점(정점 0) 큐에 넣고 방문 체크
		queue.offer(start);
		visited[start] = true;
		
		// 3. 큐로 방문관리
		while(!queue.isEmpty()) {
			int current = queue.poll(); // 4. 탐색해야하는 정점 꺼내기
			
			// 탐색 정점에 관련된 로직 처리
			System.out.println((char)(current + 65));
			
			// 5. 탐색정점의 주변 인접정점들 탐색될 수 있도록 처리하기
			for (int i = 0; i < V; i++) {
				if(adjMatrix[current][i] != 0 // 인접정점 체크 
						&& !visited[i] 		  // 방문여부 체크
				) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
	static void bfs2(int[][] adjMatrix, int start) { // 나와서 방문처리
		int V = adjMatrix.length;
		
		// 1. 큐와 방문관리 배열 준비
		Queue<Integer> queue = new ArrayDeque<>();
		boolean [] visited = new boolean[V];
		
		// 2. 시작 임의의정점(정점 0) 큐에 넣고 방문 체크
		queue.offer(start);
		
		// 3. 큐로 방문관리
		while(!queue.isEmpty()) {
			int current = queue.poll(); // 4. 탐색해야하는 정점 꺼내기
			
			// 탐색 정점에 관련된 로직 처리
			visited[current] = true;
			System.out.println((char)(current + 65));
			
			// 5. 탐색정점의 주변 인접정점들 탐색될 수 있도록 처리하기
			for (int i = 0; i < V; i++) {
				if(adjMatrix[current][i] != 0 // 인접정점 체크 
						&& !visited[i] 		  // 방문여부 체크
				) {
					queue.offer(i);
				}
			}
		}
	}

}
