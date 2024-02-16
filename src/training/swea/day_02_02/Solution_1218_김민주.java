package training.swea.day_02_02;

/**
 * Stack을 이용한 괄호 판별기
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218_김민주 {

	private static int T = 10;
	private static String str;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack; 
		int status = 1;
		int num;
		char check;
		
		// TestCase
		for (int test_case = 1; test_case <= T; test_case++) {
			num = Integer.parseInt(br.readLine());
			str = br.readLine();
			stack = new Stack<Character>();
			
			// 시작
			for (int i = 0; i < num; i++) {
				
				// 해당 문자열이
				check = str.charAt(i);
				
				// 여는 괄호면 스택에 삽입
				if(check == '(' || check == '{' || check == '[' || check == '<') {
					stack.push(check);
				}
				
				// 그게 아니라면 스택의 가장 위에 있는 괄호와 짝이 맞는지 확인
				// 짝이 맞으면 유효해서 통과
				// 짝이 맞지 않으면 유효하지 않아서 for문 빠져나오기
				else if(check == ')'){
					if(stack.pop() != '(') {
						status = 0;
						break;
					}
				}
				else if(check == '}'){
					if(stack.pop() != '{') {
						status = 0;
						break;
					}
				}
				else if(check == ']'){
					if(stack.pop() != '[') {
						status = 0;
						break;
					}
				}
				else if(check == '>'){
					if(stack.pop() != '<') {
						status = 0;
						break;
					}
				}
			}
			
			// 스택이 비지 않으면 유효하지 않다
			if(!stack.isEmpty()) {
				status = 0;
			}
			System.out.println("#" + test_case + " " + status);
			status = 1;
		}
	}

}
