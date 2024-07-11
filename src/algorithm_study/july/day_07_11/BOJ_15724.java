package algorithm_study.july.day_07_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R + 1][C + 1];

        for (int r = 1; r <= R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= C; c++) {

                if (r == 1) {
                    if (c == 1) map[r][c] = Integer.parseInt(st.nextToken());
                    else map[r][c] = map[r][c - 1] + Integer.parseInt(st.nextToken());
                } else {
                    if (c == 1) map[r][c] = map[r - 1][c] + Integer.parseInt(st.nextToken());
                    else map[r][c] = map[r - 1][c] + map[r][c - 1] - map[r - 1][c - 1] + Integer.parseInt(st.nextToken());
                }

            }
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(map[x2][y2] - map[x1 - 1][y2] - map[x2][y1 - 1] + map[x1 - 1][y1 - 1]);
        }
    }
}
