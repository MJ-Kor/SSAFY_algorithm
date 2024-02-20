package training.boj.day_02_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252_김민주 {
	
	private static int N, M, A, B;
	private static int[] inDegree;
	private static List<ArrayList<Integer>> list = new ArrayList<>();	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		inDegree = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			list.get(A).add(B);
			++inDegree[B];
		}
		
		bfs();
		
	}

	public static void bfs() {
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			if(list.get(i) != null && inDegree[i] == 0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.print(curr + " ");
			ArrayList<Integer> removed = list.get(curr);
			for (int i = 0; i < removed.size() ; i++) {
				inDegree[removed.get(i)]--;
				if(inDegree[removed.get(i)] == 0) queue.offer(removed.get(i));
			}
			list.set(curr, null);
		}
	}
	
}
