package month_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class mAlgo3_광주_04반_김민주 {
	static class Coord implements Comparable<Coord>{
		int x1, x2;

		public Coord(int x1, int x2) {
			super();
			
			if(x1 > x2) {
				this.x1 = x2;
				this.x2 = x1;
			}else {
				this.x1 = x1;
				this.x2 = x2;
			}
		}
		
		@Override
		public int compareTo(Coord o) {
			return Integer.compare(this.x1, o.x1);
		}

		@Override
		public String toString() {
			return "Coord [x1=" + x1 + ", x2=" + x2 + "]";
		}
		
		
	}
	static int N, x, y;
	static List<Integer> coord = new ArrayList<>();
	static List<int[]> coords= new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			if(x < 0 && y < 0) continue;
			if(x > 0 && y < 0) {
				coord.add(x);
				if(coord.size() == 2) {
					int x1 = coord.get(0);
					int x2 = coord.get(1);
					coords.add(new int[] {x1, x2});
					coord = new ArrayList<>();
				}
			}	
		}
		
		Object[] Coorda = coords.toArray(); 
		Arrays.sort(Coorda);
		
		for (int i = 0; i < coords.size(); i++) {
			System.out.println(Coorda[i]);
		}
		
	}

}
