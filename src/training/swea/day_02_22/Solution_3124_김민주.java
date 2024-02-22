package training.swea.day_02_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_김민주 {

	
	static class Edge implements Comparable<Edge>{
		int from, to;
		long weight;

		public Edge(int from, int to, long weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
		
	}
	private static int T, V, E;
	private static Edge[] edgeList;
	private static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edgeList = new Edge[E];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				long weight = Long.parseLong(st.nextToken());
				Edge edge = new Edge(from, to, weight);
				edgeList[i] = edge;
			}
			
			make();
			Arrays.sort(edgeList);
			
			long weight = 0;
			int cnt = 0;
			for (Edge edge : edgeList) {
				if(!union(edge.from, edge.to)) continue;
				weight += edge.weight;
				if(++cnt == V - 1) break;
			}
			
			System.out.println("#" + test_case + " " + weight);
			
		}
	}
	
	public static void make() {
		parents = new int[V + 1];
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	public static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		if(find(a) == find(b)) return false;
		parents[find(a)] = find(b);
		return true;
	}
	
}
