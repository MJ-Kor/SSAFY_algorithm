package classes;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueAPITest {

	public static void main(String[] args) {
		
		Queue<String> Queue = new ArrayDeque<String>();
		System.out.println(Queue.isEmpty() + "//" + Queue.size());
		Queue.offer("김싸피");
		Queue.offer("나싸피");
		Queue.offer("박싸피");
		Queue.offer("이싸피");
		System.out.println(Queue.isEmpty() + "//" + Queue.size());
		
		System.out.println(Queue.peek());
		System.out.println(Queue.isEmpty() + "//" + Queue.size());
		System.out.println(Queue.poll());
		System.out.println(Queue.isEmpty() + "//" + Queue.size());
		System.out.println("=========================================");
		while(!Queue.isEmpty()) {
			System.out.println(Queue.poll());
		}
	}

}
