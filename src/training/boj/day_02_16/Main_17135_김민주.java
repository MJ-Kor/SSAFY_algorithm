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
		selectArcher_comb(0, 0);
		System.out.println(max);
	}
	
	// 궁수 위치를 조합으로 선정
	public static void selectArcher_comb(int cnt, int start) {
		if (cnt == archerNum) {
			
			// 궁수 위치 뽑으면 디펜스 시작
			defence(deepCopy(map));
			return;
		}
		
		for (int i = start; i < C; i++) {
			archerCol[cnt] = i;
			selectArcher_comb(cnt + 1, i + 1);
		}
	}
	
	public static void defence(int[][]map) {
		int kill = 0;
		// 각 궁수별 공격할 적 위치 배열
		int[][] attackPos = {{R + 1, 0},{R + 1 , 0},{R + 1, 0}};
		
		for (int archerLine = R; archerLine >= 1; archerLine--) {
			// 이전 궁수가 공격할 적의 위치
			int[] prev = {-2, -2};
			// 현재 궁수가 공격할 적의 위치
			int[] curr = new int[2];
			
			// 궁수 앞으로 당김(적 대신 당김), 다음 턴 준비
			for (int c = 0; c < C; c++) {
				map[archerLine][c] = -2;
			}
			
			// 각 궁수별 공격할 적 위치 탐색
			for (int i = 0; i < archerCol.length; i++) {
				
				// bfs로 궁수가 공격할 적 위치 탐색
				curr = bfsAttack(map, archerLine, archerCol[i], i);
				
				// 이전 궁수 공격과 같은 위치이거나 공격을 안했으면 킬 카운트 안세고 attackPos에도 정보를 주지 않음
				if((curr[0] == prev[0] && curr[1] == prev[1]) | (curr[0] == -1 && curr[1] == -1)) {
					continue;
				}
				
				kill++;
				prev[0] = curr[0];
				prev[1] = curr[1];
				attackPos[i][0] = curr[0];
				attackPos[i][1] = curr[1];
				// 한 턴 끝
			}
			
			// 각 궁수가 공격한 위치에 적을 없앰
			for (int i = 0; i < 3; i++) {
				map[attackPos[i][0]][attackPos[i][1]] = 0;				
			}
		}
		// 킬 카운트 갱신
		if(max < kill) max = kill;
	}
	
	// bfs로 궁수가 공격할 적의 위치 찾기 -> 좌 상 우 순으로 확인을 하여 가장 가깝고, 제일 왼쪽인 적을 탐색
	public static int[] bfsAttack(int[][]map, int archerR, int archerC, int archerIdx) {
		int enemyR = -1;
		int enemyC = -1;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {archerR, archerC, 0});
		
		while(!queue.isEmpty()) {
			int flag = 0;
			int[] current = queue.poll();
			// 탐색할 위치가 궁수의 사정거리보다 클 경우 탐색을 종료
			if(current[2] >= D) break;
			int width = current[2] + 1;
			for (int i = 0; i < 3; i++) {
				int nr = current[0] + dr[i];
				int nc = current[1] + dc[i];
				// 탐색 위치가 맵 안쪽이어야 하고, 성벽이 아니어야 함
				if(nr >= 0 && nr < R + 1 && nc >= 0 && nc < C && map[nr][nc] != -2) {
					if(map[nr][nc] == 1) {
						enemyR = nr;
						enemyC = nc;
						// 적을 찾으면 bfs를 빠져나가기 위한 플래그
						flag = 1;
						break;
					}
					queue.offer(new int[] {nr, nc, width});
				}
			}
			if(flag == 1) break;
		}
		// 공격할 적의 위치 반환
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