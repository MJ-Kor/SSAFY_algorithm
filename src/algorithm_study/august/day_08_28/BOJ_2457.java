package algorithm_study.august.day_08_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Flower implements Comparable<Flower> {

    int start;
    int end;

    public Flower(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Flower o) {
        if(this.start < o.start) return -1;
        else if(this.start == o.start) {
            if(this.end < o.end) return -1;
            else if(this.end == o.end) return 0;
            else return 1;
        }
        else return 1;
    }
}

public class BOJ_2457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int bloom = 301;
        int wither = 1201;
        int count = 0;
        int max = 0;
        int index = 0;


        Flower[] flowers = new Flower[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start_month = Integer.parseInt(st.nextToken());
            int start_day = Integer.parseInt(st.nextToken());
            int end_month = Integer.parseInt(st.nextToken());
            int end_day = Integer.parseInt(st.nextToken());

            int start = start_month * 100 + start_day;
            int end = end_month * 100 + end_day;

            flowers[i] = new Flower(start, end);
        }

        Arrays.sort(flowers);

        while(bloom < wither) {
            boolean isFinded = false;

            for(int i = index; i < N; i++) {
                if(flowers[i].start > bloom) {
                    break;
                }

                if(max < flowers[i].end) {
                    isFinded = true;
                    max = flowers[i].end;
                    index = i + 1;
                }
            }

            if(isFinded){
                bloom = max;
                count++;
            } else {
                break;
            }
        }

        if(max < wither) {
            System.out.println(0);
        }
        else {
            System.out.println(count);
        }
    }

}
