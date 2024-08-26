package algorithm_study.august.day_08_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Egg{
    int weight, durability;
    boolean isBreak = false;

    public Egg(int durability, int weight){
        this.weight = weight;
        this.durability = durability;
    }
}

public class BOJ_16987 {

    static Egg[] eggs;
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        backTracking(0, 0);

        System.out.println(answer);
    }

    public static void backTracking(int hand, int brokenEggs) {

        // 모든 계란을 다 돎
        if(hand == N) {
            answer = Math.max(answer, brokenEggs);
            return;
        }


        // 손에 든 계란이 깨짐
        if(eggs[hand].durability <= 0 || brokenEggs == N - 1) {
            backTracking(hand + 1, brokenEggs);
            return;
        }

        // 계란 깨기
        for (int i = 0; i < N; i++) {
            if(hand == i || eggs[i].isBreak) continue;
            brokenEggs += breakEgg(hand, i);
            backTracking(hand + 1, brokenEggs);
            brokenEggs -= recoverEgg(hand, i);
        }

    }

    public static int breakEgg(int hand, int target) {
        eggs[target].durability -= eggs[hand].weight;
        eggs[hand].durability -= eggs[target].weight;

        int broken = 0;

        if(eggs[target].durability <= 0) {
            eggs[target].isBreak = true;
            broken++;
        }

        if(eggs[hand].durability <= 0) {
            eggs[hand].isBreak = true;
            broken++;
        }

        return broken;
    }

    public static int recoverEgg(int hand, int target) {
        eggs[target].durability += eggs[hand].weight;
        eggs[hand].durability += eggs[target].weight;

        int recoverNum = 0;

        if(eggs[target].isBreak) {
            eggs[target].isBreak = false;
            recoverNum++;
        }

        if(eggs[hand].isBreak) {
            eggs[hand].isBreak = false;
            recoverNum++;
        }

        return recoverNum;
    }
}
