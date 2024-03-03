package training.swea.extra.practice_A;

/*
 * 1시간 46분
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_2112_김민주 {
	
	private static int[][] film;
	private static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			film = new int[D][W];
			boolean[] isSelected = new boolean[D];
			
			for (int r = 0; r < D; r++) {
				film[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			subset(0, D, W, K, isSelected);
			System.out.println("#" + test_case + " " + min);
		}
	}

	private static void subset(int cnt, int D, int W, int K, boolean[] isSelected) {
		if(cnt == D) {
			List<Integer> selectedRow = new ArrayList<>();
			for (int i = 0; i < D; i++) {
				if(isSelected[i]) {
					selectedRow.add(i);
				}
			}
			
//			System.out.println("주입 행 선택: " + Arrays.toString(selectedRow.toArray()));
			int N = selectedRow.size();
			if(N < min) {
				boolean[] injectionSelected = new boolean[N];
				injection(0, N, K, selectedRow, injectionSelected);
			}
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt + 1, D, W, K, isSelected);
		isSelected[cnt] = false;
		subset(cnt + 1, D, W, K, isSelected);
	}

	private static void injection(int cnt, int N, int K, List<Integer> selectedRow, boolean[] injectionSelected) {
		if(cnt == N) {
			List<Integer> aList = new ArrayList<>();
			List<Integer> bList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if(injectionSelected[i]) aList.add(selectedRow.get(i));
				else bList.add(selectedRow.get(i));
			}
			change(deepCopy(film), aList, bList, K);
			 
			return;
		}
		
		injectionSelected[cnt] = true;
		injection(cnt + 1, N, K, selectedRow, injectionSelected);
		injectionSelected[cnt] = false;
		injection(cnt + 1, N, K, selectedRow, injectionSelected);
	}

	private static void change(int[][] newFilm, List<Integer> aList, List<Integer> bList, int K) {
		int W = newFilm[0].length;
		
		for (int i = 0; i < aList.size(); i++) {
			for (int w = 0; w < W; w++) {
				newFilm[aList.get(i)][w] = 0;
			}
		}
		
		for (int i = 0; i < bList.size(); i++) {
			for (int w = 0; w < W; w++) {
				newFilm[bList.get(i)][w] = 1;
			}
		}
		
//		for (int i = 0; i < newFilm.length; i++) {
//			System.out.println(Arrays.toString(newFilm[i]));
//		}
		
//		System.out.println(checkValid(newFilm, K));
		if(checkValid(newFilm, K)) {
			min = Math.min(min, aList.size() + bList.size());
		}
		
		return;
	}

	private static boolean checkValid(int[][] newFilm, int K) {
		
		int D = newFilm.length;
		int W = newFilm[0].length;
//		System.out.println("D: " + D);
//		System.out.println("W: " + W);
//		System.out.println("K: " + K);
		boolean valid = false;
		
		for (int w = 0; w < W; w++) {
			valid = false;
			int count = 1;
			int num = newFilm[0][w];
			if(count == K) {
				valid = true;
				continue;
			}
			for (int d = 1; d < D; d++) {
				if(num == newFilm[d][w]) {
					++count;
//					System.out.println("w: " + w + "d " + d + "count " + count);
					if(count == K) {
						valid = true;
						break;
					}
				}
				else {
					count = 1;
					num = newFilm[d][w];
				}
			}
			
			if(!valid) {
				return false;
			}
		}
		
		return valid;
	}

	private static int[][] deepCopy(int[][] film){
		int R = film.length;
		int C = film[0].length;
		int[][] newFilm = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				newFilm[r][c] = film[r][c];
			}
		}
		
		return newFilm;
	}
	
}
