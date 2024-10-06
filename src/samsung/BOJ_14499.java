package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499 {

	static int DICE_NUM = 6;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, x, y, K;
	static int[] dx = {-2, 0, 0, -1, 1};
	static int[] dy = {-2 ,1, -1, 0, 0};
	static int[] diceValue = {0, 0, 0, 0, 0, 0, 0}; // x, 동, 서, 북, 남, 위, 아래
	static int[][] map;
	static int[][] rolls = {
			{},
			{1, 6, 2, 5, 1},
			{2, 6, 1, 5, 2},
			{3, 6, 4, 5, 3},
			{4, 6, 3, 5, 4}
	};
	
	public static void main(String[] args) throws IOException {
		
		init();
		solution();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < M; y++) {
				map[x][y] = Integer.parseInt(st.nextToken());
			}
		}			
	}

	private static void solution() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		
		for (int k = 0; k < K; k++) {
			int d = Integer.parseInt(st.nextToken());
			if(isValidCommand(d)) {
				moveDice(d);
				System.out.println(diceValue[5]);
			}
		}
	}

	private static void moveDice(int d) {
		
		int[] commandRoll = rolls[d];
		
		int save = diceValue[commandRoll[0]];
		for (int curr = 0; curr < commandRoll.length; curr++) {
			int nextIdx = commandRoll[curr];
			int temp = diceValue[nextIdx];
			diceValue[nextIdx] = save;
			save = temp;
		}
		x += dx[d];
		y += dy[d];
		
		if(map[x][y] == 0) {
			map[x][y] = diceValue[6];
		} else {
			diceValue[6] = map[x][y];
			map[x][y] = 0;
		}
	}

	private static boolean isValidCommand(int d) {
		
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		if(nx >= 0 && nx < N && ny >= 0 && ny < M ) {
			return true;
		}
		
		return false;
	}
	
}
