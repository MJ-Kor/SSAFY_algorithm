package a형대비;

import java.util.Arrays;
import java.util.Iterator;

// 완탐
// nFr = n^r
public class SubsetTest {
	static int[] p = {1,2,3,4,5,6,7};
	static int N;
	static int R;
	static int count;
	static int[] nums;
	static boolean[] visited;
	
	public static void main(String[] args) {
		N = p.length;
		
		count = 0;
		
		// 배열은 2가지가 있다
		// nums = {1,2,3} 이후에 nums = {1 ,2, 3 ,4} 하면 오류임
		// -> 전체 재할당이 안됨, 참조 타입임, 얕은 복사임, 따라서 예전 값하고 비교하려면 깊은 복사
		visited = new boolean[N];	// 기본 타입은 0에 관련된걸로 초기화 => 가끔 깊은 복사 System.arraycopy
		//Arrays.fill(nums,  -1); 	// nums의 모든 원소를 -1로 초기화
		
		perm(0, 0, 1);
		System.out.println(count);
	}
	
	// dfs는 recursion에서 출발 -> base condition(기저 조건)이 상당히 중요
	// recursion
	//-> for while(지역 변수를 많이 사용해야함) bc 
	//-> dfs(depth) depth를 구하는 것이 핵심 (반복문이 간단해짐), 로직은 동일하나 데이터만 바뀔 때 사용함
	// dfs -> fifo call stack(메소드를 호출하면) 자동으로 지역 변수가 생기는 역할, 그러나 깊이가 깊어지면 터진다
	// dfs -> 빠 
	static void perm(int cnt, int tot, int mul) {
		if(cnt == N) {
			// 로직
			count++;
			for (int i = 0; i < N; i++) {
				if(visited[i]) {
					System.out.print(p[i] + " ");
				}
			}
			System.out.println();
			System.out.println(tot);
			System.out.println(mul);
			System.out.println("------");
			
			return;
		}
		
			visited[cnt] = true;		// comb는 생략 가능
			perm(cnt + 1, tot + p[cnt], mul * p[cnt]); // -> 선택한 원소가 합해져서 넘어감		// List면 remove를 시켜야함
			visited[cnt] = false;
			perm(cnt + 1, tot, mul);

	}
	
	

}

// swea 보호필름
// A로 염색 go
// B로 염색 go
// 둘다 염색하지마 go
// 3의 n승

