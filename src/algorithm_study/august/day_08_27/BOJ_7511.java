package algorithm_study.august.day_08_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_7511 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            System.out.println("Scenario " + i + ":");

            int[] P;
            int N = Integer.parseInt(br.readLine());
            int edge = Integer.parseInt(br.readLine());

            P = new int[N];
            makeSet(P, N);

            for (int j = 0; j < edge; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                union(P, x, y);
            }

            int check = Integer.parseInt(br.readLine());

            for (int j = 0; j < check; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (isFriend(P, x, y)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }

            System.out.println();
        }
    }

    public static void makeSet(int[] P, int N) {
        for (int i = 0; i < N; i++) {
            P[i] = i;
        }
    }

    // Path Compression, 없으면 시간초과
    public static int findSet(int[] P, int x) {
        if(P[x] == x) return x;
        else return P[x] = findSet(P, P[x]);
    }

    public static void union(int[] P, int x, int y) {
        if(P[x] == P[y]) return;
        P[findSet(P, x)] = findSet(P, y);
    }

    // 같은 집합이라면 대표자가 같음
    public static boolean isFriend(int[] P, int x, int y) {
        return findSet(P, x) == findSet(P, y);
    }
}
