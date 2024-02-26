package 월말평가;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 무방향
public class mAlgo1_광주_04반_김민주 {

	static class Node{
		List<Integer> followers = new ArrayList<>();
	}
	static int V, E;
	static Node[] graph;
	static boolean[] visited;
	static int cnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		visited = new boolean[V + 1];
		graph = new Node[V + 1];
		
		for (int i = 1; i <= V; i++) {
			graph[i] = new Node();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].followers.add(to);
			graph[to].followers.add(from);
		}
		
		bfs(1);
		System.out.println(cnt - 1);
	}

	static void bfs(int i) {
		Queue<Integer> queue = new ArrayDeque<>();
		visited[i] = true;
		queue.offer(1);
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			cnt++;
			for (int j = 0; j < graph[curr].followers.size(); j++) {
				int follower = graph[curr].followers.get(j);
				if(!visited[follower]) {
					visited[follower] = true;
					queue.offer(follower);
				}
			}
		}
	}
}
