package algorithm_study.july.day_07_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        int[] b = new int[N];

        int[] minus = new int[N];
        int[] plus = new int[N];

        int[] oriMinus = new int[N];
        int[] oriPlus = new int[N];

        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            minus[i] = a[i] - b[i];
            plus[i] = a[i] + b[i];

            oriMinus[i] = minus[i];
            oriPlus[i] = plus[i];
        }

        Arrays.sort(minus);
        Arrays.sort(plus);

        int l, h, mid;

        StringBuilder sb = new StringBuilder();

        // 범위 탐색
        for(int i=0; i<N; ++i){

            l = 0;
            h = N;
            while (l<h){
                mid = (l+h) >> 1;
                if(plus[mid] < oriMinus[i]){
                    l = mid + 1;
                }
                else{
                    h = mid;
                }
            }
            sb.append(h+1).append(" ");

            l = 0;
            h = N;
            while (l < h){
                mid = (l+h) >> 1;
                if(minus[mid] <= oriPlus[i]){
                    l = mid + 1;
                }
                else{
                    h = mid;
                }
            }
            sb.append(h).append("\n");
        }

        System.out.print(sb);
    }
}
