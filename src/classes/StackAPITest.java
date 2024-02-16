package classes;

import java.util.Stack;

public class StackAPITest {

	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		System.out.println(stack.isEmpty() + "//" + stack.size());
		stack.push("김싸피");
		stack.push("나싸피");
		stack.push("박싸피");
		stack.push("이싸피");
		System.out.println(stack.isEmpty() + "//" + stack.size());
		
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty() + "//" + stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty() + "//" + stack.size());
		System.out.println("=========================================");
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		stack.pop();
	}

}
