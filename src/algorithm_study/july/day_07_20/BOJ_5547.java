package algorithm_study.july.day_07_20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5547 {

    static int moveOdd[][]  = { {0, -1}, { -1,  0}, {0, 1}, {1, 1}, {1,  0}, {-1, 1}};
    static int moveEven[][] = { {0, -1}, { -1, -1}, {0, 1}, {1, 0}, {1, -1}, {-1, 0}};
    static int map[][];
    static int isInjac[][];
    static boolean visit[][];
    static int w, h;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map     = new int[h+2][w+2];
        isInjac = new int[h+2][w+2];
        visit   = new boolean[h+2][w+2];

        for(int i=1; i<=h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    visit[i][j] = true;
                }
            }
        }

        bfs(0,0);

        int ans = 0;
        for(int i=0; i<isInjac.length; i++) {
            for(int j=0; j<isInjac[i].length; j++) {
                if(isInjac[i][j] == 0) continue;
                ans += isInjac[i][j];
            }
        }

        System.out.println(ans);
    }

    private static void bfs(int x, int y) {
        // TODO Auto-generated method stub
        Queue<hex> q = new LinkedList<hex>();
        q.add(new hex(x, y));
        visit[x][y] = true;

        while(!q.isEmpty()) {
            hex now = q.poll();
            int nextX = 0;
            int nextY = 0;

            for(int i=0; i<6; i++) {
                if(now.x % 2 == 0) {
                    nextX = now.x + moveEven[i][0];
                    nextY = now.y + moveEven[i][1];
                }else {
                    nextX = now.x + moveOdd[i][0];
                    nextY = now.y + moveOdd[i][1];
                }

                if(nextX <0 || nextY < 0 || nextX >= h+2 || nextY >= w+2) continue;

                if(map[nextX][nextY] == 1) {
                    isInjac[now.x][now.y]++;
                    continue;
                }

                if(visit[nextX][nextY] || isInjac[nextX][nextY] != 0) continue;


                visit[nextX][nextY] = true;
                q.add(new hex(nextX, nextY));

            }
        }
    }
}
class hex{
    int x, y;
    public hex(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
