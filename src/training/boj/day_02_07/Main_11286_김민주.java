package training.boj.day_02_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11286_김민주 {
		
	private static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
		
		// 다중 조건 정렬 comparator
		@Override
		public int compare(Integer o1, Integer o2) {
			if(Math.abs(o1) == Math.abs(o2)) {
				return o1.compareTo(o2);
			}
			return Math.abs(o1) - Math.abs(o2);
		}
	});
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int input;
		for (int i = 0; i < N; i++) {
			input = Integer.parseInt(br.readLine());
			if(input != 0) {
				pq.add(input);
			}
			else {
				if(pq.isEmpty()) {
					System.out.println(0);
				}
				else {
					System.out.println(pq.poll());
				}
			}
		}
	}
}
