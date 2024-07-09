package algorithm_study.july.day_07_09;

import java.io.*;
import java.util.*;

public class BOJ_18114 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int w = Integer.parseInt(st.nextToken());
            list.add(w);

            if (w == C) {
                System.out.println(1);
                return;
            }
        }

        Collections.sort(list);
        int i = 0;
        int j = N - 1;
        int weight;

        while (i < j) {
            weight = list.get(i) + list.get(j);

            if (weight > C) {
                j--;

            } else if (weight == C) {
                System.out.println(1);
                return;

            } else {
                if (list.indexOf(C - weight) < j && list.indexOf(C - weight) > i) {
                    System.out.println(1);
                    return;
                }
                i++;
            }
        }
        System.out.println(0);
    }
}
