package training.boj.day_03_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1786_김민주 {
	
	private static int total = 0;
	private static List<Integer> sIdx = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String H = br.readLine();
		String N = br.readLine();
		
		kmp(H, N);
		
		System.out.println(total);
		for(int idx : sIdx) {
			System.out.print(idx + " ");
		}
	}

	private static void kmp(String H, String N) {
		
		int HLen = H.length();
		int NLen = N.length();
		
		int idx = 0;
		
		int[] table = makeTable(N, NLen);
		
		for (int i = 0; i < HLen; i++) {
			while(idx > 0 && H.charAt(i) != N.charAt(idx)) {
				idx = table[idx - 1];
			}
			if(H.charAt(i) == N.charAt(idx)) {
				if(idx == NLen - 1) {
					++total;
					sIdx.add(i - idx + 1);
					idx = table[idx];
				} else {
					idx += 1;
				}
			}
		}
	}

	private static int[] makeTable(String N, int NLen) {
		int[] pi = new int[NLen];
		
		int j = 0;
		for (int i = 1; i < NLen; i++) {
			while(j > 0 && N.charAt(i) != N.charAt(j)) {
				j = pi[j - 1];
			}
			if(N.charAt(i) == N.charAt(j)) {
				++j;
				pi[i] = j;
			}
		}
		return pi;
	}

}