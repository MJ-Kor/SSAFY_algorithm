package hw.day_02_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_김민주 {

	static class Node{
		int to;
		Node next;

		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}
		
	}
	
	private static int T = 10;
	private static int N, start;
	
	private static Node[] nodeList;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			nodeList = new Node[101];
			visited = new boolean[101];
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			// 그래프 생성
			for (int i = 1; i <= N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				nodeList[from] = new Node(to, nodeList[from]);
			}
			System.out.println("#" + test_case + " " + bfs());
		}
		
		
	}
	
	public static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] {start, 0});
		visited[start] = true;
		
		// 너비에 대한 원소를 저장할 리스트
		List<Integer> list = new ArrayList<>();
		int currBreath = 0;
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			// 너비가 달라지면 리스트를 비우고 해당 너비에 대한 노드들 저장
			// 중복이 있어도 visited 때문에 걸러짐
			if(curr[1] != currBreath) {
				currBreath = curr[1];
				list.clear();
			}
			list.add(curr[0]);
			
			for(Node temp = nodeList[curr[0]]; temp != null; temp = temp.next) {
				if(!visited[temp.to]) {
					queue.offer(new int[] {temp.to, curr[1] + 1});
					visited[temp.to] = true; 
				}
			}
		}
		
		// 가장 최근 탐색한 너비에서 가장 큰 값
		return Collections.max(list);
	}

}
