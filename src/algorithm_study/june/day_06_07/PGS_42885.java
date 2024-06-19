package algorithm_study.june.day_06_07;

import java.util.Arrays;

public class PGS_42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int min = 0;
        Arrays.sort(people);
 
        for (int max = people.length - 1; max >= min; max--) {
            int weight = people[min] + people[max];

            if (weight <= limit) {
                min++;
                answer++;
            }

            if (weight > limit) {
                answer++;
            }
        }
        return answer;
    }
}
