package hw.day_02_15;

/**
 * *: 벽
 * #: 강철
 * -: 물
 * 벽에 포탄 쏘면 부서지고 평지화
 * 강철에 포탄 쏘면 아무일도 일어나지 않음
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_김민주 {

	private static int T, H, W, N;
	private static String str, input;
	private static int tankR, tankC, tankD;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static char[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			char ch;
			for (int r = 0; r < H; r++) {
				str = br.readLine();
				for (int c = 0; c < W; c++) {
					ch = str.charAt(c);
					map[r][c] = ch;
					if(ch == '^') {
						tankR = r;
						tankC = c;
						tankD = 0;
					} else if(ch == 'v') {
						tankR = r;
						tankC = c;
						tankD = 1;
					} else if(ch == '<') {
						tankR = r;
						tankC = c;
						tankD = 2;
					}else if(ch == '>') {
						tankR = r;
						tankC = c;
						tankD = 3;
					}
				}
			}
			
			N = Integer.parseInt(br.readLine());
			input = br.readLine();
			
			char inputCh;
			
			for (int i = 0; i < args.length; i++) {
				inputCh = input.charAt(i);
				switch(inputCh) {
					case 'U' :{
						Up();
						break;
					}
					case 'D' :{
						Down();
						break;
					}
					case 'L' :{
						Left();
						break;
					}
					case 'R' :{
						Right();
						break;
					}
					case 'S' :{
						Shoot();
						break;
					}
				}
			}
			
		}
		
	}

	
	public static void Up() {
		
	}
	public static void Down() {
			
	}
	public static void Left() {
		
	}
	public static void Right() {
		
	}
	public static void Shoot() {
		int bulletR = tankR;
		int bulletC = tankC;
		
		while(true) {
			bulletR = bulletR + dr[tankD];
			bulletC = bulletC + dc[tankD];
			
			if(bulletR >= 0 && bulletR < H && bulletC >= 0 && bulletC < W) {
				if(map[bulletR][bulletC] == '#') {
					break;
				}else if(map[bulletR][bulletC] == '*') {
					map[bulletR][bulletC] = '.';
					break;
				}
			}
			else {
				break;
			}
		}
		
	}
	
}
