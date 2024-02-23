package training.boj.day_02_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_17281_김민주 {
	private static int playersNum = 9;
	private static int N;
	private static int[] players;
	private static int[][] inningResult;
	private static int tot = Integer.MIN_VALUE;
	private static int inningScore = 0;
	private static boolean[] visited;
	private static int order = 0;
	private static int[] checkScore = {8, 16, 32, 64};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		players = new int[playersNum];
		players[3] = 0;
		inningResult = new int[N][playersNum];
		visited =new boolean[playersNum];
		visited[0] = true;
		for (int i = 0; i < N; i++) {
			inningResult[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		perm(0);
		System.out.println(tot);
	}

	private static void perm(int cnt) {
		if(cnt == playersNum) {
			for (int i = 0; i < N; i++) {
				inningScore += playBaseball(i);				
			}
			if(inningScore > tot) tot = inningScore;
			inningScore = 0;
			order = 0;
			return;
		}
		for (int i = 0; i < playersNum; i++) {		
				if(visited[i]) continue;
				visited[i] = true;
				players[cnt] = i;
				// 미리 들어가 있는 4번 타자 자리는 재귀를 실행하지 않는다.
				// 9! -> 8!으로 줄어듦
				if(cnt == 2) perm(cnt + 2);
				else perm(cnt + 1);
				visited[i] = false;
				players[cnt] = 0;
		}
	}

	private static int playBaseball(int inning) {
		int scoreSum = 0;
		int base = 0;
		int outCnt = 0;
		while(outCnt != 3) {
			int hit = inningResult[inning][players[order]];
			if(hit == 0) outCnt++;
			else {
				int[] info = moveBase(base, hit);
				base = info[0];
				scoreSum += info[1];
			}
			order = (order + 1) % 9;
		}
		return scoreSum;
	}
	
	private static int[] moveBase(int base, int hit) {
		int initNum = 0;
		base = base << hit;
		base = base | (1 << (hit - 1));
		int score = 0;
		for (int check : checkScore) {
			if((base & check) == check) {
				initNum += check;
				score++;
			}
		}
		return new int[] {base - initNum, score}; 
	}
}
