package training.boj.day_02_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main_16236_김민주 {

	static class Shark{
		int r, c;
		int size = 2;
		int ate = 0;
		
		public Shark(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int N;
	static int time = 0;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		Shark babyShark = null;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					babyShark = new Shark(i, j);
				}
			}
		}
		
		bfs(babyShark);
	}

	private static void bfs(Shark babyShark) {
		List<int[]> canEat = new ArrayList<>();
		Queue<Shark> queue = new ArrayDeque<>();
		queue.offer(babyShark);
		int breath = 0;
		while(!queue.isEmpty()) {
			Shark curr = queue.poll();
			if(breath != curr[2]) {
				if(canEat.size() == 0) {
					breath += 1;
				}
				else {				
					int[] newCoord = checkEat(canEat);
					babyShark.r = newCoord[0];
					babyShark.c = newCoord[1];
					babyShark.ate += 1;
					if(babyShark.size == babyShark.ate) babyShark.size += 1;
					break;
				}
			}
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if(map[nr][nc] < babyShark.size) {
						queue.offer(new int[] {nr, nc});
						canEat.add(new int[] {nr, nc});
					}
				}
			}
		}
	}

	private static int[] checkEat(List<int[]> canEat) {
		return dc;
	}
	

}
