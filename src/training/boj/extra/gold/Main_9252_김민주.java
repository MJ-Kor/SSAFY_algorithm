package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9252_김민주 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dr = {-1, 0};
        int[] dc = {0, -1};

        String str1 = br.readLine();
        String str2 = br.readLine();
        int N = str1.length();
        int M = str2.length();

        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int cr = N;
        int cc = M;

        // 스택으로 줄일 수 있음
        while (sb.length() != dp[N][M] || cr >= 1 && cc >= 1) {
            if (dp[cr + dr[0]][cc + dc[0]] == dp[cr][cc]) {
                cr += dr[0];
                cc += dc[0];
            } else if (dp[cr + dr[1]][cc + dc[1]] == dp[cr][cc]) {
                cr += dr[1];
                cc += dc[1];
            } else {
                cr -= 1;
                cc -= 1;
                sb.append(str1.charAt(cr));
            }
        }

        System.out.println(dp[N][M]);
        System.out.println(sb.reverse());

    }
}
