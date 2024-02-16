package classes;

import java.util.Arrays;
import java.util.Scanner;

// nPn, nPr
public class BitmaskingPermutationTest {

	static int N, R, input[], numbers[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[R];
		numbers = new int[R];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();	
		}
		
		permutation(0, 0);
	}
	
	public static void permutation(int cnt, int flag) {	
		
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((flag & 1<<i) != 0) continue; 		// i 인덱스에 해당하는 수가 사용중이면 패스
			numbers[cnt] = input[i]; // 수 선택
			permutation(cnt + 1, flag | 1<<i); 		// 다음 수 뽑으러 가기, 기존 상태에 체크한 수 합치기
			
		}
	}
}
