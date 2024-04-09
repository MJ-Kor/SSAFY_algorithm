package algorithm_study.day_04_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N: 컨베이어 벨트 길이
 * K: 종료 조건
 */
public class BOJ_20055 {

	private static class BeltSpace{
		int durability;
		boolean isRobot;
		
		public BeltSpace(int durability) {
			super();
			this.durability = durability;
			this.isRobot = false;
		}

		@Override
		public String toString() {
			return "BeltSpace [durability=" + durability + ", isRobot=" + isRobot + "]";
		}
	}
	
	private static int step = 1;
	private static int N, K;
	private static BeltSpace[] belt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		belt = new BeltSpace[2 * N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			belt[i] = new BeltSpace(Integer.parseInt(st.nextToken()));
		}
		
		boolean valid = true;
		
		do {
//			System.out.println("before: " + Arrays.toString(belt));
//			System.out.println();
			rotateBelt();
			moveRobot();
			putRobot();
			valid = checkDurability();
			if(valid) step++; 
//			if(step == 32) break;
		}while(valid);
		
		System.out.println(step);
	}

	private static void rotateBelt() {
		BeltSpace[] copied = new BeltSpace[2 * N];
		for (int i = 0; i < 2 * N; i++) {
			copied[(i + 1) % (2 * N)] = belt[i];
		}
		
		belt = copied;
		if(belt[N-1].isRobot) belt[N-1].isRobot = false;
//		System.out.println("rotate: " + Arrays.toString(belt));
//		System.out.println();
	}

	private static void moveRobot() {
		for (int i = N - 2; i >= 0 ; i--) {
			if(!belt[i].isRobot || belt[i + 1].durability == 0) continue;
			if(!belt[i + 1].isRobot) {
				belt[i + 1].isRobot = true;
				belt[i + 1].durability--;
				belt[i].isRobot = false;
			}
		}
		if(belt[N-1].isRobot) belt[N-1].isRobot = false;
//		System.out.println("move" + Arrays.toString(belt));
//		System.out.println();
	}

	private static void putRobot() {
		if(belt[0].durability != 0 && belt[0].isRobot == false) {
			belt[0].isRobot = true;
			belt[0].durability--;
		}
//		System.out.println("put" + Arrays.toString(belt));
//		System.out.println();
	}

	private static boolean checkDurability() {
		int check = 0;
		for (int i = 0; i < belt.length; i++) {
			if(belt[i].durability == 0) check++;
		}
		if(check >= K) return false;
		return true;
	}
}
