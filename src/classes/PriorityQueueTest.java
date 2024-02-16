package classes;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		
		//역순
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		//사용자 정의 
//		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		});
		
		pq.offer(5);
		pq.offer(1);
		pq.offer(6);
		pq.offer(7);
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		
		// 기본적으로 오름차순으로 정렬되므로 1, 5, 6, 7 순으로 정렬
	}

}
