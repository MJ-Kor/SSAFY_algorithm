package hw.day_02_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228_김민주 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		int N, numCommand, startLoc, insertNum;
		
		// TestCase
		for (int i = 1; i <= T; i++) {
			
			// LinkedList 생성
			LinkedList<Integer> ll = new LinkedList<Integer>();
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			// LinkedList에 N개 만큼의 요소 추가
			for (int j = 0; j < N; j++) {
				ll.add(Integer.parseInt(st.nextToken()));
			}
			
			// 명령어 개수
			numCommand = Integer.parseInt(br.readLine());
			
			// 명령어 받기
			st = new StringTokenizer(br.readLine());
			
			// 명령어 개수만큼 반복
			for (int j = 0; j < numCommand; j++) {
				
				// I 무시
				st.nextToken();
				
				// 시작위치
				startLoc = Integer.parseInt(st.nextToken());
				
				// 삽입 요소 수
				insertNum = Integer.parseInt(st.nextToken());
				
				// 요소 삽입
				for (int k = startLoc; k < startLoc + insertNum; k++) {
					ll.add(k, Integer.parseInt(st.nextToken()));
				}
			}
			
			// 10개 출력
			System.out.print("#" + i + " ");
			for (int j = 0; j < 10; j++) {
				System.out.print(ll.get(j) + " ");
			}
			System.out.println();
		}
	}

}
