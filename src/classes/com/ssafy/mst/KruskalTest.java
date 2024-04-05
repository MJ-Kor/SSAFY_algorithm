package classes.com.ssafy.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class KruskalTest {

	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight,  o.weight);
		}
	}
	static int V;
	static Edge[] edgeList;
	static int[] parents; // 자신의 부모나 루트를 저장(경로 압축으로 인해)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}// 간선 리스트 생성
		
		// 전처리: 간선 리스트 오름차순 정렬
		Arrays.sort(edgeList);
		// 1. make-set
		make();
		
		// 2. 정렬된 간선 하나씩 꺼내어 신장트리 생성
		int weight = 0;
		int cnt = 0;
		for (Edge edge : edgeList) {
			if(!union(edge.from, edge.to)) continue; 	// 사이클 발생
			weight += edge.weight;
			if(++cnt == V - 1) break;					// 최소 신장트리 완성
		}
		
		System.out.println(weight);
	}

	public static void make() {
		parents = new int[V]; 
		for (int i = 0; i < V; i++) {
			parents[i] = i; 							// 모든 정점을 자신을 대표자로
		}
	}
	
	public static int find(int a) {						// a가 속한 트리의 루트 찾기
		if(a == parents[a]) return a;
		//return parents[a] = find(parents[a]);
		return parents[a] = find(parents[a]);// path compression
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;		// a, b가 같은 트리에 속해있다. ==> union 불필요
		else {
			parents[bRoot] = aRoot;
			return true;
		}
	}
}
