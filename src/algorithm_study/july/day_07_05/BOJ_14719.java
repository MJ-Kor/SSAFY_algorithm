package algorithm_study.july.day_07_05;

import java.io.*;
import java.util.*;

public class BOJ_14719 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] arr = new int[W];

		int max = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}

		int height = 0;
		int tmp = 0;
		int sum = 0;

		for (int i = 0; i < W; i++) {
			if(height > arr[i]) tmp += height-arr[i];
			else {
				sum += tmp;
				height = arr[i];
				tmp = 0;
			}
		}

		height = 0;
		tmp = 0;

		for (int i = W-1; i >= 0; i--) {
			if(height > arr[i]) tmp += height-arr[i];
			else {
				sum += tmp;
				height = arr[i];
				tmp = 0;
			}
			if(arr[i]==max) break;
		}

		System.out.println(sum);

	}

}
