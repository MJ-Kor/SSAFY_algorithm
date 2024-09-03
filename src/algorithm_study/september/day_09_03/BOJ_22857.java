package algorithm_study.september.day_09_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22857 {
    static int n, k;
    static int[] nums;
    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nums = new int[n];
        d = new int[n + 1][k + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (nums[i - 1] % 2 == 0) {
                    d[i][j] = d[i - 1][j] + 1;
                } else {
                    if (j > 0) {
                        d[i][j] = d[i - 1][j - 1];
                    }
                }
                max = Math.max(max, d[i][j]);
            }
        }
        System.out.println(max);

    }
}
