package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17404_김민주 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int INF = 1000 * 1000;
        int answer = INF;
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][3];
        int[][] dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) dp[1][j] = arr[1][j];
                else dp[1][j] = INF;
            }

            for (int k = 2; k <= N; k++) {
                dp[k][0] = Math.min(dp[k - 1][1], dp[k - 1][2]) + arr[k][0];
                dp[k][1] = Math.min(dp[k - 1][0], dp[k - 1][2]) + arr[k][1];
                dp[k][2] = Math.min(dp[k - 1][0], dp[k - 1][1]) + arr[k][2];
            }

            for (int l = 0; l < 3; l++) {
                if (i != l) answer = Math.min(answer, dp[N][l]);
            }
        }

        System.out.println(answer);
    }
}
