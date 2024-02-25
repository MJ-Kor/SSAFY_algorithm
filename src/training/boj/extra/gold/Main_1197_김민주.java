package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1197_김민주 {

	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	static int V, E;
	static Edge[] edges;
	static int[] P;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edges = new Edge[E];
		P = new int[V];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(start - 1, end - 1, weight);
		}
		
		Arrays.sort(edges);
		make();
		
		int weight = 0;
		int cnt = 0;
		for (Edge edge : edges) {
			if(!Union(edge.start, edge.end)) continue;
			cnt += 1;
			weight += edge.weight;
			if(cnt == V - 1) break;
		}
		
		System.out.println(weight);
	}
	
	private static void make() {
		for (int i = 0; i < V; i++) {
			P[i] = i;
		}
	}

	private static boolean Union(int a, int b) {
		if(find(a) == find(b)) return false;
		else {
			P[find(b)] = find(a);
			return true;
		}
	}

	private static int find(int a) {
		if(a == P[a]) return a;
		return P[a] = find(P[a]);
	}

	
	

}
