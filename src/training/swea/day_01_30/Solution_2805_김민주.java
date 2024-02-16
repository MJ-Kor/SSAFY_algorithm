package training.swea.day_01_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805_김민주 {
	
	/**
	 * 마름모 재귀를 통해 이익을 계산
	 * 
	 * 			   k
	 * 			oooxooo -> s
	 *			ooxxxoo 
	 * 			oxxxxxo
	 * 			xxxxxxx -> k
	 * 			oxxxxxo
	 * 			ooxxxoo
	 * 			oooxooo -> e
	 * 
	 * @param map 밭
	 * @param s 마름모의 첫번째 행 인덱스
	 * @param e 마름모의 마지막 행 인덱스
	 * @param k 전체(입력) 맵의 가운데 인덱스
	 * @return
	 */
	public static int benefit(int[][] map, int s, int e, int k) {
		if (s == e) {
			return map[k][k];
		}
		
		// 마름모 위 꼭짓점 이익
		int sum = map[s][k];

		// s+1 부터 e-1행까지 마름모 겉 부분 계산
		int j = 0;
		for (int i = s + 1; i < e; i++) {
			if(i <= k) {
				++j;
				sum += map[i][k+j];
				sum += map[i][k-j];
			}
			else {
				--j;
				sum += map[i][k+j];
				sum += map[i][k-j];
			}
		}
		
		// 마름모 아래 꼭짓점 이익
		sum += map[e][k];
		
		return sum + benefit(map, s + 1, e - 1, k);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int result = 0;
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			
			result = benefit(map, 0, N - 1, N / 2);
			System.out.println("#" + test_case + " " + result);
		}
	}

}
