package algorithm_study.august.day_08_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13424 {
    static final int INF = 1000000000;
    static int[][] dist = new int[101][101];

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int a=0; a<t; a++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for(int i=1; i<=n; i++)
                for(int j=1; j<=n; j++)
                    dist[i][j] = (i != j)? INF:0;

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());

                int h = Integer.parseInt(st.nextToken());
                int tg = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                dist[h][tg] = d;
                dist[tg][h] = d;
            }
            int k = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<k; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            for(int z=1; z<=n; z++)
                for(int i=1; i<=n; i++)
                    for(int j=1; j<=n; j++)
                        if(i == j)
                            continue;
                        else
                            dist[i][j] = Math.min(dist[i][j], dist[i][z] + dist[z][j]);
            int min = INF, idx = -1;
            for(int i=1; i<=n; i++){

                int sum = 0;

                for(int j=0; j<k; j++)
                    sum += dist[arr[j]][i];

                if(sum < min){
                    idx = i;
                    min = sum;
                }
            }
            System.out.println(idx);
        }
    }
}
