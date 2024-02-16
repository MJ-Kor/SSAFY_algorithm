package training.boj.day_02_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2493_김민주_deque_메모리초과 {

	private static Deque<Integer> deq = new ArrayDeque<Integer>();
	
	private static int check(int num) {	
		int answer = 0;
		int tmp = 0;
		for (int i = 0; i < deq.size(); i++) {
			if(answer != 0) {
				tmp = deq.removeLast();
				deq.addFirst(tmp);
			}
			else {
				tmp = deq.removeLast();
				if (tmp > num) {
					answer = deq.size()-i+1;
				}
				deq.addFirst(tmp);
			}
		}
		deq.addLast(num);
		return answer;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num;
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            sb.append(check(num)).append(" ");
        }
        
        System.out.println(sb.toString());
	}

}
