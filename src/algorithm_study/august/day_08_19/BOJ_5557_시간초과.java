package algorithm_study.august.day_08_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5557_시간초과 {

    static int answer = 0;
    static int N;
    static int[] numbers = new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, numbers[0]);

        System.out.println(answer);

    }


    static void dfs(int depth, int res, int num) {

        if(res < 0 || res > 20) return;

        if(depth == N - 1) {
            if(res == num) {
                answer++;
            }
            return;
        }

        res += num;
        dfs(depth + 1, res, numbers[depth + 1]);

        res -= 2 * num;
        dfs(depth + 1, res, numbers[depth + 1]);

    }
}
