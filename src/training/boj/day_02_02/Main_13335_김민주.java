package training.boj.day_02_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 입력 format
 * 1. 다리를 건너는 트럭의 수 n, 다리의 길이 w, 다리의 최대 하중 L
 * 2. 트럭의 무게를 나타내는 n개의 정수 a_i
 * 
 * 조건
 * 1. w대의 트럭만 동시에 올라갈 수 있다.
 * 2. 각 트럭들은 하나의 단위시간에 하나의 단위 길이만큼만 이동할 수 있다.
 * 3. 다리 위에 올라가 있는 트럭들의 무게 합은 L보다 작거나 같아야 한다.
 * 
 * 구하고자 하는 것: 트럭이 다리를 건너는 최단 시간
 * @author SSAFY
 *
 */
public class Main_13335_김민주 {

	private static int n;
	private static int w;
	private static int L;
	private static Queue<Integer> bridgeQueue = new ArrayDeque<Integer>();
	private static Queue<Integer> inputQueue = new ArrayDeque<Integer>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		int cnt = 0;
		
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		
		// bridgeQueue를 길이만큼 0으로 채움
		for (int i = 0; i < w; i++) {
			bridgeQueue.offer(0);
		}
		
		// 트럭을 입력받아 inputQueue에 저장한다.
		// 입력을 받은 순서대로 빠져나가야 하기때문에 Queue를 사용
		for (int i = 0; i < n; i++) {
			inputQueue.offer(Integer.parseInt(st.nextToken()));
			
		}
		
		// bridgeQueue가 빌 때까지 반복
		while(!bridgeQueue.isEmpty()) {
			
			// 트럭이 있으면
			if(!inputQueue.isEmpty()) {
				
				// 우선 다리에서 마지막 요소를 빼주고 다리에 가해지는 무게를 빼줌
				// 마지막 요소가 0이될 수도 있고 트럭일 수도 있음
				sum-=bridgeQueue.poll();
				
				// 트럭을 추가했을 때 그 무게가 다리 하중을 넘기지 않을 경우
				if((sum + inputQueue.peek()) <= L) {
					
					// 다리에 가해지는 무게 증가
					sum += inputQueue.peek();
					// 트럭 추가
					bridgeQueue.offer(inputQueue.poll());
					cnt++;
				}
				
				// 다리 하중을 넘길 경우
				else {
					
					// 트럭을 추가하지 않고 0을 추가
					bridgeQueue.offer(0);
					cnt++;
				}
			}
			// 트럭이 없으면 
			else {
				
				// 0도 추가하지말고 제일 앞에 있는 요소 무게 빼줌
				sum-=bridgeQueue.poll();
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
