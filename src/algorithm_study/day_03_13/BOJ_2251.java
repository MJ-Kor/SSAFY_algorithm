package algorithm_study.day_03_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2251 {

	private static boolean[][][] visited;
	private static PriorityQueue<Integer> pq = new PriorityQueue<>();
	private static int A, B, C, a, b, c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		visited = new boolean[A + 1][B + 1][C + 1];
		
		a = 0;
		b = 0;
		c = C;
		
		dfs(c, b, 0);
		dfs(c, b, 1);
		dfs(c, a, 0);
		dfs(c, a, 1);
	}

	private static void dfs(int start, int end, int status) {
		
		if(status == 0) {
			
		}
		
		// start -> end1로 옮기는 경우 (start > end1)
		dfs(a, B, C - B);
		// start -> end1로 옮기는 경우 (start <= end1)
		dfs(a, C, 0);
		// start -> end2로 옮기는 경우 (start > 
	}
}
