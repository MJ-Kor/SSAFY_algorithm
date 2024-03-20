package algorithm_study.day_03_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_21608 {

	static class Student{
		int num;
		int[] fs;

		public Student(int num, int[] fs) {
			super();
			this.num = num;
			this.fs = fs;
		}

		@Override
		public String toString() {
			return "Point [num=" + num + ", fs=" + Arrays.toString(fs) + "]";
		}

	}
	
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
	}
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	private static Student[] students;
	private static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		students = new Student[N*N];
		
		for (int i = 0; i < N*N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int[] fs = new int[4];
			for (int j = 0; j < 4; j++) {
				fs[j] = Integer.parseInt(st.nextToken());
			}
			students[i] = new Student(num, fs);
		}
		
		for (int i = 0; i < N*N; i++) {
			
		}
	}

}
