package algorithm_study.august.day_08_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5557 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int [] arr= new int[n];
        long [][] dp = new long[n][21];

        String[] s = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        dp[0][arr[0]] = 1;

        int plus;
        int minus;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= 20 ; j++) {
                if(dp[i - 1][j] != 0) {
                    plus = j+arr[i];
                    minus = j-arr[i];;
                    if(plus >= 0 && plus <= 20) {
                        dp[i][plus] +=dp[i - 1][j];
                    }
                    if(minus >= 0 && minus <= 20) {
                        dp[i][minus] += dp[i - 1][j];
                    }
                }
            }
        }

        System.out.println(dp[n-2][arr[n-1]]);
    }

}
