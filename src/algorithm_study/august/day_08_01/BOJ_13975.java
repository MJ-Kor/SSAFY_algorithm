package algorithm_study.august.day_08_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder ans = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for(int t=1; t<=TC; t++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(int i=0; i<N; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            long sum = 0;
            while(pq.size() > 1) {
                long x = pq.poll();
                long y = pq.poll();
                sum += x+y;
                pq.add(x+y);
            }
            ans.append(sum + "\n");
        }
        System.out.printf(ans.toString());
    }
}
