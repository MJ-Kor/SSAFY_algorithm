package training.boj.day_01_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650_김민주 {

	public static int N;
	public static int M;
	public static int[] arr;
	public static boolean[] isSelected;
	
	public static void combination(int cnt, int start) {
		if(cnt == M) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i <= N; i++) {
			if (isSelected[i] == true) {
				continue;
			}
			arr[cnt] = i;
			isSelected[i] = true;
			combination(cnt + 1, i + 1);
			isSelected[i] = false;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		isSelected = new boolean[N + 1];
		combination(0, 1);
	}

}
