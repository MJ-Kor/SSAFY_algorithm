import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MyDijkstraTest {

	static class Node{
		int vertex, weight;
		Node to;
		
		public Node(int vertex, int weight, Node to) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.to = to;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		final int INF = Integer.MAX_VALUE;
		
		Node[] adjList = new Node[V];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		
		
		// 초기값 설정
		boolean[] visited = new boolean[V];
		int[] minDistance = new int[V];
		Arrays.fill(minDistance, INF);
		minDistance[start] = 0;
		
		for (int i = 0; i < V; i++) {
			
			// 가장 최소값 찾기
			int min = INF;
			int stopOver = -1;
			for (int j = 0; j < V; j++) {
				if(!visited[j] && minDistance[j] < min) {
					min = minDistance[j];
					stopOver = j;
				}
			}
			
			if(stopOver == -1) break;
			visited[stopOver] = true;
			
			// 최소인 정점에서 다른 정점까지의 거리를 업데이트
			for (Node temp = adjList[stopOver] ; temp != null; temp = temp.to) {
				if(!visited[temp.vertex] && minDistance[temp.vertex] > min + temp.weight) {
					minDistance[temp.vertex] = min + temp.weight;
				}
			}
		}
		System.out.println(Arrays.toString(minDistance));
		System.out.println(minDistance[end] != INF ? minDistance[end] : -1);
	}

}
