package algorithm_study.day_03_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179 {

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
	
	private static class QueueData{
		Point point;
		int breadth;
		
		public QueueData(Point point, int breadth) {
			super();
			this.point = point;
			this.breadth = breadth;
		}
		
		@Override
		public String toString() {
			return "QueueData [point=" + point + ", breadth=" + breadth + "]";
		}
	}
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char map[][] = new char[R][C];
		
		Point jihoon = null;
		List<Point> fires = new ArrayList<>();
		
		for (int r = 0; r < R; r++) {
			String line = br.readLine();
			for (int c = 0; c < C; c++) {
				char in = line.charAt(c);
				if(in == 'J') jihoon = new Point(r, c);
				if(in == 'F') fires.add(new Point(r, c));
			}
		}
		
		bfs(R, C, jihoon, fires);
	}

	private static void bfs(int r, int c, Point jihoon, List<Point> fires) {
		boolean[][] visited = new boolean[r][c];
		Queue<QueueData> queue = new ArrayDeque<>();
		visited[jihoon.r][jihoon.c] = true;
		
	}
	
}
