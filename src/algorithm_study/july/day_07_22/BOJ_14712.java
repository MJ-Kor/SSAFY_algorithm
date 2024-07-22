package algorithm_study.july.day_07_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14712 {

    static int R, C;
    static boolean[][] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[R][C];

        dfs(0, 0);
        System.out.println(cnt);
    }

    public static void dfs(int depth, int start) {

        if(!check(depth)) cnt++;

        if(depth == R*C) {
            return;
        }

        for (int i = start; i < R*C; i++) {
            int r = i / C;
            int c = i % C;

            if(visited[r][c]) continue;

            visited[r][c] = true;
            dfs(depth + 1, i + 1);
            visited[r][c] = false;
        }
    }

    public static boolean check(int depth) {
        if (depth < 4) return false;

        for (int i = 0; i < R - 1; i++) {
            for (int j = 0; j < C - 1; j++) {
                if(visited[i][j] && visited[i + 1][j] && visited[i][j + 1] && visited[i + 1][j + 1]) {
                    return true;
                }
            }
        }

        return false;
    }
}
