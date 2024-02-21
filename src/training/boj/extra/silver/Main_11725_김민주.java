package training.boj.extra.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11725_김민주 {

	private static int[] parent;
	private static boolean[] visited;
	private static ArrayList<Integer>[] tree;
	private static int N;
	private static void dfs(int start) {
		visited[start] = true;
		for(int e : tree[start]) {
			if(!visited[e]) {
				parent[e] = start;
				dfs(e);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		parent = new int[N + 1];
		tree = new ArrayList[N + 1];
		
		for (int i = 0; i < N + 1; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int i1 = Integer.parseInt(st.nextToken());
			int i2 = Integer.parseInt(st.nextToken());
			tree[i1].add(i2);
			tree[i2].add(i1);
		}
		
		dfs(1);
		
		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}
	
	

}
