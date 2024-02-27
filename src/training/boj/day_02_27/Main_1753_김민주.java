package training.boj.day_02_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1753_김민주 {

	static class Node{
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		final int INF = Integer.MAX_VALUE;
		
		Node[] adjList = new Node[V + 1];
		int[] minDistance = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		
		for (int i = 0; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		
		Arrays.fill(minDistance, INF);
		minDistance[start] = 0;
		
		int min = 0, stopOver = 0;
		
		for (int i = 1; i <= V ; i++) {
			min = INF;
			stopOver = -1;
			for (int j = 1; j <= V; j++) {
				if(!visited[j] && min > minDistance[j]) {
					min = minDistance[j];
					stopOver = j;
				}
			}
			
			if(stopOver == -1) break;
			visited[stopOver] = true;
			
			for (Node temp = adjList[stopOver]; temp != null; temp = temp.next) {
				if(!visited[temp.vertex] && minDistance[temp.vertex] > min + temp.weight) {
					minDistance[temp.vertex] = min + temp.weight;
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			System.out.println(minDistance[i] != INF ? minDistance[i] : "INF");
		}
	}

}
