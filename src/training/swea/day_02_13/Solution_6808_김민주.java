package training.swea.day_02_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 얻음
 */
public class Solution_6808_김민주 {

	private static int T, check;
	private static int cardNum = 18;
	private static int winCount = 0;
	private static int loseCount = 0;
	private static int[] numbers = new int[cardNum/2];
	private static List<Integer> gyuyoung = new ArrayList<Integer>();
	private static List<Integer> inyoung = new ArrayList<Integer>();
	private static boolean[] cardNums;
	private static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			winCount = 0;
			loseCount = 0;
			isSelected = new boolean[cardNum/2];
			cardNums = new boolean[cardNum + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < (cardNum/2); i++) {
				check = Integer.parseInt(st.nextToken());
				cardNums[check] = true;
				gyuyoung.add(check);
			}
			
			for (int i = 1; i <= cardNum ; i++) {
				if(cardNums[i] == false) {
					inyoung.add(i);
				}
			}
			
			permutation(0);
			System.out.println("#" + test_case + " " + winCount + " " + loseCount);
			
			gyuyoung.clear();
			inyoung.clear();
		}
		
	}
	
	public static void permutation(int cnt) {
		
		if(cnt == cardNum/2) {
			int gyuScore = 0;
			int inScore = 0;
			for (int i = 0; i < (cardNum/2); i++) {
				if(gyuyoung.get(i) > numbers[i]) {
					gyuScore += (gyuyoung.get(i) + numbers[i]);
				}
				else if(gyuyoung.get(i) < numbers[i]) {
					inScore += (gyuyoung.get(i) + numbers[i]);
				}
			}
			if(gyuScore > inScore) {
				winCount++;
			}
			else if(gyuScore < inScore) {
				loseCount++;
			}
			
			return;
			
		}
		
		for (int i = 0; i < (cardNum/2); i++) {
			if(isSelected[i] == true) continue;
			numbers[cnt] = inyoung.get(i);
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}

}
