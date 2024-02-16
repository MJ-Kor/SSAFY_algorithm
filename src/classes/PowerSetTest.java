package classes;

import java.util.Scanner;

// N개의 원소를 입력받아 가능한 모든 부분집합 생성
// 10 >= N >= 1
public class PowerSetTest {

	static int N, input[];
	static boolean isSelected[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		generateSubSet(0);
		
	}
	
	private static void generateSubSet(int cnt) {
		
		if(cnt == N) { // 모든 원소가 고려되었다면
			for (int i = 0; i < N; i++) {
				System.out.print((isSelected[i]?input[i]:"X") + "\t");
			}
			System.out.println();
			return;
		}
		
		isSelected[cnt] = true;
		generateSubSet(cnt + 1);
		isSelected[cnt] = false;
		generateSubSet(cnt + 1);
	}

}
