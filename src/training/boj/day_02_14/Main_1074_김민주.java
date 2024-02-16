package training.boj.day_02_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_김민주 {

	private static int N, target_r, target_c;
	private static int num = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		target_r = Integer.parseInt(st.nextToken());
		target_c = Integer.parseInt(st.nextToken());
		
		z((int)Math.pow(2, N), 0, 0);
		
	}
	
	public static void z(int size, int r, int c) {
		
		if(size == 1) {
			System.out.println(num);
			return;
		}
		
		int newSize = size / 2;
		if(r + newSize > target_r && c + newSize > target_c) {			
			z(newSize, r, c);
		}
		if(r + newSize > target_r && target_c >= c + newSize) {
			num += (size * size) / 4;
			z(newSize, r, c + newSize);			
		}
		if(r + newSize <= target_r && target_c < c + newSize) {
			num += ((size * size) / 4) * 2;
			z(newSize, r + newSize, c);		
		}
		if(r + newSize <= target_r && target_c >= c + newSize) {
			num += ((size * size) / 4) * 3;
			z(newSize, r + newSize, c + newSize);			
		}
	}

}
