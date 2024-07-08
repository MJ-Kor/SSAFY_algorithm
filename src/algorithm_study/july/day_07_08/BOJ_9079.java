package algorithm_study.july.day_07_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9079 {
    static final int MAX = 987654321;
    static int[][] maze = new int[3][3];
    static boolean[] visited = new boolean[512];

    // 열
    static void colChange(int col) {
        for (int i = 0; i < 3; i++) {
            maze[i][col] = (maze[i][col] == 1 ? 0 : 1);
        }
    }

    // 행
    static void rowChange(int row) {
        for (int i = 0; i < 3; i++) {
            maze[row][i] = (maze[row][i] == 1 ? 0 : 1);
        }
    }

    // 대각선
    static void crossChange(int dir) {
        for (int i = 0; i < 3; i++) {
            if (dir == 0) {
                maze[i][i] = (maze[i][i] == 1 ? 0 : 1);
            } else {
                maze[i][2 - i] = (maze[i][2 - i] == 1 ? 0 : 1);
            }
        }
    }

    // 모든 면이 같은지 확인
    static boolean isCorrect() {
        int temp = maze[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (temp != maze[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 현재 상태를 정수로 매핑
    static int mazeToInt() {
        int now = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                now = now * 2 + maze[i][j];
            }
        }
        return now;
    }

    // 매핑된 함수를 이용하여 현재 상태를 표현
    static void intToMaze(int number) {
        for (int i = 2; i >= 0; i--) {
            for (int j = 2; j >= 0; j--) {
                maze[i][j] = number % 2;
                number /= 2;
            }
        }
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        int first = mazeToInt();
        q.add(new int[]{first, 0});
        Arrays.fill(visited, false);
        visited[first] = true;

        while (!q.isEmpty()) {
            int[] front = q.poll();
            int now = front[0];
            int cnt = front[1];

            intToMaze(now);

            if (isCorrect()) {
                return cnt;
            }

            // 열 변환
            for (int i = 0; i < 3; i++) {
                colChange(i);
                int next = mazeToInt();
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, cnt + 1});
                }
                colChange(i);
            }

            // 행 변환
            for (int i = 0; i < 3; i++) {
                rowChange(i);
                int next = mazeToInt();
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, cnt + 1});
                }
                rowChange(i);
            }

            // 대각선 변환
            for (int i = 0; i <= 1; i++) {
                crossChange(i);
                int next = mazeToInt();
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, cnt + 1});
                }
                crossChange(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    char data = st.nextToken().charAt(0);
                    maze[i][j] = (data == 'H' ? 1 : 0);
                }
            }
            System.out.println(bfs());
        }
    }
}