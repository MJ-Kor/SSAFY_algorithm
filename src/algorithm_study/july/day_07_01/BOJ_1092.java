package algorithm_study.july.day_07_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1092 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int crane_N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] crane = new int[crane_N];
		for (int i = 0; i < crane_N; i++) {
			crane[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(crane);
		
		int box_N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		List<Integer> box = new ArrayList<>();
		for (int i = 0; i < box_N; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(box);
		
		
		
		if(crane[crane_N - 1] < box.get(box_N - 1)) {
			System.out.println(-1);
		} else {
			int answer = 1;
			int box_idx = box_N - 1;
			int crane_idx = crane_N - 1;
			while(box.size() != 0) {
				
				if(crane_idx == -1 || box_idx == -1) {
					crane_idx = crane_N - 1;
					box_idx = box.size() - 1;
					answer++;
					continue;
				}
				
				if(crane[crane_idx] >= box.get(box_idx)) {
					crane_idx--;
					box.remove(box_idx);
					box_idx = box.size() - 1;
				} else {
					box_idx--;
				}
			}
			System.out.println(answer);
		}
	}
}
