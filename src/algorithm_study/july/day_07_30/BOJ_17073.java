package algorithm_study.july.day_07_30;

import java.io.*;
import java.util.*;

public class BOJ_17073 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[N + 1];
        int leafNum = 0;

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }

        for (int i = 2; i < N + 1; i++) {
            if(list[i].size() == 1) leafNum++;
        }

        System.out.println((double)W/leafNum);
    }


}
