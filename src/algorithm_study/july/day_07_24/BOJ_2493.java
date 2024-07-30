package algorithm_study.july.day_07_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Element{
	public int index;
	public int height;

	public Element(int index, int height) {
		this.index = index;
		this.height = height;
	}
}

public class BOJ_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Element> stack = new Stack<Element>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Element[] arr = new Element[N];
		int[] result = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Element(i, Integer.parseInt(st.nextToken()));
		}
		int idx = N-2;
		stack.push(arr[N-1]);
		while(idx >= 0) {
			if(!stack.isEmpty()) {
				if(stack.peek().height < arr[idx].height) {
					result[stack.pop().index] = arr[idx].index + 1;
				}
				else {
					stack.push(arr[idx]);
					idx--;
				}
			}
			else {
				stack.push(arr[idx]);
				idx--;
			}
		}

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}