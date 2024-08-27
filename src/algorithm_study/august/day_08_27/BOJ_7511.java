package algorithm_study.august.day_08_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class User{
    int name;
    List<User> follwers = new ArrayList<User>();
    List<User> follwing = new ArrayList<User>();
}

public class BOJ_7511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int edge = Integer.parseInt(br.readLine());

        }
    }
}
