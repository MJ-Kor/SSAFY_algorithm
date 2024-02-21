package training.boj.extra.silver;

// N과 M (7)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15656_김민주 {

	private static int N;
	private static int M;
	private static int[] numbers;
	private static int[] outputs;
	private static StringBuilder sb = new StringBuilder();
	
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
		comb(0);
		
		System.out.println(sb);
		
	}
	
	public static void comb(int cnt) {
		if(cnt == M) {
			
			for (int i = 0; i < M; i++) {
				sb.append(outputs[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < N; i++) {
			outputs[cnt] = numbers[i];
			comb(cnt + 1);
		}
	}
}