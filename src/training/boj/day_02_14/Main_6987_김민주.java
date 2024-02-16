package training.boj.day_02_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6987_김민주 {

	private static int totalGame = 15;
	private static int teamNum = 6;
	private static int gameCase = 3;
	private static int[] team1 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
	private static int[] team2 = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
	private static int[][] groupStage = new int[teamNum][gameCase];
	private static int tc = 4;
	private static int flag = 0;
	private static int sum = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int test_case = 0; test_case < tc; test_case++) {
			sum = 0;
			flag = 0;
			st = new StringTokenizer(br.readLine());
			for (int team = 0; team < teamNum; team++) {
				for (int gameResult = 0; gameResult < gameCase; gameResult++) {
					groupStage[team][gameResult] = Integer.parseInt(st.nextToken());
					sum += groupStage[team][gameResult];
				}
			}
			
			if(sum == 30) {
				worldCup(0);				
			}
			System.out.print(flag + " ");
		}
	}
		
	public static void worldCup(int cnt) {
		if(cnt == totalGame) {
			flag = 1;
			return;
		}
		
		if(groupStage[team1[cnt]][0] - 1 >= 0 && groupStage[team2[cnt]][2] - 1 >= 0) {			
			groupStage[team1[cnt]][0]--;
			groupStage[team2[cnt]][2]--;
			worldCup(cnt + 1);
			groupStage[team1[cnt]][0]++;
			groupStage[team2[cnt]][2]++;
		} 

		if(groupStage[team1[cnt]][1] - 1 >= 0 && groupStage[team2[cnt]][1] - 1 >= 0) {			
			groupStage[team1[cnt]][1]--;
			groupStage[team2[cnt]][1]--;
			worldCup(cnt + 1);
			groupStage[team1[cnt]][1]++;
			groupStage[team2[cnt]][1]++;
		} 

		if(groupStage[team1[cnt]][2] - 1 >= 0 && groupStage[team2[cnt]][0] - 1 >= 0) {			
			groupStage[team1[cnt]][2]--;
			groupStage[team2[cnt]][0]--;
			worldCup(cnt + 1);
			groupStage[team1[cnt]][2]++;
			groupStage[team2[cnt]][0]++;
		} 
	}
}
