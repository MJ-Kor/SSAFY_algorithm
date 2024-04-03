package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2458_김민주 {
	
	private static int cnt = 0;
	private static int V;
	private static int[][] adjMatrix;
	private static boolean[] visited;
	private static Queue<Integer> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		adjMatrix = new int[V + 1][V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adjMatrix[start][end] = 1;
		}
		
//		for (int i = 1; i <= V; i++) {
//			System.out.println(Arrays.toString(adjMatrix[i]));
//		}
		
		for (int i = 1; i <= V; i++) {				
			solution(i);
		}
		System.out.println(cnt);
	}

	private static void solution(int target) {
		visited = new boolean[V + 1];
		visited[target] = true;
		boolean bigger = true;
		
		// target보다 큰 학생들 확인
		bfs(target, target, bigger);
		
		// target보다 작은 학생들 확인
		bigger = false;
		for (int j = 1; j <= V; j++) {
			if(!visited[j]) bfs(j, target, bigger);
		}
		cnt++;
		for (int i = 1; i <= V; i++) {
			if(!visited[i]) {
				cnt--;
				break;
			}
		}
	}

	private static void bfs(int start, int target, boolean bigger) {
		queue.offer(start);
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			if(!bigger) {
//				System.out.println("curr: " + curr);
				if(curr == target) {
					visited[start] = true;
					queue.clear();
					break;
				}
			}
			for (int j = 1; j <= V; j++) {
				if(!bigger) {
					if(adjMatrix[curr][j] == 1) {
						queue.offer(j);
					}
				} else {					
					if(adjMatrix[curr][j] == 1 && !visited[j]) {
						visited[j] = true;
						queue.offer(j);
					}
				}
			}
		}
	}
}

