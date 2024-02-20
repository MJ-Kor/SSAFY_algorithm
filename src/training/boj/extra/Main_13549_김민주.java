package training.boj.extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13549_김민주 {
	private static int N, K;
	private static int min = Integer.MAX_VALUE;
	private static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		bfs();
	}

	public static void bfs() {
		int newN = 0;
		int currBreath = -1;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {N, 0});
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			if(currBreath < curr[1]) {
				if(min != Integer.MAX_VALUE) {
					System.out.println(min);
					System.exit(0);
				}
				currBreath = curr[1];
			}
			
			if(curr[0] == K) {
				if(min > curr[1]) min = curr[1];
			}
			
			for (int i = 0; i < 3; i++) {
				if(i == 0) {
					newN = curr[0] - 1;
					if(newN <= 100000 && newN >= 0) {
							queue.offer(new int[] {newN, curr[1] + 1});
					}
				}
				else if(i == 1) {
					newN = curr[0] + 1;
					if(newN <= 100000 && newN >= 0) {
						queue.offer(new int[] {newN, curr[1] + 1});
					}					
				} 
				else if(i == 2) {
					newN = curr[0] * 2;
					if(newN <= 100000 && newN >= 0) {
							queue.offer(new int[] {newN, curr[1]});
					}					
				}
			}
		}
	}
}
