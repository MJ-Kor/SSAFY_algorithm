package classes.com.ssafy.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class AdjListTest {

	static class Node{
		int to;
		Node next;
		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}
		public Node(int to) {
			super();
			this.to = to;
		}
		@Override
		public String toString() {
			return "Node [to=" + to + ", next=" + next + "]";
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		Node[] adjList = new Node[V]; // 각 정점의 인접리스트의 헤드 저장
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from] = new Node(to, adjList[from]); // 맨 앞으로 삽입하는 알고리즘
			adjList[to] = new Node(from, adjList[to]);
		}
		
		bfs(adjList, 0);
		
	}
	
	static void bfs(Node[] adjList, int start) {
		int V = adjList.length;
		
		// 1. 큐와 방문관리 배열 준비
		Queue<Integer> queue = new ArrayDeque<>();
		boolean [] visited = new boolean[V];
		
		// 2. 시작 임의의정점(정점 0) 큐에 넣고 방문 체크
		queue.offer(start);
		visited[start] = true;
		
		// 3. 큐로 방문관리
		while(!queue.isEmpty()) {
			int current = queue.poll(); // 4. 탐색해야하는 정점 꺼내기
			
			// 탐색 정점에 관련된 로직 처리
			System.out.println((char)(current + 65));
			
			// 5. 탐색정점의 주변 인접정점들 탐색될 수 있도록 처리하기
			for (Node temp = adjList[current]; temp != null; temp = temp.next) {
				if(!visited[temp.to]) {
					queue.offer(temp.to);
					visited[temp.to] = true;
				}
			}
		}
	}

}
