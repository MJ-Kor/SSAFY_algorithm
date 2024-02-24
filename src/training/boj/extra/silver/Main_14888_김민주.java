package training.boj.extra.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// +, -, x, /
public class Main_14888_김민주 {

	private static int N;
	private static int[] sequence;
	private static int[] operationNum = new int[4];
	private static int[] operations;
	private static int[] numbers;
	private static boolean[] visited;
	private static int min = Integer.MAX_VALUE;
	private static int max = Integer.MIN_VALUE;
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		sequence = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			operationNum[i] = Integer.parseInt(st.nextToken());
			sum += operationNum[i];
		}
		
		operations = new int[sum];
		numbers = new int[sum];
		visited = new boolean[sum];
		Arrays.fill(numbers, -1);
		
		for (int i = 0; i < sum; i++) {
			for (int j = 0; j < 4; j++) {
				if(operationNum[j] != 0) {
					operations[i] = j;
					operationNum[j]--;
					break;
				}
			}
		}
		
//		System.out.println(Arrays.toString(operations));
		
		perm(0);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void perm(int cnt) {
		if(cnt == N - 1) {
//			System.out.println(Arrays.toString(numbers));
			calculation();
			return;
		}
		for (int i = 0; i < N - 1; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			numbers[cnt] = operations[i];
			perm(cnt + 1);
			numbers[cnt] = -1;
			visited[i] = false;
		}
	}

	private static void calculation() {
		int operationIdx = 0;
		int result = sequence[0];
		for (int i = 1; i < sequence.length; i++) {
			if(numbers[operationIdx] == 0) {
				result += sequence[i]; 
			} else if(numbers[operationIdx] == 1) {
				result -= sequence[i];
			} else if(numbers[operationIdx] == 2) {
				result *= sequence[i];
			} else if(numbers[operationIdx] == 3) {
				if(result < 0) {
					result = -1*((-1 * result) / sequence[i]);
				}
				else {
					result /= sequence[i];
				}
			}
			++operationIdx;
		}
		
		if(result > max) {
			max = result;
		}
		
		if(result < min) {
			min = result;
		}
	}
	
	
	

}
