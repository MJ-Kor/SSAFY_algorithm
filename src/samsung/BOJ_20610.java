package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

class Cloud {
	
	int r, c;
	
	public Cloud(int r, int c) {
		this.r = r;
		this.c = c;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Cloud [r=" + r + ", c=" + c + "]";
	}
	
}

public class BOJ_20610 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;
	static int N, M;
	static int answer;
	static int[][] arr;
	static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int[] diagonal = {2, 4, 6, 8};
	static int[][] isCloud;
	static List<Cloud> clouds = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		init();
		answer = solution();
		System.out.println(answer);
		
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		answer = 0;

		arr = new int[N][N];
		isCloud = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		clouds.add(new Cloud(N - 1, 0));
		clouds.add(new Cloud(N - 1, 1));
		clouds.add(new Cloud(N - 2, 0));
		clouds.add(new Cloud(N - 2, 1));
	}
	
	public static int solution() throws IOException {
		
		int d = 0, s = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			
			movingClouds(d, s);
			raining();
			copyingWater(i);
			refreshingClouds(i);
			
		}
		
		int answer = getTotalWater();
		
		return answer;
	}
	
	// 0, 1, 2, 3, ..., N
	public static void movingClouds(int d, int s) {
		
		int sdr = (s * dr[d]) % N;
		int sdc = (s * dc[d]) % N;
		
		if(sdr < 0) {
			sdr = N + sdr;
		}
		
		if(sdc < 0) {
			sdc = N + sdc;
		}
		
		for (Cloud cloud : clouds) {
			
			int nr = cloud.getR() + sdr;
			int nc = cloud.getC() + sdc;
			
			nr = nr % N;
			nc = nc % N;
			
			cloud.setR(nr);
			cloud.setC(nc);
		}
	}
	
	public static void raining() {
		for (Cloud cloud : clouds) {
			arr[cloud.getR()][cloud.getC()]++;
		}
	}
	
	public static void copyingWater(int m) {
		for (Cloud cloud : clouds) {
			
			int isWater = 0;
			
			int cr = cloud.getR();
			int cc = cloud.getC();
			
			for(int dir : diagonal) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				
				if(checkValid(nr, nc) && arr[nr][nc] > 0) {
					isWater++;
				}
			}
			
			arr[cr][cc] += isWater;
			isCloud[cr][cc] = m + 1;
		}
		clouds.clear();
	}
	
	public static void refreshingClouds(int m) {
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {				
				if(arr[r][c] >= 2 && isCloud[r][c] != m + 1) {
					clouds.add(new Cloud(r, c));
					arr[r][c] -= 2;
				}
			}
		}
	}
	
	public static int getTotalWater() {
		
		int water = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {				
				water += arr[r][c];
			}
		}
		return water;
	}
	
	public static boolean checkValid(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc <N) {
			return true;
		}
		
		return false;
	}

}
