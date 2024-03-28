package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11780_김민주_해결x {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = null;
	private static int INF = 100_000 * 100;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		int[][] dist = new int[V][V];
		List<Integer>[] arr = new ArrayList[V*V];
		int INF = 100_000 * 100;
		
		init(dist, V, E, arr);
		FWA(dist, V, arr);
		Print(dist, V, arr);
	}

	private static void Print(int[][] dist, int V, List<Integer>[] arr) {
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if(dist[i][j] == INF) {
					System.out.print(0 + " ");					
				} else {
					System.out.print(dist[i][j] + " ");
				}
			}
			System.out.println();
		}
		
		for (int i = 0; i < V * V; i++) {
			
			if(arr[i].size() == 1) {
				System.out.print(0);
			} else {				
				System.out.print(arr[i].size() + " ");
				for(int e : arr[i]) {
					System.out.print((e + 1) + " ");
				}
			}
			System.out.println();
		}
	}

	private static void FWA(int[][] dist, int V, List<Integer>[] arr) {
		for (int k = 0; k < V; k++) { 
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					if(dist[i][j] >= dist[k][j] + dist[i][k]) {
						trackingRoute(arr, i, j, k , V);
						arr[(i * V + j)].add(k);
						dist[i][j] = dist[k][j] + dist[i][k];
					}
				}
			}
		}
	}

	private static void trackingRoute(List<Integer>[] arr, int i, int j, int k, int V) {
			arr[(i * V + j)].clear();
	}

	private static void init(int[][] dist, int V, int E, List<Integer>[] arr) throws IOException {
		
		for (int i = 0; i < V * V; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if(i == j) {
					dist[i][j] = 0;
					continue;
				}
				dist[i][j] = INF;
			}
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			dist[start][end] = Math.min(dist[start][end], weight);
		}
	}

}
