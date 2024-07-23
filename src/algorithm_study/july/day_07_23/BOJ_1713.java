package algorithm_study.july.day_07_23;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1713 {
    static int[] recommend = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Pair> v = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            v.add(new Pair(0, 0));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            recommend[num]++;

            boolean change = true;
            for (int j = 0; j < N; j++) {
                if (v.get(j).second == 0) {
                    v.get(j).second = num;
                    v.get(j).first = i;
                    change = false;
                    break;
                }

                else if (v.get(j).second == num) {
                    change = false;
                    break;
                }
            }

            if (change) {
                int idx = 0;
                for (int j = 1; j < N; j++) {
                    if (recommend[v.get(j).second] == recommend[v.get(idx).second]) {
                        if (v.get(j).first < v.get(idx).first) idx = j;
                    }
                    else if (recommend[v.get(j).second] < recommend[v.get(idx).second]) {
                        idx = j;
                    }
                }
                recommend[v.get(idx).second] = 0;
                v.get(idx).first = i;
                v.get(idx).second = num;
            }
        }

        List<Integer> picture = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (v.get(i).second != 0) {
                picture.add(v.get(i).second);
            }
        }

        Collections.sort(picture);
        for (int i : picture) {
            System.out.print(i + " ");
        }
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
