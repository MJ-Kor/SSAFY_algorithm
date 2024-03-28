package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11404_김민주 {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = null;
	private static int INF = 100_000 * 100;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		int[][] dist = new int[V][V];
		int INF = 100_000 * 100;
		
		init(dist, V, E);
		FWA(dist, V);
		Print(dist, V);
	}

	private static void Print(int[][] dist, int V) {
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
	}

	private static void FWA(int[][] dist, int V) {
		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[k][j] + dist[i][k]);
				}
			}
		}
	}

	private static void init(int[][] dist, int V, int E) throws IOException {
		
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
