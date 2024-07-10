package algorithm_study.july.day_07_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class qData {
    int num;
    int cnt;

    public qData(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}

public class BOJ_5567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] adj = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a][b] = 1;
            adj[b][a] = 1;
        }
        System.out.println(bfs(n, adj));
    }

    public static int bfs(int n, int[][] adj) {
        boolean[] visited = new boolean[n + 1];
        int answer = 0;
        Queue<qData> queue = new ArrayDeque<>();
        visited[1] = true;
        for (int i = 2; i <= n; i++) {
            if(adj[1][i] == 1) {
                queue.offer(new qData(i, 1));
                visited[i] = true;
            }
        }

        while(!queue.isEmpty()) {
            qData curr = queue.poll();
            answer++;
            for (int i = 2; i <= n; i++) {
                if(curr.cnt == 2) break;

                if(adj[curr.num][i] == 0 || visited[i]) continue;

                queue.offer(new qData(i, curr.cnt + 1));
                visited[i] = true;
            }
        }
        return answer;
    }
}
