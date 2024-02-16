package training.swea.day_01_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Solution_1208_김민주 {

	private static int T = 10;
	private static int MAX = 100;
	
	
	public static void dump(int N, int[] buildings) {
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 입출력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 배열 원소 입력 받기
		for (int test_case = 1; test_case <= T; test_case++) {
			int[] buildings = new int[MAX];
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < MAX; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}
			
			// N번 만큼 dump 진행
			for (int i = 0; i < N; i++) {
				
				// stream으로 max와 min값 구하기
				int max = Arrays.stream(buildings).max().getAsInt();
				int min = Arrays.stream(buildings).min().getAsInt();
				
				// stream으로 maxIdx와 minIdx값 구하기
				int maxIdx = IntStream.range(0, buildings.length)
								  	  .filter(idx -> max == buildings[idx])
								  	  .findFirst()
								  	  .getAsInt();
				int minIdx = IntStream.range(0, buildings.length)
						  			  .filter(idx -> min == buildings[idx])
						  			  .findFirst()
						  			  .getAsInt();
				// 블럭 옮기기
				buildings[maxIdx]--;
				buildings[minIdx]++;
			}
			
			// 답 출력
			System.out.println("#" + test_case + " " + (Arrays.stream(buildings).max().getAsInt() - Arrays.stream(buildings).min().getAsInt()));
			
		}
	}

}
