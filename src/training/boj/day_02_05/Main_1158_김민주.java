package training.boj.day_02_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1158_김민주 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Boolean> l1 = new ArrayList<Boolean>();
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			l1.add(false);
		}
		
		int count = 0;
		int idx = 0;
		
		while(true) {
			if(l1.get(idx) == false) {
				count = count + 1;
				if(count == K) {
					result.add(idx + 1);
					if (result.size() == N) {
						break;
					}
					l1.set(idx, true);
					count = 0;
				}
			}
			idx = (idx + 1) % N;
		}
		
		System.out.print("<");
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
			if(i!=result.size()-1) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
	}

}
