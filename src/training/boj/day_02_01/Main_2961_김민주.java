package training.boj.day_02_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * 신맛: 사용한 재료의 신맛의 곱
 * 쓴맛: 사용한 재료의 쓴맛의 합
 * 구하려는 것: 신맛과 쓴맛의 차이가 가장 작은 요리
 * 조건: 하나 이상의 재료를 사용해야 함
 * 
 * 입력 format
 * 1. 재료의 개수 N
 * 2. 재료의 신맛, 재료의 쓴 맛
 * @author SSAFY
 *
 */
public class Main_2961_김민주 {

	private static int N;
	private static int min = Integer.MAX_VALUE;
	private static int[] sourTaste;
	private static int[] bitterTaste;
	private static int[] isSelected;
	private static void cook(int cnt, int sour, int bitter) {
		
		if(cnt == N) {
			if(IntStream.of(isSelected).anyMatch(x -> x == 1)) {
				int taste = Math.abs(sour - bitter);
				if (min > taste) {
					min = taste;
				}
			}
			return;
		}
		
		isSelected[cnt] = 1;
		cook(cnt + 1, sour * sourTaste[cnt], bitter + bitterTaste[cnt]);
		isSelected[cnt] = 0;
		cook(cnt + 1, sour, bitter);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		sourTaste = new int[N];
		bitterTaste = new int[N];
		isSelected = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sourTaste[i] = Integer.parseInt(st.nextToken());
			bitterTaste[i] = Integer.parseInt(st.nextToken());
		}
		
		cook(0, 1, 0);
		
		System.out.println(min);
		
	}

}
