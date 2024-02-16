package classes;

import java.util.Arrays;
import java.util.Scanner;

// 주사위 던지기(던지는 횟수는 6번 이하)
// 일반 순열이기 때문에 최대 6번

public class DiceTest {

	static int N, numbers[];
	static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		int mode = sc.nextInt();
		switch (mode) {
		case 1: // 중복 순열
			isSelected = new boolean[7]; // 주사위의 눈이 사용되었는가 1~6 사용
			dice1(0);
			break;
			
		case 2: // 순열: 중복 관리
			isSelected = new boolean[7];
			dice2(0);
			break;

		case 3: // 순열: 중복 관리
			dice3(0, 1);
			break;
			
		case 4: // 중복순열: 중복 관리
			dice3(0, 1);
			break;
		}
		
		
	}
	
	private static void dice1(int cnt) { // 주사위 던지기(cnt: 기존까지 던진 주사위 수)
		
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 1; i <= 6; i++) { // 모든 주사위 눈의 수를 시도(i: 주사위 눈의 수)
			numbers[cnt] = i;
			
			// cnt += 1; 이렇게 보내면 재귀 함수 이후에 하나 줄여줘야함. 아래처럼 넘기는게 나음
			dice1(cnt + 1);
		}
	}
	
	private static void dice2(int cnt) { // 주사위 던지기(cnt: 기존까지 던진 주사위 수)
		
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 1; i <= 6; i++) { // 모든 주사위 눈의 수를 시도(i: 주사위 눈의 수)
			if(isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
			// cnt += 1; 이렇게 보내면 재귀 함수 이후에 하나 줄여줘야함. 아래처럼 넘기는게 나음
			dice2(cnt + 1);
			
			isSelected[i] = false;
		}
	}
	
	private static void dice3(int cnt, int start) { // 중복조합
		
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		
		// 시작점부터 가능한 끝까지 선택하는 시도
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt + 1, i); // 현재 선택한 수의 다음부터 선택하도록 시작점 추기!!!
		}
		
	}


	
	private static void dice4(int cnt, int start) {
		
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		
		// 시작점부터 가능한 끝까지 선택하는 시도
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt + 1, i + 1); // 현재 선택한 수의 다음부터 선택하도록 시작점 추기!!!
		}
		
	}

}
