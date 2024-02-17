package training.boj.extra;

// N과 M (6)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15655_김민주 {

	private static int N;
	private static int M;
	private static int[] numbers;
	private static int[] outputs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		outputs = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		comb(0, 0);
		
	}
	
	public static void comb(int cnt, int start) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(outputs[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			outputs[cnt] = numbers[i];
			comb(cnt + 1, i + 1);
		}
	}
}