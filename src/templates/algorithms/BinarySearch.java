package templates.algorithms;

import java.io.IOException;
import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr = {3, 6, 4, 5, 8, 1, 9, 2, 7};
		Arrays.sort(arr);
		// {1, 2, 3, 4, 5, 6, 7, 8, 9}
		
		int find = 9;
		
		long beforeTime = System.currentTimeMillis();
//		int idx = recursionBinarySearch(find, 0, 4, 8, arr);
		int idx = recursionBinarySearch(find, 0, 8, arr);
		long afterTime = System.currentTimeMillis();
		System.out.println("재귀 함수를 사용한 이분 탐색" + idx);
		System.out.println("찾으려는 수: " + find + ", 위치: " + idx);
//		System.out.println("걸린 시간: " + afterTime + "\n" + beforeTime + "ms");

	}

	
//	private static int recursionBinarySearch(int value, int start, int mid, int end, int[] arr) {
//		
//		if(arr[mid] == value) return mid;
//		
//		if(start == end) return -1;
//		
//		if(arr[mid] < value) {
//			int nStart = mid + 1;
//			int nMid = ((mid + 1) + end) / 2;
//			return recursionBinarySearch(value, nStart, nMid, end, arr);
//		}
//		else {
//			int nMid = (start + mid) / 2;
//			int nEnd = mid - 1;
//			return recursionBinarySearch(value, start, nMid, nEnd, arr);
//		}
//	}

	private static int recursionBinarySearch(int value, int start, int end, int[] arr) {
		
		if (start > end) return -1;
		
		int mid = (start / end) / 2;
		
		if (arr[mid] == value) return mid;
		
		if(arr[mid] < value) {
			int nStart = mid + 1;
			return recursionBinarySearch(value, nStart, end, arr);
		}
		else {
			int nEnd = mid - 1;
			return recursionBinarySearch(value, start, nEnd, arr);
		}
	}
	
}
