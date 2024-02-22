package a형대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 생명력 수치 X 	-> X시간 동안 비활성 상태이고, X시간이 지나는 순간 활성 상태가 된다.
 * 			 	-> X시간 동안 살아있고, X시간이 지나면 세포는 죽게됨
 * 				-> 죽은 상태로 그리드 셀 차지
 * 
 * 세포는 첫 1시간 상, 하, 좌, 우 네 방향 동시에 번식을 한다.
 * 
 * 하나의 그리드 셀에 동시에 번식을 하려는 경우 생명력 수치가 높은 세포가 혼자 차지한다. 
 * @author SSAFY
 *
 */
public class Solution_5653_김민주 {
	
	private static int T, N, M, K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			K = Integer.parseInt(br.readLine());
		}
	}

}
