package algorithm_study.day_03_22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
}
class Dic{
	int sec;
	String dic;
	Dic(int sec, String dic){
		this.sec=sec;
		this.dic=dic;
	}
}

class Snake{
	List<Pair> list;
	int dic;
	int cnt;
	
	Snake(List<Pair> list, int dic, int cnt){
		this.list= list;
		this.dic= dic;
		this.cnt = cnt;
	}
}
public class BOJ_3190 {
	static int N,K,L;
	static int[][] map;
	static Queue<Dic> changeDic;
	static Snake snake;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]=1;
		}
		map[0][0]=2;
		
		L = Integer.parseInt(br.readLine());
		changeDic = new LinkedList<>();
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			changeDic.add(new Dic(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		
		List<Pair> list = new ArrayList<>();
		list.add(new Pair(0,0));
		snake = new Snake(list, 1, 0);
		
		move();
		System.out.println(snake.cnt);
	}

	static void move() {
		while(true) {
			int x = snake.list.get(snake.list.size()-1).x + dx[snake.dic];
			int y = snake.list.get(snake.list.size()-1).y + dy[snake.dic];
			
			snake.cnt++;
			if(0<=x&&x<N&&0<=y&&y<N) {
				if(map[x][y]==1) {
					snake.list.add(new Pair(x,y));
					map[x][y]=2;
				}else if(map[x][y]==0){
					Pair p =snake.list.remove(0);
					map[p.x][p.y]=0;
					snake.list.add(new Pair(x,y));
					map[x][y]=2;
				}else if(map[x][y]==2) {
					break;
				}
				
				if(!changeDic.isEmpty()&&snake.cnt==changeDic.peek().sec) {
					String dic =changeDic.poll().dic;

					if(dic.equals("L")) {
						snake.dic-=1;
						if(snake.dic==-1) {
							snake.dic=3;
						}
					}else if(dic.equals("D")){
						snake.dic+=1;
						if(snake.dic==4) {
							snake.dic=0;
						}
					}
				}
			}else {
				break;
			}
		}
	}
}
