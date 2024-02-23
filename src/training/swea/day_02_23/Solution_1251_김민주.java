package training.swea.day_02_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1251_김민주 {

	private static int T, N, R, C;
	private static long[] nodeR, nodeC;
	private static double E;
	private static long[][] adjMatrix;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			nodeR = new long[N];
			nodeC = new long[N];
			adjMatrix = new long[N][N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) nodeR[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) nodeC[i] = Integer.parseInt(st.nextToken());
			
			E = Double.parseDouble(br.readLine());
			
			for (int i = 0; i < N; i++) {
				for (int j = 0 ; j < N; j++) {
					if(i == j) continue;
					long length = ((nodeR[i] - nodeR[j]) * (nodeR[i] - nodeR[j])) + ((nodeC[i] - nodeC[j]) * (nodeC[i] - nodeC[j]));
					adjMatrix[i][j] = length;
				}
			}
			
			long minResult = prim();
			System.out.println("#" + test_case + " " + Math.round(minResult * E));
		}
		
	}
	
	public static long prim() {
		boolean[] visited = new boolean[N];
		long[] minEdge = new long[N];
		
		Arrays.fill(minEdge, Long.MAX_VALUE);
		minEdge[0] = 0;
		long result = 0;
		int c; 
		for (c = 0; c < N; c++) {
			long min = Long.MAX_VALUE;
			int minVertex = -1;
			for (int i = 0; i < N; i++) {
				if(!visited[i] && minEdge[i] < min) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			if(minVertex == -1) break;
			result += min;
			visited[minVertex] = true;
			
			for (int i = 0; i < N; i++) {
				if(!visited[i] && adjMatrix[minVertex][i] != 0 && adjMatrix[minVertex][i] < minEdge[i])
					minEdge[i] = adjMatrix[minVertex][i];
			}
		}
		return c == N ? result : -1;
	}

}
