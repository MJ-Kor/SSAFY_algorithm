package algorithm_study.day_04_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1946 {
	
	private static class Grade implements Comparable<Grade>{
		int paper, interview;

		public Grade(int paper, int interview) {
			super();
			this.paper = paper;
			this.interview = interview;
		}
		@Override
		public String toString() {
			return "Grade [paper=" + paper + ", interview=" + interview + "]";
		}
		@Override
		public int compareTo(Grade o) {
			return o.paper - this.paper;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			
			Grade[] grades = new Grade[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				grades[i] = new Grade(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(grades);
			
			for (int i = 0; i < N - 1; i++) {
				if(grades[i].interview > grades[i + 1].interview) { 
					for (int j = i + 1; j >= 0; j--) {
						if(grades[j].interview > grades[i + 1].interview) {
							cnt--;
						}
					}
				}
				cnt++;
			}
			
			System.out.println(cnt + 1);
		}
	}
}
