package training.swea.day_02_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1233_김민주 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = 10;
		int N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			int valid = 1;
			for (int j = 0; j < N; j++) {
				String[] nodeInfo = br.readLine().split(" ");
				if(Character.isDigit(nodeInfo[1].charAt(0))) {
					if(nodeInfo.length > 2) {
						valid = 0;
					}
				}
				else {
					if(nodeInfo.length != 4) {
						valid = 0;
					}
				}
			}
			
			System.out.print("#" + i + " " + valid);
			System.out.println();
		
		}

	}
}
