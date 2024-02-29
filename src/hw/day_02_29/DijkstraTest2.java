package hw.day_02_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest2 {

	private static int min = Integer.MAX_VALUE;
	private static int N; 
	private static int[][] adjMatrix;
	private static int[] numbers = new int[2];
	private static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		adjMatrix = new int[N][N];
		visited = new boolean[N];
		for (int r = 0; r < N; r++) {
			adjMatrix[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		perm(0);
		System.out.println(min);
	}

	private static void perm(int cnt) {
		if(cnt == 2) {
			int minValue = dijkstra(numbers[0], numbers[1]);
			min = Math.min(min, minValue);
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			numbers[cnt] = i;
			perm(cnt + 1);
			visited[i] = false;
		}
	}

	private static int dijkstra(int start, int end) {
		final int INF = Integer.MAX_VALUE;
		int[] minDistance = new int[N];
		boolean[] visited = new boolean[N];
		Arrays.fill(minDistance, INF);
		
		minDistance[start] = 0;
		
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(minDistance));
			int min = INF;
			int stopOver = -1;
			
			for (int j = 0; j < minDistance.length; j++) {
				if(!visited[j] && min > minDistance[j]) {
					min = minDistance[j];
					stopOver = j;
				}
			}
			
			if(stopOver == -1) {
				break;
			}
			
			visited[stopOver] = true;
			
			for (int j = 0; j < N; j++) {
				if(adjMatrix[stopOver][j] != 0 && minDistance[j] > minDistance[stopOver] + adjMatrix[stopOver][j]) {
					minDistance[j] = minDistance[stopOver] + adjMatrix[stopOver][j];
				}
			}
		}
		
		return minDistance[end];
	}
	
	

}
