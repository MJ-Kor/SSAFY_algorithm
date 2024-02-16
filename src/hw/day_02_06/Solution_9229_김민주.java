package hw.day_02_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9229_김민주 {

	private static boolean visited[];
	private static int number[];
	private static int arr[];
	private static int N;
	private static int M;
	private static int max;
	
	// 2개를 선택하는 조합 재귀함수
	private static void maxSum(int e, int cnt) {
		
		// 과자 2개를 골랐을때 지금까지 구한 것보다 크고 최대 값을 넘지 않으면 갱신
		if(cnt == 0) {
			if(number[cnt + 1] + number[cnt]>max && number[cnt + 1] + number[cnt] <=M) {
				max = number[cnt + 1] + number[cnt];
			}
			return;
		}
		else {
			for(int i = e; i < N; i++ ) {
				visited[i] = true;
				number[cnt - 1] = arr[i];
				maxSum(i + 1, cnt - 1);
				visited[i] = false;
				
				// 가지치기: 선택한 과자가 최대 값과 같으면 탐색 중지
				if(max == M) {
					return;
				}
			}

		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			max = -1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			visited = new boolean[N];
			number = new int[2];
			maxSum(0, 2);
			System.out.println("#" + test_case + " " + max);
		}
		
	}

}
