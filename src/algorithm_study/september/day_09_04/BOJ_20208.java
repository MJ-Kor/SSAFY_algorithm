package algorithm_study.september.day_09_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Point {
    int r, c;
    boolean visited = false;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Point{" +
                "r=" + r +
                ", c=" + c +
                '}';
    }
}

public class BOJ_20208 {

    static List<Point> milks = new ArrayList<>();
    static Point house;
    static int H;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 2) {
                    milks.add(new Point(r, c));
                } else if (value == 1) {
                    house = new Point(r, c);
                }
            }
        }

        dfs(house.r, house.c, M, 0);

        System.out.println(answer);
    }

    public static void dfs(int r, int c, int M, int num) {

        int d2h = Math.abs(house.r - r) + Math.abs(house.c - c);

        if (d2h != 0) {
            M += H;
            if (M - d2h >= 0) {
                answer = Math.max(answer, num);
            }
        }

        for (int i = 0; i < milks.size(); i++) {

            Point nextMilk = milks.get(i);

            if (nextMilk.visited) continue;

            int d2m = Math.abs(nextMilk.r - r) + Math.abs(nextMilk.c - c);

            if(M - d2m < 0) continue;

            milks.get(i).visited = true;
            dfs(nextMilk.r, nextMilk.c, M - d2m, num + 1);
            milks.get(i).visited = false;
        }

    }
}
