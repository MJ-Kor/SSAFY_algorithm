package training.boj.day_02_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935_김민주 {
	
	private static int[][] arr;
	private static int N, M, R;
	
	public static void one() {
		int n = arr.length;
		int m = arr[0].length;
		int[][] tmp = new int[n][m];
		for (int r = n - 1; r >= 0; r--) {
			tmp[n - 1 - r] = arr[r];
		}
		arr = tmp;
	}
	
	public static void two() {
		int n = arr.length;
		int m = arr[0].length;
		int[][] tmp = new int[n][m];
		for (int c = m - 1; c >= 0; c--) {
			for(int r = 0; r < n; r++) {
				tmp[r][m - 1 - c] = arr[r][c];
			}
		}
		arr = tmp;
	}

	public static void three() {
		int n = arr.length;
		int m = arr[0].length;
		int[][] tmp = new int[m][n];
		int[] tmpLine;
		for (int c = 0; c < m; c++) {
			tmpLine = new int[n];
			for (int r = n - 1; r >= 0; r--) {
	 			tmpLine[(n - 1) - r] = arr[r][c];
			}
			tmp[c] = tmpLine;
		}
		arr = tmp;
	}

	public static void four() {
		int n = arr.length;
		int m = arr[0].length;
		int[][] tmp = new int[m][n];
		int[] tmpLine;
		for (int c = m - 1; c >= 0; c--) {
			tmpLine = new int[n];
			for (int r = 0; r < n; r++) {
	 			tmpLine[r] = arr[r][c];
			}
			tmp[(m - 1) - c] = tmpLine;
		}
		arr = tmp;
	}

	public static void five() {
		int n = arr.length;
		int m = arr[0].length;
		int[][] tmp = new int[n][m];
		
		for (int r = 0; r <= (n / 2) - 1; r++) {
			for (int c = 0; c <= (m / 2) - 1; c++) {
				tmp[r][c + (m / 2)] = arr[r][c];
			}
		}
		
		for (int r = 0; r <= (n / 2) - 1; r++) {
			for (int c = m / 2 ; c <= m - 1; c++) {
				tmp[r + (n / 2)][c] = arr[r][c];
			}
		}
		
		for (int r = n / 2; r <= n - 1; r++) {
			for (int c = m / 2 ; c <= m - 1; c++) {
				tmp[r][c - (m / 2)] = arr[r][c];
			}
		}
		
		for (int r = n / 2; r <= n - 1; r++) {
			for (int c = 0; c <= (m / 2) - 1; c++) {
				tmp[r - (n / 2)][c] = arr[r][c];
			}
		}
		
		arr = tmp;
	}

	public static void six() {
		int n = arr.length;
		int m = arr[0].length;
		int[][] tmp = new int[n][m];
		
		for (int r = 0; r <= (n / 2) - 1; r++) {
			for (int c = 0; c <= (m / 2) - 1; c++) {
				tmp[r + (n / 2)][c] = arr[r][c];
			}
		}
		
		for (int r = 0; r <= (n / 2) - 1; r++) {
			for (int c = m / 2 ; c <= m - 1; c++) {
				tmp[r][c - (m / 2)] = arr[r][c];
			}
		}
		
		for (int r = n / 2; r <= n - 1; r++) {
			for (int c = m / 2 ; c <= m - 1; c++) {
				tmp[r - (n / 2)][c] = arr[r][c];
			}
		}
		
		for (int r = n / 2; r <= n - 1; r++) {
			for (int c = 0; c <= (m / 2) - 1; c++) {
				tmp[r][c + (m / 2)] = arr[r][c];
			}
		}
		
		arr = tmp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < R; i++) {
			int num = Integer.parseInt(st.nextToken());
				switch (num) {
				case 1:{
					one();
					break;
				}
				case 2:{
					two();
					break;
				}
				case 3:{
					three();
					break;
				}
				case 4:{
					four();
					break;
				}
				case 5:{
					five();
					break;
				}
				case 6:{
					six();
					break;
				}
			}
		}
		
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[0].length; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
	}
}
