package weekly_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Algo2_광주_04반_김민주 {

	static class Project implements Comparable<Project>{
		int startMonth, startDay, endMonth, endDay;

		public Project(int startMonth, int startDay, int endMonth, int endDay) {
			super();
			this.startMonth = startMonth;
			this.startDay = startDay;
			this.endMonth = endMonth;
			this.endDay = endDay;
		}

		@Override
		public int compareTo(Project o) {
			if(this.startMonth == o.startMonth) {
				if(this.startMonth == o.startMonth && this.startDay == o.startDay) {
					if(this.startMonth == o.startMonth && this.startDay == o.startDay && this.endMonth == o.endMonth) {
						return -1 * Integer.compare(this.endDay, o.endDay);
					}
					else {
						return -1 * Integer.compare(this.endMonth, o.endMonth);
					}	
				}
				else {
					return Integer.compare(this.startDay, o.startDay);
				}
			}
			else {
				return Integer.compare(this.startMonth, o.startMonth);				
			}
		}

		@Override
		public String toString() {
			return "Project [startMonth=" + startMonth + ", startDay=" + startDay + ", endMonth=" + endMonth
					+ ", endDay=" + endDay + "]";
		}
		
	}
	
	static int N;
	static Project[] projects;	
	static List<Project> answer = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		projects = new Project[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int startMonth = Integer.parseInt(st.nextToken());
			int startDay = Integer.parseInt(st.nextToken());
			int endMonth = Integer.parseInt(st.nextToken());
			int endDay = Integer.parseInt(st.nextToken());
			projects[i] = new Project(startMonth, startDay, endMonth, endDay);
		}
		
		Arrays.sort(projects);
		
		for (int i = 0; i < N; i++) {
			System.out.println(projects[i]);
		}
		
		if(projects[0].startMonth >= 3 && projects[0].startDay > 1)
			System.out.println(0);
		else {
			answer.add(projects[0]);
			int Idx = 1;
			while(Idx < projects.length) {
				int tM = answer.get(answer.size() - 1).endMonth;
				int tD = answer.get(answer.size() - 1).endDay;
				for (int i = Idx; i < projects.length; i++) {
					if(projects[i].startMonth < tM) {
						Idx = i;
					}
					else if(projects[i].startMonth == tM) {
						if(projects[i].startDay <= tD) {
							Idx = i;
						}
					}
				}
				answer.add(projects[Idx]);
			}
		}
		
		System.out.println(answer.size());
		
	}

}
