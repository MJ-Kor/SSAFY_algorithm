package algorithm_study.day_04_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_8983 {

	private static int result = 0;
	private static int M, N, L;
	private static int[] rowLoc;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		rowLoc = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			rowLoc[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			hunt(0, M - 1, r, c);
		}
		System.out.println(result);
	}

	private static void hunt(int start, int end, int r, int c) {
		int mid = (start + end) / 2;
		
		if(start < end) {
			if(L - Math.abs(r - rowLoc[end]) <= c) result++;
			return;
		}
	
		if(Math.abs(start - end) == 1) {
			if(L - Math.min(Math.abs(rowLoc[start]-r), Math.abs(rowLoc[end]-r)) <= c) result++;
			return;
		}
		
		if(rowLoc[mid] > r) {
			hunt(mid + 1, end, r, c);
		}
		else if(rowLoc[mid] < r) {
			hunt(start, mid - 1, r, c);
		}
		else {
			if(c <= L) result++;
			return;
		}
	}
}
