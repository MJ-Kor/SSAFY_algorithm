package algorithm_study.august.day_08_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2115 {

    static class Pattern {
        char[][] pattern;

        Pattern(char[][] pattern) {
            this.pattern = pattern;
        }
    }

    static List<Pattern> patterns = Arrays.asList(
        new Pattern(new char[][]{
            {'.', '.'},
            {'X', 'X'}
        }),
        new Pattern(new char[][]{
            {'X', '.'},
            {'X', '.'}
        }),
        new Pattern(new char[][]{
            {'X', 'X'},
            {'.', '.'}
        }),
        new Pattern(new char[][]{
            {'.', 'X'},
            {'.', 'X'}
        })
    );

    static List<String> field;

    public static void solve(int tc) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        field = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            field.add(br.readLine());
        }

        int ret = 0;

        for (Pattern patt : patterns) {
            ret += scan(patt, n, m);
        }

        System.out.println(ret);
    }

    private static int scan(Pattern patt, int n, int m) {
        boolean[][] picked = new boolean[n][m];

        int ret = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (!picked[i][j] && match(patt, i, j)) {
                    pick(picked, i, j);
                    ret++;
                }
            }
        }

        return ret;
    }

    private static boolean match(Pattern patt, int y, int x) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (field.get(y + i).charAt(x + j) != patt.pattern[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void pick(boolean[][] picked, int y, int x) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                picked[y + i][x + j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solve(0);
    }
}
