package hw.day_02_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 최소 1개의 모음, 최소 2개의 자음
public class Main_1759_김민주 {

	// 암호의 길이, 사용 문자 후보
	private static int L, C;
	private static String[] ch;
	private static String[] numbers;
	private static String consonant = "aeiou";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		ch = new String[C];
		numbers = new String[L];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			ch[i] = st.nextToken();
		}
		Arrays.sort(ch);
		
		comb(0, 0, 0, 0);
	}
	
	public static void comb(int start, int cnt, int consonantNum, int vowelNum) {
		if(cnt == L) {
			// 자음이 2개 이상, 모음이 1개 이상인 경우에만 정답 출력
			if(consonantNum >= 1 && vowelNum >= 2) {
				for (int i = 0; i < L; i++) {
					System.out.print(numbers[i]);
				}
				System.out.println();
			}
			return;
		}
		// 조합 재귀
		for (int i = start; i < ch.length; i++) {
			numbers[cnt] = ch[i];
			// 만약 해당 문자가 모음이면~ 모음 개수 + 1
			if(consonant.contains(ch[i])) comb(i + 1, cnt + 1, consonantNum + 1, vowelNum);
			// 아니면 자음 개수 + 1
			else comb(i + 1, cnt + 1, consonantNum, vowelNum + 1);
		}
	}
	
}
