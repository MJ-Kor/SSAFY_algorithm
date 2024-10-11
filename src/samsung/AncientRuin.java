package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class RuinsStatus {
	int r, c, rotateAngle, value;

	public RuinsStatus(int r, int c, int rotateAngle, int value) {
		super();
		this.r = r;
		this.c = c;
		this.rotateAngle = rotateAngle;
		this.value = value;
		
	}

	@Override
	public String toString() {
		return "RuinsStatus [r=" + r + ", c=" + c + ", rotateAngle=" + rotateAngle + ", value=" + value + "]";
	}
	
}

class Disk {
	int r, c, type;

	public Disk(int r, int c, int type) {
		super();
		this.r = r;
		this.c = c;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Disk [r=" + r + ", c=" + c + ", type=" + type + "]";
	}
	
}

public class AncientRuin {

	static int RUINSSIZE = 5;
	static int ROTATESIZE = 3;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int K, M, wallIdx = 0;
	static int[] wall;
	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int[][] ruinsInfo;
	static int[][] copyOfRuinsInfo;
	static boolean[][] visited;
	static boolean[][] isEmptyDisk;
	static RuinsStatus ruinsStatus;
	
	public static void main(String[] args) throws IOException {
		
		init();
		solution();
	}
	
	private static void init() throws IOException {

		ruinsInfo = new int[RUINSSIZE][RUINSSIZE];
		visited = new boolean[RUINSSIZE][RUINSSIZE];
		isEmptyDisk = new boolean[RUINSSIZE][RUINSSIZE];
		copyOfRuinsInfo = copyRuinsInfo();
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int r = 0; r < RUINSSIZE; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < RUINSSIZE; c++) {
				ruinsInfo[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		wall = new int[M];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			wall[i] = Integer.parseInt(st.nextToken());
		}
		
		ruinsStatus = new RuinsStatus(RUINSSIZE, RUINSSIZE, 360, 0);
	}

	private static void solution() {
		
		for (int k = 0; k < K; k++) {
			copyOfRuinsInfo = copyRuinsInfo();
			ruinsStatus = new RuinsStatus(RUINSSIZE, RUINSSIZE, 360, 0);
			int answer = 0;
			findRuins();
			copyOfRuinsInfo = copyRuinsInfo();
			System.out.println(ruinsStatus.toString());
			int[] rotateLine = new int[8];
			setRotateLine(rotateLine, ruinsStatus.r, ruinsStatus.c);
			if(ruinsStatus.rotateAngle == 90) {
				rotate90(rotateLine, ruinsStatus.r, ruinsStatus.c);				
			} else if(ruinsStatus.rotateAngle == 180) {
				rotate180(rotateLine, ruinsStatus.r, ruinsStatus.c);
			} else {
				rotate270(rotateLine, ruinsStatus.r, ruinsStatus.c);
			}
			printMap();
			while(true) {
				int value = getValue();
				System.out.println("value: " + value);
				answer += value;
				if(value == 0) break;
				fillRelics();
				printMap();
			}
			System.out.println(answer);
			
			if(answer == 0) return;
			
			System.out.println(answer);
		}
		
	}

	private static void findRuins() {
		
		for(int r = 1; r <= 3; r++) {
			for (int c = 1; c <= 3 ; c++) {
				rotate(r, c);
			}
		}
	}

	private static void rotate(int r, int c) {
		
		int[] rotateLine = new int[8];
		setRotateLine(rotateLine, r, c);
		// rotate -> rotateLine을 각도만큼 밀어버리기
		rotate90(rotateLine, r, c);
		compare(90, r, c);
		rotate180(rotateLine, r, c);
		compare(180, r, c);
		rotate270(rotateLine, r, c);
		compare(270, r, c);
		rotate360(rotateLine, r, c);
	}

	private static void setRotateLine(int[] rotateLine, int r, int c) {
		
		for (int i = 0; i < 8; i++) {
			rotateLine[i] = copyOfRuinsInfo[r + dr[i]][c + dc[i]];
		}
	}

	private static void rotate90(int[] rotateLine, int r, int c) {
		
		for(int i = 0; i < 8; i++) {
			copyOfRuinsInfo[r + dr[i]][c + dc[i]] = rotateLine[(i + 6) % 8];
		}
	}
	
	private static void rotate180(int[] rotateLine, int r, int c) {
		
		for(int i = 0; i < 8; i++) {
			copyOfRuinsInfo[r + dr[i]][c + dc[i]] = rotateLine[(i + 4) % 8];
		}
	}
	
	private static void rotate270(int[] rotateLine, int r, int c) {
		
		for(int i = 0; i < 8; i++) {
			copyOfRuinsInfo[r + dr[i]][c + dc[i]] = rotateLine[(i + 2) % 8];
		}
	}
	
	private static void rotate360(int[] rotateLine, int r, int c) {
		
		for(int i = 0; i < 8; i++) {
			copyOfRuinsInfo[r + dr[i]][c + dc[i]] = rotateLine[i];
		}
	}

	private static void compare(int rotateAngle, int r, int c) {
		
		int value = getValue();
		
		if(ruinsStatus.value == value) {
			if(ruinsStatus.rotateAngle == rotateAngle) {
				if(ruinsStatus.c == c) {
					if(ruinsStatus.r > r) {
						setRuinsStatus(value, rotateAngle, r, c);
					} 
				} else {
					if(ruinsStatus.c > c) {
						setRuinsStatus(value, rotateAngle, r, c);
					}
				}
			} else {
				if(ruinsStatus.rotateAngle > rotateAngle) {
					setRuinsStatus(value, rotateAngle, r, c);
				}
			}
		} else {
			if(ruinsStatus.value < value) {
				setRuinsStatus(value, rotateAngle, r, c);
			}
		}
	}
	
	private static void setRuinsStatus(int value, int rotateAngle, int r, int c) {
		ruinsStatus.value = value;
		ruinsStatus.rotateAngle = rotateAngle;
		ruinsStatus.r = r;
		ruinsStatus.c = c;
	}

	private static int getValue() {
		int totalValue = 0;
		
		for (int r = 0; r < RUINSSIZE; r++) {
			for (int c = 0; c < RUINSSIZE; c++) {
				if(!visited[r][c]) {
					totalValue += bfs(r, c);
				}
			}
		}
		
		visited = new boolean[RUINSSIZE][RUINSSIZE];
		return totalValue;
	}

	private static int bfs(int r, int c) {
		Queue<Disk> queue = new LinkedList<>();
		Stack<Disk> stack = new Stack<Disk>(); 
		queue.add(new Disk(r, c, copyOfRuinsInfo[r][c]));
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int nr, nc;
			Disk curr = queue.poll();
			stack.add(curr);
			
			for (int i = 1; i < 8; i+=2) {
				nr = curr.r + dr[i];
				nc = curr.c + dc[i];
				if(nr >= 0 && nr < RUINSSIZE && nc >=0 && nc < RUINSSIZE && !visited[nr][nc] && copyOfRuinsInfo[nr][nc] == curr.type) {
					queue.add(new Disk(nr, nc, copyOfRuinsInfo[nr][nc]));
					visited[nr][nc] = true;
				}
			}
		}
		
		if(stack.size() >= 3) {
			int size = stack.size();
			
			while(!stack.isEmpty()) {
				Disk disk = stack.pop();
				isEmptyDisk[disk.r][disk.c] = true;
			}
			return size;
		}
		
		return 0;
	}

	private static void fillRelics() {
		
		for (int c = 0; c < RUINSSIZE; c++) {
			for (int r = RUINSSIZE - 1; r >= 0; r--) {
				if(isEmptyDisk[r][c]) {
					copyOfRuinsInfo[r][c] = wall[wallIdx];
					wallIdx++;
				}
			}
		}
	}

	private static int[][] copyRuinsInfo() {
		
		int[][] copy = new int[RUINSSIZE][RUINSSIZE];
		
		for (int r = 0; r < copy.length; r++) {
			for (int c = 0; c < copy.length; c++) {
				copy[r][c] = ruinsInfo[r][c];
			}
		}
		
		return copy;
	}

	private static void printMap() {
		for (int r = 0; r < RUINSSIZE; r++) {
			for (int c = 0; c < RUINSSIZE; c++) {
				System.out.print(copyOfRuinsInfo[r][c] + " ");
			}
			System.out.println();
		}
	}

}
