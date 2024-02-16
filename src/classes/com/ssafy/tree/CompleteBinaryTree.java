package classes.com.ssafy.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CompleteBinaryTree<T> {

	private Object[] nodes;
	private final int SIZE;
	private int lastIndex;
	
	public CompleteBinaryTree(int size) {
		SIZE = size;
		nodes = new Object[size+1]; // 0 인덱스 사용하지 않음
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(T e){
		if(isFull()) {
			System.out.println("포화상태입니다.");
			return;
		}
		nodes[++lastIndex] =e;
	}

	public void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(nodes[current]);
			
			//왼쪽 자식 노드
			if(current * 2 <= lastIndex) queue.offer(current*2);
			
			//오른쪽 자식 노드
			if(current * 2+1 <= lastIndex) queue.offer(current*2+1);
		}
	}
	
	public void dfsByPreorder() {
		if(isEmpty()) return;
		System.out.println("===preorder===");
		dfsByPreorder(1);
		System.out.println();
			
	}
	
	private void dfsByPreorder(int current) {
		
		System.out.print(nodes[current] + " ");
		
		//왼쪽 자식 노드
		if(current * 2 <= lastIndex) dfsByPreorder(current*2);
		
		//오른쪽 자식 노드
		if(current * 2+1 <= lastIndex) dfsByPreorder(current*2+1);
		
	}

	public void dfsByInorder() {
		if(isEmpty()) return;
		System.out.println("===preorder===");
		dfsByInorder(1);
		System.out.println();
			
	}
	
	private void dfsByInorder(int current) {
		
		//왼쪽 자식 노드
		if(current * 2 <= lastIndex) dfsByInorder(current*2);
		System.out.print(nodes[current] + " ");
		//오른쪽 자식 노드
		if(current * 2+1 <= lastIndex) dfsByInorder(current*2+1);
		
	}

	public void dfsByPostorder() {
		if(isEmpty()) return;
		System.out.println("===preorder===");
		dfsByPostorder(1);
		System.out.println();
			
	}
	
	private void dfsByPostorder(int current) {
		
		//왼쪽 자식 노드
		if(current * 2 <= lastIndex) dfsByPostorder(current*2);
		
		//오른쪽 자식 노드
		if(current * 2+1 <= lastIndex) dfsByPostorder(current*2+1);
		System.out.print(nodes[current] + " ");
	}
	
}
