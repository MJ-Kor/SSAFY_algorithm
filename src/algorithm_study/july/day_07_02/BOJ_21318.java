package algorithm_study.july.day_07_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21318 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int level[] = new int[n];
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            level[i] = Integer.parseInt(st.nextToken());
            if(i == 0) {
                dp[i] = 0;
                continue;
            }
            if(level[i - 1] > level[i]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            System.out.println(dp[end] - dp[start]);
        }
    }
}
