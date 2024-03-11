package templates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Subset {
	
	private static int N;
	private static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		isSelected = new boolean[N + 1];
		
		subset(1);
	}

	private static void subset(int cnt) {
		if(cnt == N + 1) {
			for (int i = 1; i <= N; i++) {
				if(isSelected[i]) {					
					System.out.print(i + " ");
				}
			}
			System.out.println();
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt + 1);
		isSelected[cnt] = false;
		subset(cnt + 1);
	}

}
