package training.swea.day_02_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1861_김민주 {

	private static int[][] map;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	private static int N;
	private static int T;
	private static StringTokenizer st;
	private static Queue<int[]> queue = new ArrayDeque<int[]>();
	private static int max;
	private static int roomNum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			max = -1;
			roomNum = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 방마다 bfs 실행
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					bfs(r, c);
				}
			}
			
			System.out.println("#" + test_case + " " + roomNum + " " + max);
			
		}
	}
	private static void bfs(int r, int c) {
		
		// 시작 방 queue에 삽입
		queue.offer(new int[] {r, c});
		
		// 현재 시작 위치도 포함하므로
		int num = 1;
		int[] info;
		int nr, nc;
		
		// bfs 수행
		while(!queue.isEmpty()) {
			info = queue.poll();
			for (int i = 0; i < dr.length; i++) {
				
				// 상하좌우 탐색
				nr = info[0] + dr[i];
				nc = info[1] + dc[i];
				
				// 상하좌우로 이동한 위치가 유효한지 판단하고, 이동한 위치의 값이 기존 값보다 1이 더 크면
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && ((map[nr][nc] - map[info[0]][info[1]]) == 1)) {
					
					// 방을 queue에 추가 및 count
					queue.offer(new int[] {nr, nc});
					num++;
				}
			}
		}
		
		
		if(num > max) {
			max = num;
			roomNum = map[r][c];
		}
		
		// 이동할 수 있는 방의 개수가 같을 때, 숫자가 작은 방을 저장
		else if(num == max) {
			if(roomNum > map[r][c]) {
				roomNum = map[r][c];
			}
		}
	}
}
