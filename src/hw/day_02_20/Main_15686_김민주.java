package hw.day_02_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Home{
	int r, c;
	
	public Home(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class Chicken{
	int r, c;
	
	public Chicken(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main_15686_김민주 {

	private static int N, M, check;
	//private static int[][] map;
	private static List<Home> hList = new ArrayList<Home>();
	private static List<Chicken> cList = new ArrayList<Chicken>();
	private static Chicken[] chickens;
	private static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chickens = new Chicken[M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				check = Integer.parseInt(st.nextToken());
				// 집 위치 저장
				if(check == 1) hList.add(new Home(r, c));
				// 치킨집 위치 저장
				else if(check == 2) cList.add(new Chicken(r, c));

			}
		}
		
		combination(0, 0);
		System.out.println(result);
		
	}
	
	// 조합으로 M개의 치킨집 뽑기
	public static void combination(int cnt, int start) {
		if(cnt == M) {
			getDistance();
			return;
		}
		
		else {
			for (int i = start; i < cList.size(); i++) {
				chickens[cnt] = cList.get(i);
				combination(cnt + 1, i + 1);
			}
		}
	}
	
	public static void getDistance() {
		// 각 집들과 조합으로 뽑은 치킨집들 중 최소 거리
		int minDist = 0;
		
		// 각 집에 대해서 조합으로 고른 치킨집 중 가장 가까운 치킨집의 거리 구하기
		for (int homeIdx = 0; homeIdx < hList.size(); homeIdx++) {
			int min = Integer.MAX_VALUE;
			for (int chickenIdx = 0; chickenIdx < M; chickenIdx++) {
				min = Math.min(min, Math.abs(hList.get(homeIdx).r - chickens[chickenIdx].r) + 
							   Math.abs(hList.get(homeIdx).c - chickens[chickenIdx].c));
			}
			minDist += min;
		}
		
		result = Math.min(result, minDist);
		return;
	}

}
