package algorithm_study.july.day_07_17;

import java.io.*;
import java.util.*;

public class BOJ_12933 {
    static final int N = 5;
    static char[] sound = {'q', 'u', 'a', 'c', 'k'};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sounds = br.readLine();
        int len = sounds.length();
        boolean[] checked = new boolean[len];
        if (len % 5 != 0 || sounds.charAt(0) != 'q') {
            System.out.println(-1);
            return;
        }

        int answer = 0;
        for (int i = 0; i < len; i++) {
            if (checked[i]) continue;
            int idx = 0;
            ArrayList<Character> list = new ArrayList<>();
            for (int j = i; j < len; j++) {
                if (!checked[j] && sound[idx] == sounds.charAt(j)) {
                    checked[j] = true;
                    list.add(sound[idx]);
                    idx = (idx + 1) % N;
                }
            }

            int duck = list.size();
            if (duck != 0 && duck % N == 0) {
                answer++;
            } else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(answer);
    }
}