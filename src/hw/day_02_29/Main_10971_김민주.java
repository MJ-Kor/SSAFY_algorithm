package hw.day_02_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10971_김민주 {

	private static int min = Integer.MAX_VALUE;
	private static int N; 
	private static int[][] adjMatrix;
	private static int[] numbers;
	private static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adjMatrix = new int[N][N];
		visited = new boolean[N];
		numbers= new int[N + 1];
		for (int r = 0; r < N; r++) {
			adjMatrix[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		perm(0);
		System.out.println(min);
	}
	
	// 순열로 정점을 지나는 모든 순서를 탐색
	private static void perm(int cnt) {
		if(cnt == N) {
			// 돌아와야 하므로 마지막 정점을 첫번째 정점과 같게 해줌
			numbers[N] = numbers[0];
			int value = getValue();
			if(value != -1) {
				min = Math.min(min, value);
			}
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

	// 최소 비용 구하기
	private static int getValue() {
		int value = 0;
		
		for (int i = 0; i < N; i++) {
			int weight = adjMatrix[numbers[i]][numbers[i + 1]];
			// 만약 i와 i + 1사이에 경로가 없다면 비용구하는걸 그만 둠
			if(weight == 0) {
				return -1;
			}
			value += weight;
		}
		return value;
	}
}

