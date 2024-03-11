package templates.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kruskal {

	private static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
	}
	
	private static int[] P;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Edge[] edges = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(from ,to ,weight);
		}
		
		Arrays.sort(edges);
		
		int cnt = 0;
		int weight = 0;
		make(V);
		
		for (Edge edge : edges) {
			if(!union(edge.from, edge.to)) continue;
			
			cnt++;
			weight += edge.weight;
			
			if(cnt == V - 1) break;
		}
		
		System.out.println("최소 비용: " + weight);
	}

	private static boolean union(int a, int b) {
		if(find(a) == find(b)) return false;
		else {
			P[find(b)] = find(a);
			return true;
		}
	}

	private static int find(int a) {
		if(P[a] == a) return a;
		return P[a] = find(P[a]);
	}

	private static void make(int V) {
		P = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			P[i] = i;
		}
	}

}
