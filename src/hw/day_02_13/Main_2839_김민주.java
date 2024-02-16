package hw.day_02_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_김민주 {

	private static int N;
	private static int five = 5;
	private static int three = 3;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int max = N/five;
		int total = 0;
		int flag = 0;
		
		// 5킬로그램 짜리의 개수를 하나씩 낮춰가는 greedy
		for (int i = max; i >= 0; i--) {
			
			// 나머지 무게가 3킬로그램으로 메꿔지면 break
			if((N - (i*five)) % 3 == 0) {
				total = i + ((N - (i*five)) / 3);
				flag = 1;
				break;
			}
		}
		
		if(flag == 1) {
			System.out.println(total);
		}
		else {
			System.out.println(-1);
		}
	}

}
