package training.boj.day_02_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_16926_김민주 {

	private static Deque<Integer> deque = new ArrayDeque<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		// 데이터 입력
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 돌릴 사각형 수: min(N, M) / 2
		int startNum = (N > M) ? M/2 : N/2;
		for (int i = 0; i < startNum; i++) {
			
			/** 
			 * 
			 *   ← ― ― ― ― ↑
			 * 	   ｜   ← ― ― ↑ ｜
			 * 	   ｜  ｜	   ｜   ｜
			 *	   ｜  ↓	 ― ― → ｜   
			 *   ↓ ― ― ― ― →
			 * 
			 */
			
			// 반시계 방향으로 돌면서 덱에 데이터 저장
			// 아래 방향
			for(int k = 1 + i; k <= N - 1 - i; k++) {
				deque.addFirst(arr[k][i]);
			}
			// 오른쪽 방향
			for(int k = 1 + i; k <= M - 1 - i; k++) {
				deque.addFirst(arr[N - 1 - i][k]);
			}
			// 위 방향
			for(int k = N - 2 - i; k >= i; k--) {
				deque.addFirst(arr[k][M - 1 - i]);
			}
			// 왼쪽 방향
			for(int k = M - 2 - i; k >= i; k--) {
				deque.addFirst(arr[i][k]);
			}
			
			// R번 회전
			for (int j = 0; j < R; j++) {
				deque.addLast(deque.pollFirst());
			}
			
			// 회전한 값 배열에 삽입
			for(int k = 1 + i; k <= N - 1 - i; k++) {
				arr[k][i] = deque.pollLast();
			}
			for(int k = 1 + i; k <= M - 1 - i; k++) {
				arr[N - 1 - i][k] = deque.pollLast();
			}
			for(int k = N - 2 - i; k >= i; k--) {
				arr[k][M - 1 - i] = deque.pollLast();
			}
			for(int k = M - 2 - i; k >= i; k--) {
				arr[i][k] = deque.pollLast();
			}
			
		}

		// 출력
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		} 
		
	}

}
