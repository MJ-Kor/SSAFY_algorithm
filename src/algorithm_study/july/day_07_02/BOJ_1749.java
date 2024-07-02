package algorithm_study.july.day_07_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = Integer.MIN_VALUE;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][M + 1];
        int[][] sum = new int[N + 1][M + 1];

        for (int i = 1; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= M ; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + arr[i][j];
            }
        }

        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= M ; j++) {
                for (int k = i; k <= N ; k++) {
                    for (int l = j; l <= M ; l++) {
                        int nSum = sum[k][l] - sum[i - 1][l] - sum[k][j - 1] + sum[i - 1][j - 1];
                        answer = Math.max(answer, nSum);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
