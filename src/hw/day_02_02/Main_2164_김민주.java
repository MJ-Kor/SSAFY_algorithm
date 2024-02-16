package hw.day_02_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_2164_김민주 {

	private static Queue<Integer> queue = new ArrayDeque<Integer>();
	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 0: 카드 버리기, 1: 카드를 맨 밑으로 옮기기
		int status = 0;
		
		// queue에 요소 삽입
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		// queue에 카드가 1개 남을 때까지 반복
		while(queue.size() != 1) {
			
			// 상태가 0일 경우
			if (status == 0) {
				
				// 카드 버리기
				queue.poll();
				
				// 다음 상태로 변경
				status = 1;
			}
			
			// 상태가 1일 경우
			else {
				
				// 위 카드를 맨 아래로 옮기기 
				queue.offer(queue.poll());
				
				// 다음 상태로 변경
				status = 0;
			}
		}
		System.out.println(queue.peek());
	}
}
