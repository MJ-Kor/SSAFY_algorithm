package training.boj.extra.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3197_김민주 {

	private static class Node{
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}
		
		
	}
	
	private static int R, C;
	private static int day = 0;
	private static char[][] map;
	private static Node[] swans;
	private static Queue<Node> queue, water;
	private static boolean[][] visited;
	private static final int[] dr = {-1, 0, 1, 0};
	private static final int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		swans = new Node[2];
		queue = new LinkedList<>();
		water = new LinkedList<>();
		visited = new boolean[R][C];
		
		int swanIdx = 0;
		for (int r = 0; r < R; r++) {
			char[] line = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				map[r][c] = line[c];
				if(map[r][c] == 'L') {
					swans[swanIdx++] = new Node(r, c);
				}
				if(map[r][c] != 'X') {
					water.offer(new Node(r, c));
				}
			}
		}
		
		queue.offer(swans[0]);
		visited[swans[0].r][swans[0].c] = true;
		bfs();
		System.out.println(day);

	}

	private static void bfs() {
		boolean result = false;
		while(true) {
			Queue<Node> nQueue = new LinkedList<>();
			while(!queue.isEmpty()) {
				Node curr = queue.poll();
				if(curr.r  == swans[1].r && curr.c == swans[1].c)
				{
					result = true;
					break;
				}
				for (int i = 0; i < 4; i++) {
					int nr = curr.r + dr[i];
					int nc = curr.c + dc[i];
					if(nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc])continue;
					visited[nr][nc] = true;
					if(map[nr][nc] == 'X') {
						nQueue.offer(new Node(nr, nc));
						continue;
					}
					queue.offer(new Node(nr, nc));
				}
			}
			if(result) break;
			queue = nQueue;
			waterbfs();
			day++;
		}
		return;
	}

	private static void waterbfs() {
		int waterSize = water.size();
		while(waterSize-- > 0) {
			Node curr = water.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if(map[nr][nc] == 'X') {
					map[nr][nc] = '.';
					water.offer(new Node(nr, nc));
				}
			}
		}
	}
}
