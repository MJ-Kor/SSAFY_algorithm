package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638_김민주 {

	private static boolean[][] visited;
	private static int hour = 0;
	private static int currCnt = 0;
	private static int prevCnt = 0;
	private static int R, C;
	private static int[][] map;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	private static List<int[]> meltPosition = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
	
		for (int r = 0; r < R; r++) {
			map[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		visited = new boolean[R][C];
		oxygen(0, 0);
//		System.out.println();
		do {
			visited = new boolean[R][C];
			meltPosition.clear();
			cheese(0, 0);
			prevCnt = currCnt;
			currCnt = meltPosition.size();
//			for (int i = 0; i < currCnt; i++) {
//				System.out.println((meltPosition.get(i)[0]+1) + " " + (meltPosition.get(i)[1]+1));
//			}
//			System.out.println(prevCnt);
//			System.out.println(currCnt);
			if(currCnt != 0) hour++;
			for (int i = 0; i < currCnt; i++) {
				map[meltPosition.get(i)[0]][meltPosition.get(i)[1]] = 2;
			}
			visited = new boolean[R][C];
			oxygen(0, 0);
//			for (int r = 0; r < R; r++) {
//				for (int c = 0; c < C; c++) {
//					System.out.print(map[r][c] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();			

		} while(currCnt != 0);
		
		System.out.println(hour);
		//System.out.println(prevCnt);
		
	}

	public static void cheese(int r, int c) {
		int nr, nc;
		Queue<int[]> queue = new ArrayDeque<>();
		
		visited[r][c] = true;
		queue.offer(new int[] {r, c});
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int i = 0; i < 4; i++) {
				nr = curr[0] + dr[i];
				nc = curr[1] + dc[i];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
					if(map[nr][nc] == 2) {
						visited[nr][nc] = true;
						queue.offer(new int[] {nr, nc});
					}
					else if(map[nr][nc] == 1) {
						visited[nr][nc] = true;
						if(checkCheese(nr, nc) >= 2) {
							meltPosition.add(new int[] {nr, nc});
						}
					}
				}
			}
		}
	}
	
	public static int checkCheese(int r, int c) {
		int check = 0;
		int nr, nc;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(map[nr][nc] == 2) check++;
		}
		return check;
	}
	
	public static void oxygen(int r, int c) {
		int nr, nc;
		Queue<int[]> queue = new ArrayDeque<>();
		
		if(map[r][c] == 0) map[r][c] = 2; 
		visited[r][c] = true;
		queue.offer(new int[] {r, c});
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int i = 0; i < 4; i++) {
				nr = curr[0] + dr[i];
				nc = curr[1] + dc[i];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
					if(map[nr][nc] == 1) {
						visited[nr][nc] = true;
					}
					else if(map[nr][nc] == 0 || map[nr][nc] == 2) {
						visited[nr][nc] = true;
						map[nr][nc] = 2;
						queue.offer(new int[] {nr, nc});
					}
				}
			}
		}
	}
}
