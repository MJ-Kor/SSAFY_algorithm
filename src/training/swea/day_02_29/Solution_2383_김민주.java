package training.swea.day_02_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_2383_김민주 {

	static class Person {
		int r, c;

		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static class Stair {
		int r, c, length;

		public Stair(int r, int c, int length) {
			super();
			this.r = r;
			this.c = c;
			this.length = length;
		}

	}

	private static int min;
	private static boolean[] check;
	private static int[][] map;
	private static int[][] distancePS;
	private static Stair[] slist;
	private static List<Person> plist;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int sIdx = 0;
			min = Integer.MAX_VALUE;
			plist = new ArrayList<>();
			slist = new Stair[2]; 
			map = new int[N][N];

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					int in = Integer.parseInt(st.nextToken());
					map[r][c] = in;
					if (in == 0)
						continue;
					if (in == 1)
						plist.add(new Person(r, c));
					else {
						slist[sIdx] = new Stair(r, c, in);
						sIdx += 1;
					}
				}
			}
			check = new boolean[plist.size()];
			distancePS = new int[2][plist.size()];
			personToStair();
			chooseStair(0, 0, 0);
			System.out.println("#" + test_case + " " + min);
		}
	}

	private static void personToStair() {
		for (int i = 0; i < plist.size(); i++) {
			Person p = plist.get(i);
			Stair s1 = slist[0];
			Stair s2 = slist[1];
			distancePS[0][i] = Math.abs(p.r - s1.r) + Math.abs(p.c - s1.c) + 1;
			distancePS[1][i] = Math.abs(p.r - s2.r) + Math.abs(p.c - s2.c) + 1;
		}
	}
	
	private static void chooseStair(int cnt, int s1Num, int s2Num) {
		if(cnt == plist.size()) {
			goLunch(s1Num, s2Num);
			return;
		}
		
		// true: s1, false: s2
		check[cnt] = true;
		chooseStair(cnt + 1, s1Num + 1, s2Num);
		check[cnt] = false;
		chooseStair(cnt + 1, s1Num, s2Num + 1);
		
	}

	private static void goLunch(int s1Num, int s2Num) {
		
		List<Integer> s1p = new ArrayList<>();
		List<Integer> s2p = new ArrayList<>();
		
		for (int i = 0; i < check.length; i++) {
			if(check[i] == true) s1p.add(distancePS[0][i]);
			else s2p.add(distancePS[1][i]);
		}
		
		int s1Time = dynamicPrograming(s1p, 0);
		int s2Time = dynamicPrograming(s2p, 1);
		
//		System.out.println(s1Time);
//		System.out.println(s2Time);
		
		int lmin = Math.max(s1Time, s2Time);
		
		if(min > lmin) min = lmin; 
		
	}

	private static int dynamicPrograming(List<Integer> sp, int stairIdx) {
		
		Stair s = slist[stairIdx];
		
		if(sp.size() == 0) {
			return 0;
		}
		Collections.sort(sp);
		if(sp.size() <= 3) {
			return sp.get(sp.size() - 1) + s.length;
		}
		int[] dp = new int[sp.size() + 1];
		dp[1] = sp.get(0) + s.length;
		dp[2] = sp.get(1) + s.length;
		dp[3] = sp.get(2) + s.length;
		for (int i = 4; i <= sp.size(); i++) {
			if(dp[i - 3] > sp.get(i - 1)) {
				dp[i] = dp[i - 3] + s.length;
			}
			else {
				dp[i] = sp.get(i - 1) + s.length;
			}
		}
		return dp[sp.size()];
	}
}
