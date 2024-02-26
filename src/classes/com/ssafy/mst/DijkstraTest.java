package classes.com.ssafy.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class DijkstraTest {

	static class Node{
		int vertex, weight;
		Node next;
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + ", next=" + next + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		final int INF = Integer.MAX_VALUE;
		
		Node[] adjList = new Node[V];
		int[] minDistance = new int[V];
		boolean[] visited = new boolean[V];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		
		Arrays.fill(minDistance, INF);
		minDistance[start] = 0; // 출발지에서 출발지로의 비용 0으로 초기화
		
		int min = 0, stopOver = 0;
		for (int i = 0; i < V; i++) { // 모든 정점이 다 처리될 때까지 반복
			// step1: 미방문 정점 중 출발지에서 가장 가까운 정점 선택
			min = INF;
			stopOver = -1;
			for (int j = 0; j < V; j++) {
				if(!visited[j] && min > minDistance[j]) {
					min = minDistance[j];
					stopOver = j;
				}
			}
			
			if(stopOver == -1) break;
			visited[stopOver] = true;
			
			// step2: 미방문 정점들에 대해 선택된 경유지를 거쳐서 가는 비용과 기존 최소비용을 비교해서 업데이트
			for (Node temp = adjList[stopOver]; temp != null ; temp = temp.next) {
				if(!visited[temp.vertex] && minDistance[temp.vertex] > min + temp.weight) {
					minDistance[temp.vertex] = min + temp.weight;
					
				}
			}
		}
		System.out.println(Arrays.toString(minDistance));
		System.out.println(minDistance[end] != -1 ? minDistance[end] : -1);
	}

}
