package algorithm_study.july.day_07_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20164 {
    // 수의 각 자리 숫자 중에서 horse의 개수를 종이에 적는다
    // 수가 한 자리이면 더 이상 아무것도 하지 못하고 종료
    // 수가 두 자리이면 2개로 나눠서 합을 구하여 새로운 수로 생각한다.
    // 수가 세 자리 이상이면 임의의 위치에서 끊어서 3개의 수로 분할하고, 3개를 더한 값을 새로운 수로 생각한다


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
            min = Math.min(min, oddNum);
            max = Math.max(max, oddNum);
            return;
        }

        if(N.length() == 2) {
            N = Integer.toString(N.charAt(0) - '0' + N.charAt(1) - '0');
            calculate(N, oddNum);
        }
        // (N.length() >= 3)
        else {
            for (int firstIdx = 0; firstIdx < N.length() - 2; firstIdx++) {
                for (int secondIdx = firstIdx + 1; secondIdx < N.length() - 1; secondIdx++) {
//                    System.out.println("firstIdx = "+firstIdx + " secondIdx = " + secondIdx);
                    String first = N.substring(0, firstIdx + 1);
                    String second = N.substring(firstIdx + 1, secondIdx + 1);
                    String third = N.substring(secondIdx + 1);
//                    System.out.println("first = " + first + " second = " + second + " third = " + third);
                    oddNum += checkOddNum(first, second, third);
                    calculate(Integer.toString(Integer.parseInt(first) + Integer.parseInt(second) + Integer.parseInt(third)), oddNum);
                }
            }
        }
    }

    static int checkOddNum(String first, String second, String third) {
        System.out.println("1: " + first + " 2: " + second + "3: " + third);
        int oddNum = 0;
        if(Integer.parseInt(first) % 2 != 0) oddNum++;
        if(Integer.parseInt(second) % 2 != 0) oddNum++;
        if(Integer.parseInt(third) % 2 != 0) oddNum++;

        return oddNum;
    }

}
