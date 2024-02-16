package training.boj.day_02_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135_김민주 {

	private static int max = Integer.MIN_VALUE;
	private static int archerNum = 3;
	private static int R, C, D;
	private static int dr[] = {0, -1, 0};
	private static int dc[] = {-1, 0, 1};
	private static int[] archerCol = new int[archerNum];
	
	private static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[R + 2][C];
		
		for (int r = 0; r < R; r++) {
			map[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		for (int c = 0; c < C; c++) {
			map[R][c] = -2;
		}
		
		gameStart();
		
	}
	
	public static void gameStart() {
		System.out.println("start gameStart");
		selectArcher_comb(0, 0);
		System.out.println(max);
	}
	
	public static void selectArcher_comb(int cnt, int start) {
		
		System.out.println("start selectArcher_comb" + " " + cnt);
		if (cnt == archerNum) {
			System.out.println(Arrays.toString(archerCol));
			defence(deepCopy(map));
			System.out.println("end defence" + " " + cnt);
			return;
		}
		
		for (int i = start; i < C; i++) {
			archerCol[cnt] = i;
			selectArcher_comb(cnt + 1, i + 1);
		}
	}
	
	public static void defence(int[][]map) {
		int kill = 0;
		int validCount = 0;
		// 각 궁수별 공격할 적 위치 배열
		int[][] attackPos = {{R + 1, 0},{R + 1 , 0},{R + 1, 0}};
		
		
		for (int archerLine = R; archerLine >= 1; archerLine--) {
			
			int[] prev = {-2, -2};
			int[] curr = new int[2];
			
			// 궁수 앞으로 당김(적 대신 당김), 다음 턴 준비
			for (int c = 0; c < C; c++) {
				map[archerLine][c] = -2;
			}
			
			// 각 궁수별 공격할 적 위치 탐색
			for (int i = 0; i < archerCol.length; i++) {
				curr = bfsAttack(map, archerLine, archerCol[i], i);
				System.out.println(curr[0] + " " + curr[1]);
				
				// 이전 궁수 공격과 같은 위치이거나 공격을 안했으면..
				if((curr[0] == prev[0] && curr[1] == prev[1]) | (curr[0] == -1 && curr[1] == -1)) {
					continue;
				}
				
				kill++;
				validCount++;
				prev[0] = curr[0];
				prev[1] = curr[1];
				attackPos[i][0] = curr[0];
				attackPos[i][1] = curr[1];
				// 한 턴 끝
			}
			
			for (int i = 0; i < validCount; i++) {
				map[attackPos[i][0]][attackPos[i][1]] = 0;				
			}
			
			validCount = 0;
			
			for (int r = 0; r <= R; r++) {
				System.out.println(Arrays.toString(map[r]));
			}
			
		}
		
		if(max < kill) max = kill;
	}
	
	public static int[] bfsAttack(int[][]map, int archerR, int archerC, int archerIdx) {
		int enemyR = -1;
		int enemyC = -1;
		
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] {archerR, archerC, 0});
		
		while(!queue.isEmpty()) {
			int flag = 0;
			int[] current = queue.poll();
			System.out.println("q에서 나온것: " + Arrays.toString(current));
			if(current[2] >= D) break;
			int width = current[2] + 1;
			for (int i = 0; i < 3; i++) {
				int nr = current[0] + dr[i];
				int nc = current[1] + dc[i];
				System.out.println("nr nc" + " " + nr + " " + nc);
				if(nr >= 0 && nr < R + 1 && nc >= 0 && nc < C && map[nr][nc] != -2) {
					if(map[nr][nc] == 1) {
						enemyR = nr;
						enemyC = nc;
						flag = 1;
						break;
					}
					queue.offer(new int[] {nr, nc, width});
				}
			}
			if(flag == 1) break;
		}
		
		System.out.println("return " + enemyR + " " + enemyC);
		return new int[] {enemyR, enemyC};
		
	}
	
	public static int[][] deepCopy(int[][] original){
		if (original == null) return null;
		
		int[][] copied = new int[original.length][original[0].length];
		for (int i = 0; i < copied.length; i++) {
			System.arraycopy(original[i], 0, copied[i], 0, original[0].length);
		}
		return copied;
	}

}