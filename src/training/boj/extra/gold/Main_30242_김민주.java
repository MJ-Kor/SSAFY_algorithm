package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_30242_김민주 {

	private static int N;
	private static int[] chessMap;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		chessMap = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			chessMap[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		perm(0);
		
		System.out.println(-1);
		
	}
	
	private static void perm(int cnt) {

		if(cnt == N) {
			for (int i = 0; i < N; i++) System.out.print((chessMap[i] + 1) + " ");
			System.exit(0);
			return;
		}
		
		if(chessMap[cnt] != -1) {
			if(promising(cnt)) {
				perm(cnt + 1);
			}
			else {
				return;
			}
		}
		else {
			for (int i = 0; i < N; i++) {
				chessMap[cnt] = i;
				if (promising(cnt)) {
					perm(cnt + 1);
				}
				chessMap[cnt] = -1;
			}
		}
	}

	private static boolean promising(int cnt) {
		for (int i = 0; i < cnt; i++) {
			if(chessMap[cnt] == chessMap[i] |  Math.abs(cnt - i) == Math.abs(chessMap[cnt] - chessMap[i])) {
				return false;
			}
		}
		return true;
	}
}
