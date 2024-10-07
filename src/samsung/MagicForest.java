package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


class Golem {
	int spiritR, spiritC, exit, num;

	public Golem(int spiritR, int spiritC, int exit, int num) {
		super();
		this.spiritR = spiritR;
		this.spiritC = spiritC;
		this.exit = exit;
		this.num = num;
	}

	public int getSpiritR() {
		return spiritR;
	}

	public void setSpiritR(int spiritR) {
		this.spiritR = spiritR;
	}

	public int getSpiritC() {
		return spiritC;
	}

	public void setSpiritC(int spiritC) {
		this.spiritC = spiritC;
	}

	public int getExit() {
		return exit;
	}

	public void setExit(int exit) {
		this.exit = exit;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Golem [spiritR=" + spiritR + ", spiritC=" + spiritC + ", exit=" + exit + ", num=" + num + "]";
	}
	
}

class Spirit {
	int r, c;

	public Spirit(int r, int c) {
		super();
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
		return "Spirit [r=" + r + ", c=" + c + "]";
	}
	
}

public class MagicForest {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C, K, c, d, answer = 0;
	static int north = 0, east = 1, south = 2, west = 3;
	static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
	static int[] dc = {0, 1, 0, -1};
	static int[][] forest; // 행, 열, 출구(0, 1)
	static boolean[][] isExit;
	static boolean[][] visited;
//	static int[][] visited; 

	public static void main(String[] args) throws IOException {
		
		init();
		solution();
		
		System.out.println(answer);
	}

	private static void init() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		forest = new int[R + 3][C];//[2];
		isExit = new boolean[R + 3][C];
		
	}
	
	private static void solution() throws IOException {
		
		for (int k = 1; k <= K; k++) {
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			Golem golem = new Golem(1, c - 1, d, k);
			
			movingGolem(golem);
			
			printMaps();
			
			if(golem.getSpiritR() <= 3) {
				resetForest();
			} else {
				answer += movingSpirit(new Spirit(golem.getSpiritR(), golem.getSpiritC()));
			}
			
		}
		
	}

	private static void movingGolem(Golem golem) {
		
		int movingDirection = findDirection(golem);
		
		System.out.println(golem);
		System.out.println("골렘 이동: " + movingDirection);
		
		while(movingDirection != -1) {
			if(movingDirection == south) {
				// 남쪽으로 이동
				golem.setSpiritR(golem.getSpiritR() + dr[movingDirection]);
				golem.setSpiritC(golem.getSpiritC() + dc[movingDirection]);
			} else if (movingDirection == west) {
				// 서쪽으로 이동
				golem.setSpiritR(golem.getSpiritR() + dr[movingDirection]);
				golem.setSpiritC(golem.getSpiritC() + dc[movingDirection]);
				// 출구 반시계 회전
				golem.setExit((golem.getExit() + 3) % 4);
				
				// 남쪽으로 이동
				golem.setSpiritR(golem.getSpiritR() + dr[south]);
				golem.setSpiritC(golem.getSpiritC() + dc[south]);
			} else if (movingDirection == east) {
				// 동쪽으로 이동
				golem.setSpiritR(golem.getSpiritR() + dr[movingDirection]);
				golem.setSpiritC(golem.getSpiritC() + dc[movingDirection]);
				// 출구 시계 회전
				golem.setExit((golem.getExit() + 1) % 4);
				
				// 남쪽으로 이동
				golem.setSpiritR(golem.getSpiritR() + dr[south]);
				golem.setSpiritC(golem.getSpiritC() + dc[south]);
			}
			
			movingDirection = findDirection(golem);
			System.out.println(golem);
			System.out.println("골렘 이동: " + movingDirection);
		}
		
		System.out.println(golem);
		
		// forest에 골렘 저장
		forest[golem.getSpiritR()][golem.getSpiritC()] = golem.getNum();
		for(int i = 0; i < 4; i++) {
			forest[golem.getSpiritR() + dr[i]][golem.getSpiritC() + dc[i]] = golem.getNum();
			if(golem.getExit() == i) {
				isExit[golem.getSpiritR() + dr[i]][golem.getSpiritC() + dc[i]] = true;
			}
		}

	}

	private static int movingSpirit(Spirit initSpirit) {
		visited = new boolean[R + 3][C];
		int southRow = initSpirit.getR() - 2;
		System.out.println(initSpirit);
		Queue<Spirit> queue = new ArrayDeque<Spirit>();
		queue.add(initSpirit);
		visited[initSpirit.getR()][initSpirit.getC()] = true;
		
		while(!queue.isEmpty()) {
			int nr, nc;
			Spirit curr = queue.poll();
			System.out.println(curr);
			
			if(curr.getR() - 2 > southRow) {
				southRow = curr.getR() - 2;
			}
			
			for (int i = 0; i < 4; i++) {
				nr = curr.getR() + dr[i];
				nc = curr.getC() + dc[i];
				if(nr >= 3 && nr < R + 3 && nc >= 0 && nc < C && forest[nr][nc] != 0 && !visited[nr][nc]) {
					if(forest[curr.getR()][curr.getC()] == forest[nr][nc]) {
						queue.add(new Spirit(nr, nc));
						visited[nr][nc] = true;
					} else {
						if(isExit[curr.getR()][curr.getC()]) {
							queue.add(new Spirit(nr, nc));
							visited[nr][nc] = true;
						}
					}
				}

				
			}
		}
		
		System.out.println("southRow: " + southRow);
		return southRow;
	}

	private static void resetForest() {
		
		forest = new int[R + 3][C];
		isExit = new boolean[R + 3][C];
//		visited = new boolean[R + 3][C];
	}

	private static int findDirection(Golem golem) {
		
		int spiritR = golem.getSpiritR();
		int spiritC = golem.getSpiritC();
		
		if(isMoving(south, spiritR, spiritC)) {
			return south;
		}
		
		if(isMoving(west, spiritR, spiritC)) {

			// 예비 이동 후, 남쪽 되는지 확인
			if(isMoving(south, spiritR + dr[west], spiritC + dc[west])) {
				return west;
			}
			
		}

		if(isMoving(east, spiritR, spiritC)) {
			
			// 예비 이동 후, 남쪽 되는지 확인
			if(isMoving(south, spiritR + dr[east], spiritC + dc[east])) {
				return east;
			}
		}

		return -1;
	}

	private static boolean isMoving(int direction, int spiritR, int spiritC) {
		
		int nSpiritR, nSpiritC;
		
		nSpiritR = spiritR + dr[direction];
		nSpiritC = spiritC + dc[direction];
		
		for(int i = direction - 1; i < direction + 2; i++) {
			int gr = nSpiritR + dr[(i % 4)];
			int gc = nSpiritC + dc[(i % 4)];
			
			if(!isVaild(gr, gc)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isVaild(int gr, int gc) {
		
		if(gr >= 0 && gr < R + 3 && gc >= 0 && gc < C && forest[gr][gc] == 0) {
			return true;
		}
		return false;
	}
	
	private static void printMaps() {
		
		System.out.println("숲 -------");
		
		for (int r = 0; r < R + 3; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(forest[r][c] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		
		System.out.println("출구 -------");
		for (int r = 0; r < R + 3; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(isExit[r][c] + " ");
			}
			System.out.println();
		}
	}


}
