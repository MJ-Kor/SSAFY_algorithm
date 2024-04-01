package training.boj.day_03_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 모든 섬을 다리로 연결하려고 한다 => 그래프의 최단 거리

public class Main_17472_김민주 {
	
	private static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	
	private static class Island{
		int number;
		List<Point> points = new ArrayList<>();
		
		public Island(int number) {
			super();
			this.number = number;
		}

		@Override
		public String toString() {
			return "Island [number=" + number + ", points=" + points + "]";
		}
	}
	
	private static int islandNum = 1;
	private static int R, C;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	private static int[][] map;
	private static boolean[][] visited;
	private static Queue<Point> queue = new ArrayDeque<>();
	private static Island[] islands= new Island[6];

	public static void main(String[] args) throws IOException {

		init();
		findIsland();
		int[][] adjBridge = makeBridge();
		int answer = findBridge(adjBridge);
		
		System.out.println(answer);
	}
	
	// Prim
	private static int findBridge(int[][] adjBridge) {
		int V = islandNum - 1;
		boolean[] bridgeVisited = new boolean[V];
		int[] minBridge = new int[V];
		
		Arrays.fill(minBridge, Integer.MAX_VALUE);
		minBridge[0] = 0;
		int result = 0;
		int c;
		for (c = 0; c < V; c++) {
			int min = Integer.MAX_VALUE;
			int minIsland = -1;
			
			for (int i = 0; i < V; i++) {
				if(!bridgeVisited[i] && minBridge[i] < min) {
					min = minBridge[i];
					minIsland = i;
				}
			}
			
			if(minIsland == -1) break;
			result += min;
			bridgeVisited[minIsland] = true;
			
			for (int i = 0; i < V; i++) {
				if(!bridgeVisited[i] && adjBridge[minIsland][i] != 0 && adjBridge[minIsland][i] < minBridge[i]) {
					minBridge[i] = adjBridge[minIsland][i];
				}
			}
		}
		return (c == V ? result : -1);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {				
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void findIsland() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] == 1 && !visited[r][c]) bfs(r, c);
			}
		}
	}

	private static void bfs(int r, int c) {
		Island island = new Island(islandNum);
		visited[r][c] = true;
		queue.offer(new Point(r, c));
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			island.points.add(curr);
			map[curr.r][curr.c] = islandNum;
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				if(idxValid(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					queue.offer(new Point(nr, nc));
				}
			}
		}
		islands[islandNum - 1] = island;
		islandNum++;
	}
	
	private static int[][] makeBridge() {
		int[][] adjMatrix = new int[islandNum - 1][islandNum - 1];
		
		for (int start = 0; start < islandNum - 1; start++) {
			for(Point p : islands[start].points) {
				int l = 1;
				for (int j = 0; j < 4; j++) {
					int nr = p.r + l * dr[j];
					int nc = p.c + l * dc[j];
					while(idxValid(nr, nc)) {
						if(map[nr][nc] == islands[start].number) break;
						if(map[nr][nc] != islands[start].number && map[nr][nc] != 0) {
							if(l - 1 >= 2) {
								if(adjMatrix[start][map[nr][nc] - 1] == 0) {
									adjMatrix[start][map[nr][nc] - 1] = l - 1;
								} else {
									adjMatrix[start][map[nr][nc] - 1] = Math.min(adjMatrix[start][map[nr][nc] - 1], l - 1);
								}
							}
							break;
						}
						++l;
						nr = p.r + l * dr[j];
						nc = p.c + l * dc[j];
					}
					l = 1;
				}
			}
		}
		return adjMatrix;
	}

	private static boolean idxValid(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
		return false;
	}
}
