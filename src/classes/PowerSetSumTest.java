package classes;

import java.util.Scanner;

// N개의 원소를 입력받아 가능한 모든 부분집합 생성 후, 목표 합이 되는 집합 찾기
// 10 >= N >= 1
public class PowerSetSumTest {

	static int N, input[], target;
	static boolean isSelected[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		target = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubSet(0, 0);
		
	}
	
	private static void generateSubSet(int cnt, int sum) { // sum: 기존 부분집합의 구성요소를 더한 것
		
		if(cnt == N) { // 모든 원소가 고려되었다면 부분집합을 구성하는 원소들의 합이 목표합이 되는지 체크
			if(sum == target) {
				for (int i = 0; i < N; i++) {
					if(isSelected[i]) System.out.print(input[i] + "\t");
				}
				System.out.println();
			}
			return;
		}
		
		isSelected[cnt] = true;
		generateSubSet(cnt + 1, sum + input[cnt]);
		isSelected[cnt] = false;
		generateSubSet(cnt + 1, sum);
	}

}
