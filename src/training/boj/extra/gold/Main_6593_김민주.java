package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6593_김민주 {
	
	private static class Point{
		int l, r, c;

		public Point(int l, int r, int c) {
			super();
			this.l = l;
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [l=" + l + ", r=" + r + ", c=" + c + "]";
		}
		
	}
	
	private static class QueueData{
		Point point;
		int minute;
		
		public QueueData(Point point, int minute) {
			super();
			this.point = point;
			this.minute = minute;
		}
		
		@Override
		public String toString() {
			return "QueueData [point=" + point + ", minute=" + minute + "]";
		}
		
	}
	
	// 상, 하 
	private static int[] dl = {1, -1};
	// 북, 동, 남, 서
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		char[][][] building = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			if(L == 0 && R == 0 && C == 0) {
				System.exit(0);
			}
			
			building = new char[L][R][C];
			Point start = null;
			
			for (int l = L - 1; l >= 0; l--) {
				for (int r = 0; r < R; r++) {
					String str = br.readLine();
					for (int c = 0; c < C; c++) {
						 char in = str.charAt(c);
						 if(in == 'S') {
							 start = new Point(l, r, c);
						 }
						 building[l][r][c] = in;
					}
				}
				br.readLine();
			}
			bfs(building, start);
		}
		
	}

	private static void bfs(char[][][] building, Point start) {
		int exit = -1;
		int L = building.length;
		int R = building[0].length;
		int C = building[0][0].length;
		boolean[][][] visited = new boolean[L][R][C];
		Queue<QueueData> queue = new ArrayDeque<>();
		visited[start.l][start.r][start.c] = true;
		queue.offer(new QueueData(start, 0));
		while(!queue.isEmpty()) {
			QueueData curr = queue.poll();
			int cl = curr.point.l;
			int cr = curr.point.r;
			int cc = curr.point.c;
//			System.out.println(" cl: " + cl + " cr: " + cr + " cc: " + cc);
			if(building[cl][cr][cc] == 'E') {
				exit = curr.minute;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[cl][nr][nc] && building[cl][nr][nc] != '#') {
					visited[cl][nr][nc] = true;
					Point npoint = new Point(cl, nr, nc);
					queue.offer(new QueueData(npoint, curr.minute + 1));
				}
			}
			for (int i = 0; i < 2; i++) {
				int nl = cl + dl[i];
				if(nl >= 0 && nl < L && !visited[nl][cr][cc] && building[nl][cr][cc] != '#') {
					visited[nl][cr][cc] = true;
					Point npoint = new Point(nl, cr, cc);
					queue.offer(new QueueData(npoint, curr.minute + 1));
				}
			}
		}
		
		if(exit != -1) {
			System.out.println("Escaped in " + exit + " minute(s).");
		} else {
			System.out.println("Trapped!");
		}
	}

}
