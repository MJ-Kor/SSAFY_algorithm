package training.swea.day_02_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_김민주 {

	private static int T = 10;
	private static int numCode = 8;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> queue;
		int num;
		int cnt = 1;
		int check;
		
		// TestCase
		for (int i = 1; i <= T; i++) {
			cnt = 1;
			num = Integer.parseInt(br.readLine());
			queue = new ArrayDeque<Integer>();
			st = new StringTokenizer(br.readLine());
			
			// 입력으로 queue 초기화
			for (int j = 0; j < numCode; j++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			
			while(true) {
				
				// 맨 앞 숫자를 queue에서 빼고 cnt를 빼줌
				check = queue.poll()-cnt;
				
				// 0보다 작으면 0으로 바꿔준 뒤, queue맨 뒤에 삽입
				if(check <= 0) {
					check = 0;
					queue.offer(check);
					break;
				}
				
				// 0보다 크면 그냥 삽입
				queue.offer(check);
				
				// 세트 1회가 끝나면 다시 cnt 초기화
				if(cnt == 5) {
					cnt = 1;
				}
				else {
					cnt++;
				}
			}
			
			System.out.print("#" + num + " ");
			for (int j = 0; j < numCode; j++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
	}

}
