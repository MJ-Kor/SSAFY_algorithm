package algorithm_study.july.day_07_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String A = input[0];
        String B = input[1];
        int cnt = 0;

        while (true) {
            if (B.endsWith("1")) {
                B = B.substring(0, B.length() - 1);
                cnt++;
            } else if (Integer.parseInt(B) % 2 == 0) {
                B = String.valueOf(Integer.parseInt(B) / 2);
                cnt++;
            } else if (Integer.parseInt(B) % 2 == 1) {
                if (!B.equals(A)) {
                    cnt = -1;
                    break;
                }
            }

            if (Integer.parseInt(B) < Integer.parseInt(A) || B.equals("")) {
                cnt = -1;
                break;
            }

            if (B.equals(A)) {
                cnt++;
                break;
            }
        }

        System.out.println(cnt);
    }
}
