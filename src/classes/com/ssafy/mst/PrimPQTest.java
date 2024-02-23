package classes.com.ssafy.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimPQTest {

	static class Vertex implements Comparable<Vertex>{
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int[V][V]; 	// 인접 행렬 준비
		boolean[] visited = new boolean[V];	// 트리 정점 여부
		int[] minEdge = new int[V];			// 비 트리 정점 기준으로 트리 정점들과 연결했을 경우 최소 간선 비용
		
		StringTokenizer st = null;
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0] = 0; 	// 임의의 시작점을 0을 위해 처리
		pq.offer(new Vertex(0, minEdge[0]));
		
		int result = 0;		// 최소 신장 트리 비용
		int c = 0;
		while (!pq.isEmpty()) {
			
			// step 1: 비트리 정점 중 최소 간선 비용의 정점 찾기!
			Vertex minVertex = pq.poll();
			// 	if(minVertex == null) break;
			if(visited[minVertex.no])	continue;
			
			result += minVertex.weight;				// 간선 비용 누적
			visited[minVertex.no] = true;	// 트리 정점에 포함
			if(++c == V) break;
			
			// step 2: 새롭게 트리 정점에 확장된 정점 기준으로 비트리 정점들과의 간선비용 고려 최적으로 업데이트
			for (int i = 0; i < V; i++) {
				if(!visited[i] && adjMatrix[minVertex.no][i] != 0 && adjMatrix[minVertex.no][i] < minEdge[i]) // 인접 정점 중 방문하지 않고, 기존 경로보다 최소이면 
					minEdge[i] = adjMatrix[minVertex.no][i];	// 업데이트
					pq.offer(new Vertex(i, minEdge[i]));
			}
			
		}
		System.out.println(c == V ? result : -1);
	}

}
