package training.boj.day_02_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 임의의 DNA 문자열을 만들고, DNA 문자열의 부분문자열을 비밀번호로 사용
 * -> 취약한 비밀번호가 만들어 질 수 있는 무넺 발생
 * -> 등장하는 문자의 개수가 특정 개수 이상이어야 비밀번호로 사용할 수 있는 규칙
 * 
 * 구하려는 것: 만들 수 있는 비밀번호의 종류
 * 조건: 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급
 * 
 * 입력 format
 * 1. 임의로 만든 DNA의 문자열 길이 |S|, 비밀번호로 사용할 부분문자열의 길이 |P|
 * 2. 임의로 만든 DNA 문자열
 * 3. 부분문자열에 포함되어야 할 {'A', 'C', 'G', 'T'}의 최소 개수가 공백 구분으로 주어짐
 * 
 * @author SSAFY
 *
 */

public class Main_12891_김민주 {
	
	private static int S, P;
	private static String dnaStr;
	private static int[] contains;
	private static int[] nums = new int[4];
	private static void subtractCount(char ch) {
		switch(ch) {
			case'A': {
				nums[0]--;
				break;
			}
			case'C': {
				nums[1]--;
				break;
			}
			case'G': {
				nums[2]--;
				break;
			}
			case'T': {
				nums[3]--;
				break;
			}
		}
	}
	private static void addCount(char ch) {
		switch(ch) {
			case'A': {
				nums[0]++;
				break;
			}
			case'C': {
				nums[1]++;
				break;
			}
			case'G': {
				nums[2]++;
				break;
			}
			case'T': {
				nums[3]++;
				break;
			}
		}
	}
	private static boolean validCheck(int [] nums) {
		for (int i = 0; i < 4; i++) {
			if((contains[i] - nums[i]) > 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		dnaStr = br.readLine();
		contains = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int result = 0;
		
		for (int i = 0; i < P; i++) {
			addCount(dnaStr.charAt(i));
		}
		
		if(validCheck(nums)) {
			result++;
		}
		
		for (int k = 1; k <= S - P; k++) {
			subtractCount(dnaStr.charAt(k-1));
			addCount(dnaStr.charAt(P-1+k));
			if(validCheck(nums)) {
				result++;
			}
		}
		
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		
	}

}
