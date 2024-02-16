package training.boj.day_02_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

// r, c, s 클래스
class operation{
	int r;
	int c;
	int s;
	
	public operation(int r, int c, int s) {
		this.r = r;
		this.c = c;
		this.s = s;
	}
}

public class Main_17406_김민주 {

	private static int result = Integer.MAX_VALUE;
	private static int N, M, K, r, c, s;
	private static boolean[] isSelected;
	private static int[][] arr;
	private static ArrayList<operation> opers = new ArrayList<>();
	private static Deque<Integer> deque = new ArrayDeque<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		isSelected = new boolean[K];
		
		arr = new int[N+1][M+1];
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			opers.add(new operation(r, c, s));
		}
		
		backTracking(deepCopy(arr), K);
		System.out.println(result);
	}
	
	// 연산자를 순열로 뽑아서 경우의 수만큼 계산
	public static void backTracking(int[][] tmp, int cnt) {
		if (cnt == 0) {
			
			// 연산이 끝났으면 A 계산
			int A = calculation(tmp);
			if(A < result) {
				result = A;
			}
		} else {
			for(int i = 0; i < K; i++) {
				if(isSelected[i]) continue;
				isSelected[i] = true;
				
				// 회전한 배열을 다음 배열로 넘겨줌
				backTracking(rotate(deepCopy(tmp), opers.get(i)), cnt - 1);
				isSelected[i] = false;
			}
		}
	}
	
	// 회전 메서드
	public static int[][] rotate(int[][] tmp, operation op) {
		
		int start_r = op.r - op.s;
		int start_c = op.c - op.s;
		int end_r = op.r + op.s;
		int end_c = op.c + op.s;
		
		int startNum = ((end_r - start_r) > (end_c - start_c)) ? ((end_c - start_c) + 1) / 2 : ((end_r - start_r) + 1) / 2;
		
		for (int i = 0; i < startNum; i++) {
			// 반시계 방향으로 돌면서 덱에 데이터 저장
			// 아래 방향
			for(int k = start_r + 1 + i; k <= end_r - i; k++) {
				deque.addFirst(tmp[k][start_c + i]);
			}
			// 오른쪽 방향
			for(int k = start_c + 1 + i; k <= end_c - i; k++) {
				deque.addFirst(tmp[end_r - i][k]);
			}
			// 위 방향
			for(int k = end_r - 1 - i; k >= start_r + i; k--) {
				deque.addFirst(tmp[k][end_c - i]);
			}
			// 왼쪽 방향
			for(int k = end_c - 1 - i; k >= start_c + i; k--) {
				deque.addFirst(tmp[start_r + i][k]);
			}
			
			// 시계 방향으로 1번 회전
			deque.addFirst(deque.pollLast());
			
			// 회전한 값 배열에 삽입
			for(int k = start_r + 1 + i; k <= end_r - i; k++) {
				tmp[k][start_c + i] = deque.pollLast();
			}
			// 오른쪽 방향
			for(int k = start_c + 1 + i; k <= end_c - i; k++) {
				tmp[end_r - i][k] = deque.pollLast();
			}
			// 위 방향
			for(int k = end_r - 1 - i; k >= start_r + i; k--) {
				tmp[k][end_c - i] = deque.pollLast();
			}
			// 왼쪽 방향
			for(int k = end_c - 1 - i; k >= start_c + i; k--) {
				tmp[start_r + i][k] = deque.pollLast();
			}
	}
	return tmp;
}
	
	// A 계산 메서드
	public static int calculation(int[][] tmp) {
		
		int min = Integer.MAX_VALUE;
		for (int r = 1; r <= N; r++) {
			int sum = Arrays.stream(tmp[r]).sum();
			if(sum < min) {
				min = sum;
			}
		}
		return min;
	}
	
	// 배열 복사 메서드
	public static int[][] deepCopy(int[][] original){
		if (original == null) return null;
		
		int[][] copied = new int[original.length][original[0].length];
		for (int i = 0; i < copied.length; i++) {
			System.arraycopy(original[i], 0, copied[i], 0, original[0].length);
		}
		return copied;
	}
}
