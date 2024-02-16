package hw.day_02_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_김민주 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 도화지 크기
		boolean[][] paper = new boolean[101][101];
		int N = Integer.parseInt(st.nextToken());
		int sum = 0;
		
		// 색종이
		for (int c_paper = 0; c_paper < N; c_paper++) {
			st = new StringTokenizer(br.readLine());
			
			// 왼쪽 변과의 거리
			int s_row = Integer.parseInt(st.nextToken());
			
			// 오른쪽 변과의 거리
			int s_col = Integer.parseInt(st.nextToken());
			
			// 색종이 붙이기 false => true
			for (int row = s_row; row < s_row + 10; row++) {
				for (int col = s_col; col < s_col + 10; col++) {
					if (!paper[row][col]) {
						paper[row][col] = true;
						
						// 중복되지 않은 영역이면 더해줌
						sum += 1;
					}
				}
			}
		}
		System.out.println(sum);
	}

}