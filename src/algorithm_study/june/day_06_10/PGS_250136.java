package algorithm_study.june.day_06_10;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Drill {
	int r, c;
	
	public Drill(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class PGS_250136 {
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int R, C;
	static int[] oilCol;
	
	static int[][] land = {{1, 0, 1, 0, 1, 1},
	                       {1, 0, 1, 0, 0, 0},
	                       {1, 0, 1, 0, 0, 1},
	                       {1, 0, 0, 1, 0, 0},
	                       {1, 0, 0, 1, 0, 1},
	                       {1, 0, 0, 0, 0, 0},
	                       {1, 1, 1, 1, 1, 1}};
	
    static int solution(int[][] land) {
    	C = land[0].length;
    	R = land.length;
    	oilCol = new int[C];
    	int answer = 0;
    	boolean[][] visited = new boolean[R][C];
    	
    	for (int r = 0; r < R; r++) {
	    	for(int c = 0; c < C; c++) {
	    		if(land[r][c] == 0 || visited[r][c]) continue;
	    		bfs(land, visited, r, c);
	    	}
		}
    	
    	answer = Arrays.stream(oilCol).max().getAsInt();
        return answer;
    }
    
    static void bfs(int[][] land, boolean[][] visited, int r, int c) {
    	int oil = 0;
    	Set<Integer> oilColPos = new HashSet<>();
    	Queue<Drill> queue = new ArrayDeque<>();
    	queue.offer(new Drill(r, c));
    	visited[r][c] = true;
    	
    	while(!queue.isEmpty()) {
    		Drill curr = queue.poll();
    		oil += 1;
    		oilColPos.add(curr.c);
    		for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && land[nr][nc] == 1 && !visited[nr][nc]) {
					queue.offer(new Drill(nr, nc));
					visited[nr][nc] = true;
				}
			}
    	}

    	for(int col : oilColPos) {
    		oilCol[col] += oil;
    	}
    }
    
    
    public static void main(String[] args) {
    	System.out.println(solution(land));
    }
}
