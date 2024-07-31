package algorithm_study.july.day_07_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_5904 {
        static List<Integer> sequenceLength = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sequenceLength.add(3);
		int k = 0;
		int lengthOfKth = 3;
		while(true) {
			if(lengthOfKth >= N) break;
			k++;
			int middleSize = (3+k);
			lengthOfKth = 2*lengthOfKth + middleSize;
			sequenceLength.add(lengthOfKth);
		}
		System.out.println(findNthWord(k,N));
	}

	public static String findNthWord(int depth, int X) {
		if(depth == 0) {
			if(X == 1) return "m";
			return "o";
		}
		int middleSize = depth+3;
		if(X < sequenceLength.get(depth-1)) {
			return findNthWord(depth-1,X);
		}else if(sequenceLength.get(depth-1) + middleSize < X) {
			return findNthWord(depth-1,X-sequenceLength.get(depth-1)-middleSize);
		}else {
			if(sequenceLength.get(depth-1) + 1 == X) return findNthWord(0,1);
			return findNthWord(0,2);
		}
	}
}
