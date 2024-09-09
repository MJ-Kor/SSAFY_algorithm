package training.boj.extra.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16724_김민주 {

    static int[][] map;
    static boolean[][] visited;
    static boolean[][] finished;
    static int answer = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        finished = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                if(str.charAt(j) == 'U') {
                    map[i][j] = 0;
                } else if(str.charAt(j) == 'D') {
                    map[i][j] = 1;
                } else if(str.charAt(j) == 'L') {
                    map[i][j] = 2;
                } else {
                    map[i][j] = 3;
                }
            }
        }

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(visited[r][c] != true) {
                    dfs(r, c);
                }
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int r, int c) {

        int now = map[r][c];
        visited[r][c] = true;
        int nr = r + dr[now];
        int nc = c + dc[now];

        if(!visited[nr][nc]) {
            dfs(nr, nc);
        } else{
            if(!finished[nr][nc]){
                answer++;
            }
        }

        finished[r][c] = true;
    }
}
