package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473_김민주 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Long sumAbs = Long.MAX_VALUE;

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        long[] answer = new long[3];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {

            int left = 0;
            int right = N - 1;

            if (left == i) {
                left += 1;
            }

            if (right == i) {
                right -= 1;
            }

            while (left < right) {
                Long nowSum = arr[left] + arr[right] + arr[i];
                Long nowAbs = Math.abs(nowSum);

                if (sumAbs > nowAbs) {
                    answer[0] = arr[left];
                    answer[1] = arr[i];
                    answer[2] = arr[right];
                    sumAbs = nowAbs;
                }

                if (nowSum > 0) {
                    right -= 1;
                    if (right == i) {
                        right -= 1;
                    }
                }

                if (nowSum < 0) {
                    left += 1;
                    if (left == i) {
                        left += 1;
                    }
                }

                if (nowAbs == 0) {
                    Arrays.sort(answer);
                    System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
                    System.exit(0);
                }
            }
        }
        Arrays.sort(answer);
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
