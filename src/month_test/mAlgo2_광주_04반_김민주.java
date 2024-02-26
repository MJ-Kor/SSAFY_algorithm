package month_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class mAlgo2_광주_04반_김민주 {

	static int score = 0;
	static int N, A, T;
	static Stack<int[]> workProcess = new Stack<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int isWork = Integer.parseInt(st.nextToken());
			if(isWork == 1) {
				A = Integer.parseInt(st.nextToken());
				T = Integer.parseInt(st.nextToken());
				workProcess.add(new int[] {A, T});
				int[] newest = workProcess.pop();
				if(newest[1] - 1 == 0) {
					score += newest[0];
				}
				else {
					newest[1] -= 1;
					workProcess.add(newest);
				}
				
			}else {
				int[] newest = workProcess.pop();
				if(newest[1] - 1 == 0) {
					score += newest[0];
				}
				else {
					newest[1] -= 1;
					workProcess.add(newest);
				}
			}
		}
		
		System.out.println(score);
	}

}
