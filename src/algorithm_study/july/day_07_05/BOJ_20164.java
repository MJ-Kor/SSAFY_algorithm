package algorithm_study.july.day_07_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20164 {

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        calculate(N, 0);
        System.out.println(min + " " + max);
    }

    static void calculate(String N, int oddNum) {
        if(N.length() == 1) {
            min = Math.min(min, oddNum + checkOddNum(N));
            max = Math.max(max, oddNum + checkOddNum(N));
            return;
        }

        if(N.length() == 2) {
            String newNum = Integer.toString(N.charAt(0) - '0' + N.charAt(1) - '0');
            calculate(newNum, oddNum + checkOddNum(N.substring(0, 1)) + checkOddNum(N.substring(1)));
        }
        else {
            for (int firstIdx = 0; firstIdx < N.length() - 2; firstIdx++) {
                for (int secondIdx = firstIdx + 1; secondIdx < N.length() - 1; secondIdx++) {
                    String first = N.substring(0, firstIdx + 1);
                    String second = N.substring(firstIdx + 1, secondIdx + 1);
                    String third = N.substring(secondIdx + 1);
                    calculate(Integer.toString(Integer.parseInt(first) + Integer.parseInt(second) + Integer.parseInt(third)), oddNum + checkOddNum(first) + checkOddNum(second) + checkOddNum(third));
                }
            }
        }
    }

    static int checkOddNum(String num) {
        int oddNum = 0;
        for (int i = 0; i < num.length(); i++) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                oddNum += 1;
            }
        }
        return oddNum;
    }
}
