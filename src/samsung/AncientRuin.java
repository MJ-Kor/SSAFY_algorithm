package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [1] 탐사
// 5x5 격자 주어짐
// 3x3 격자 회전
// 90도, 180도, 270도 중 시계 방향 회전
// 1. 유물 가치 최대화
// 2. 회전 각도 가장 작음
// 3. 회전 중심 좌표의 열이 가장 작은 구간
// 4. 회전 중심 좌표의 행이 가장 작은 구간

// [2] 유물 획득
// 상하좌우로 인접한 같은 종류의 유물 조각은 연결
// 3개 이상 연결된 경우, 유물이 되어 사라짐
// 유물의 가치는 조각의 개수 -> 3개 이상 연결된 영역을 찾고, 영역의 칸 개수 구하기
// 유적의 벽면에 적힌 순서대로 유물이 없어진 곳에 새로운 조각이 생겨남 -> 없어진 곳의 위치를 구해놔야 함
// 1. 열 번호가 작은 순
// 2. 행 번호가 큰 순
// 유적의 벽면에 있는 숫자는 남는 숫자부터 순서대로 사용 -> 사용된 숫자 위치 인덱스 처리
// 유물 획득이 더이상 진행되지 않을때까지 반복 (유물의 연쇄 획득)

// [3] 탐사 반복
// [1] ~ [2]를 1턴으로 생각하여 K번 진행
// K번을 진행하지 못해도 더이상 유물을 획득할 수 없다면 모든 탐사는 종류 -> 그대로 끝, 종료되는 턴에는 출력하지 않음

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

public class AncientRuin {

	static int RUINSSIZE = 5;
	static int ROTATESIZE = 3;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int K, M, wallIdx = 0;
	static int[] wall;
	static int[][] ruinsInfo;
	static RuinsStatus ruinsStatus;
	
	public static void main(String[] args) throws IOException {
		
		init();
		solution();
		
	}
	
	private static void init() throws IOException {

		ruinsInfo = new int[RUINSSIZE][RUINSSIZE];
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
		
		ruinsStatus = new RuinsStatus(0, 0, 0, 0);
	}
	
	private static void solution() {
		
		// 회전 후 1차 유물 획득 - 27번 반복
		findRuins();
		getValue();
		fillRelics();
		exploration();
		// 제일 큰 경우 선택
		// 유물 획득 반복 - 가치 저장
		
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
		rotate90(r, c);
		compare(90, r, c);
		rotate180(r, c);
		compare(180, r, c);
		rotate270(r, c);
		compare(270, r, c);
	}

	private static void setRotateLine(int[] rotateLine, int r, int c) {
		
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

	private static void rotate90(int r, int c) {
		
		
	}

	private static void rotate180(int r, int c) {
		
		
	}

	private static void rotate270(int r, int c) {
		// TODO Auto-generated method stub
		
	}

	private static int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	private static void fillRelics() {
		// TODO Auto-generated method stub
		
	}

	private static void exploration() {
		// TODO Auto-generated method stub
		
	}



}
