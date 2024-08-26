package algorithm_study.august.day_08_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14284 {
    static int dist[];
    static ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();

    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Vertex(end,cost));
            graph.get(end).add(new Vertex(start,cost));
        }

        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int t= Integer.parseInt(st.nextToken());

        System.out.println(solution(s,t));
    }


    static int solution(int s,int t){
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Vertex> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        queue.add(new Vertex(s,0));

        dist[s] = 0;

        while(!queue.isEmpty()){
                Vertex now = queue.poll();

                for(Vertex next : graph.get(now.v)){
                    if(dist[next.v] > dist[now.v] + next.cost){
                        dist[next.v] = dist[now.v] + next.cost;
                        queue.add(new Vertex(next.v,dist[next.v]));
                    }
                }
        }

        return dist[t];
    }

    static class Vertex{
            int v;
            int cost;

            public Vertex(int v,int cost){

                this.v = v;
                this.cost = cost;
            }
    }
}
