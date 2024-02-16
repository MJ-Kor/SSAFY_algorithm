package classes;

import java.util.Scanner;

public class BinaryCountingTest {

	private static int N;
	static int[] numbers;
	
	// 입력받은 n개의 수들로 가능한 부분집합의 개수: 경우의 수의 비트마스킹 활용
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 몇개의 수를 입력 받을지 사용자에게 받기
		numbers = new int[N]; // N개의 수를 저장할 배열 생성
		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		
		generateSubset(N);
		
	}

	/**
	 * 입력받은 수(n)개의 부분집합 경우의 수
	 * ex) n = 3일 경우 총 부분집합의 개수는 8개
	 * 입력 받은 수: 1 2 3
	 * 000 => 아무것도 선택 안함
	 * 001 => {3}
	 * 010 => {2}
	 * 011 => {2, 3}
	 * ...
	 * 위의 3자리 비트를 인덱스처럼 인식하여 처리하는 형태
	 * @param n
	 */
	private static void generateSubset(int n) {
		
		// 1<<n: 1000... ==> 0000... ~ 0111... -> 인덱스 대신 활용
		for (int i = 0, caseCount = 1<<n; i < caseCount; i++) { // 현재의 부분집합의 형태
			for (int j = 0; j < N; j++) { // 속해 있는지 확인하고자 하는 원소의 값
				System.out.print((i & 1 << j) != 0 ? numbers[j] : "X");
			}
			System.out.println();
		}
	}
	
}
