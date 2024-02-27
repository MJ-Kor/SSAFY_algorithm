package training.boj.day_02_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_김민주 {

	static class Shark{
		int r, c, size;
		int ate = 0;
		
		public Shark(int r, int c, int size) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
		}
		
	}
	
	static int time = 0;
	static int N;
	static int[] dr = {-1, 0 ,0 ,1}; // 상 좌 우 하
	static int[] dc = {0, -1 ,1 ,0};
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		Shark babyShark = null;
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());			
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 9) {
					babyShark = new Shark(r, c, 2);
					map[r][c] = 0;
				}
			}
		}
		while(true) {
			//System.out.println("bsp: " + babyShark.r + " " + babyShark.c);
			bfs(babyShark);
		}
	}
	
	private static void bfs(Shark babyShark) {
		boolean[][] visited = new boolean[N][N];
		List<int[]> canEat = new ArrayList<>();
		Queue<int[]> queue = new ArrayDeque<>();
		int breath = 0; // 아기 상어가 이동할 거리 역할
		visited[babyShark.r][babyShark.c] = true;
		queue.offer(new int[] {babyShark.r, babyShark.c, 0});
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			if(curr[2] != breath) { // 한 너비 탐색이 끝나면
				if(canEat.size() != 0) { // 먹잇감이 있다!
					int[] eatPosition = checkEat(canEat); // 먹잇감 위치 탐색
					//System.out.println(eatPosition[0] + " "+ eatPosition[1]);
					babyShark.r = eatPosition[0];	// 아기상어가
					babyShark.c = eatPosition[1];	// 먹잇감
					babyShark.ate +=1;				// 먹고
					if(babyShark.ate == babyShark.size) {	// 덩치 커침
						babyShark.size += 1;
						babyShark.ate = 0;
					}
					time += eatPosition[2];  // 이동한 시간
					map[eatPosition[0]][eatPosition[1]] = 0;  // 먹잇감 없음
					return;
				}
				breath = curr[2];
			}
			
			// 먹잇감 탐색
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] <= babyShark.size) {
					if(map[nr][nc] < babyShark.size && map[nr][nc] > 0) {							
						canEat.add(new int[] {nr, nc, curr[2] + 1});
					}
					visited[nr][nc] = true;
					queue.offer(new int[] {nr, nc, curr[2] + 1});
				}
			}
		}
		
		// 다 탐색했는데 없으니까 엄마 부름
		System.out.println(time);
		System.exit(0);
	}

	// 가장 좌상단에 있는 먹잇감 찾기
	private static int[] checkEat(List<int[]> canEat) {
		Collections.sort(canEat, (o1, o2) -> {
			if(o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			} else {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
//		for (int i = 0; i < canEat.size(); i++) {
//			System.out.println(Arrays.toString(canEat.get(i)));
//		}
		return canEat.get(0);
	}
}
