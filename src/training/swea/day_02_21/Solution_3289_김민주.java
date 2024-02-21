package training.swea.day_02_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_김민주 {

	private static int T, n, m, operation, a, b;
	private static int[] setTree;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			setTree = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				setTree[i] = i;
			}
			
			System.out.print("#" + test_case + " ");
			// 0: union
			// 1: find_set으로 두 원소가 같은 집합에 포함되어 있는지 확인
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				operation = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if(operation == 0) union(a, b);
				else if(operation == 1) {
					if(find_set(a) == find_set(b)) System.out.print(1);
					else System.out.print(0);
				}
			}
			System.out.println();
		}
	}

	public static void union(int x, int y){
		if(find_set(x) == find_set(y)) return;
		setTree[find_set(y)] = find_set(x);
	}
	
	// find_set with path compression
	public static int find_set(int e) {
		if (e == setTree[e]) return e;
		else return setTree[e] = find_set(setTree[e]);
	}
	
}
