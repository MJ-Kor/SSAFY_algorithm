package algorithm_study.july.day_07_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int [] visitor = new int[X];
        int sum = 0;
        int max = 0;
        int count = 1;

        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < X; i++) {
            visitor[i] = Integer.parseInt(st.nextToken());
            if (i < N) {
               sum += visitor[i];
               max = Math.max(max, sum);
               continue;
            }

            sum += visitor[i];
            sum -= visitor[i - N];

            if (max == sum) {
                count++;
            }

            if (max < sum) {
                max = sum;
                count = 1;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }

    }
}
