package training.boj.day_01_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_김민주 {
	
	static int[] isSelected;
	static int[] arr;
	static StringBuilder bf = new StringBuilder();
	
	public static void perm(int N, int M, int depth) {
		if (M == depth) {
			for(int a : arr) {
				bf.append(a).append(' ');
			}
			bf.append("\n");
			return;
		}
		else {
			for (int n = 1; n <= N; n++) {
				if (isSelected[n] != 1) {
					isSelected[n] = 1;
					arr[depth] = n; 
					perm(N, M, depth + 1);
					isSelected[n] = 0;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		isSelected = new int[N + 1];
		arr = new int[M];
		
		perm(N, M, 0);
		
		System.out.println(bf);
	}

}
