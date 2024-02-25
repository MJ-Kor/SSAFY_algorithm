package training.boj.extra.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5014_김민주 {

	private static int F, S, G, U, D;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		visited = new boolean[F + 1];
		int[] buttons = {U, -D};
		
		bfs(buttons);
		
	}

	private static void bfs(int[] buttons) {
		Queue<int[]> queue = new ArrayDeque<>();
		visited[S] = true;
		queue.offer(new int[] {S, 0});
		
		while(!queue.isEmpty()) {
			int curr[] = queue.poll();
			if(curr[0] == G) {
				System.out.println(curr[1]);
				System.exit(0);
			}
			for(int button : buttons) {
				int nF = curr[0] + button;
				if(nF > 0 && nF <= F && !visited[nF]) {
					visited[nF] = true;
					queue.offer(new int[] {nF, curr[1] + 1});
				}
			}
		}
		
		System.out.println("use the stairs");
	}

}
