package algorithm_study.june.day_06_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Person {
	int s, t;
	public Person(int s, int t) {
		this.s = s;
		this.t = t;
	}
}

class Solution {
	
	List<Person>[] typeReq;
	int[][] waitingTime;
	int K, N;
	
	public int solution(int k, int n, int[][] reqs) {
		
		makeList(k, reqs);
		
		waitingTime = new int[k][n - k + 2];
		K = k;
		N = n;
        for (int i = 0; i < k; i++)
            for (int j = 1; j < n - k + 2; j++)
                waitingTime[i][j] = calTime(i, j);
        return calMin();

	}

	public void makeList(int k, int[][] reqs) {
		typeReq = new List[k];
		for (int i = 0; i < k; i++) {
			typeReq[i] = new ArrayList<>();
		}
		for (int i = 0; i < reqs.length; i++) {
			int[] request = reqs[i];
			typeReq[request[2] - 1].add(new Person(request[0], request[1]));
		}
	}
	
	public int calMin() {
		int remain = N - K;
        int[] mentorCnt = new int[K];
        Arrays.fill(mentorCnt, 1);
        while(remain-- > 0) {
            int maxDiff = 0;
            int maxIndex = 0;
            for (int i = 0; i < K; i++) {
                if (mentorCnt[i] == N - K + 1) continue;
                int diff = waitingTime[i][mentorCnt[i]] - waitingTime[i][mentorCnt[i] + 1];
                if (maxDiff < diff) {
                    maxDiff = diff;
                    maxIndex = i;
                }
            }
            mentorCnt[maxIndex]++;
        }
        int sum = 0;
        for (int i = 0; i < K; i++)
            sum += waitingTime[i][mentorCnt[i]];
        return sum;
	}

	public int calTime(int k, int cnt) {
		int result = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < cnt; i++) q.add(0);
        for (Person req : typeReq[k]) {
            Integer curr = q.poll();
            if (curr <= req.s)
                q.add(req.s + req.t);
            else {
                result += curr - req.s;
                q.add(curr + req.t);
            }
        }
        return result;
	}

}

public class PGS_214288 {

	public static void main(String[] args) {
		
	}

}
