package algorithm_study.july.day_07_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_21314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int cnt_m = 0;
        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'K') {
                max.append(maxCase(cnt_m));
                min.append(minCase(cnt_m));
                cnt_m = 0;
                continue;
            }
            cnt_m++;
        }

        if(cnt_m != 0) {
            max.append(maxEnd(cnt_m));
            min.append(minEnd(cnt_m));
        }
        System.out.println(max);
        System.out.println(min);
    }

    public static StringBuilder maxCase(int cnt_m) {
        StringBuilder maxStr = new StringBuilder("5");
        maxStr.append("0".repeat(Math.max(0, cnt_m)));
        return maxStr;
    }

    public static StringBuilder minCase(int cnt_m) {
        if(cnt_m == 0) return new StringBuilder("5");
        else {
            StringBuilder minStr = new StringBuilder("1");
            minStr.append("0".repeat(Math.max(0, cnt_m - 1))).append("5");
            return minStr;
        }
    }

    public static StringBuilder maxEnd(int cnt_m) {
        StringBuilder maxStr = new StringBuilder();
        maxStr.append("1".repeat(Math.max(0, cnt_m)));
        return maxStr;
    }

    public static StringBuilder minEnd(int cnt_m) {
        StringBuilder minStr = new StringBuilder("1");
        minStr.append("0".repeat(Math.max(0, cnt_m - 1)));
        return minStr;
    }
}
