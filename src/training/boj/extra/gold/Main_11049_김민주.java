package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11049_김민주 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N][2];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else if(j == (i + 1)){
                    dp[i][j] = matrix[i][0] * matrix[i][1] * matrix[j][1];
                } else {
                    dp[i][j] = 987654321;
                }
            }
        }

        for(int i = 2; i < N; i++) {
            for(int j = 0; j < N - i; j++) {
                for(int k = j; k < j + i; k++) {
                    int count = matrix[j][0] * matrix[k][1] * matrix[j + i][1];
                    dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k+1][j+i] + count);
                }
            }
        }
        System.out.println(dp[0][N-1]);
    }
}
