package training.boj.day_03_27;
//package training.boj.day_03_27;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main_1194_김민주_반례O {
//	
//	private static class QueueData{
//		int r, c; // 좌표
//		int breadth; // 이동 거리
//		int nowVisit; // 값을 저장할 visit 배열 위치 (0 ~ 6)
//		Map<Character, Boolean> isKey; // 키가 있는지 여부, (a, b, c, d, e, f)
//
//		public QueueData(int r, int c, int breadth, int nowVisit, Map<Character, Boolean> isKey) {
//			super();
//			this.r = r;
//			this.c = c;
//			this.breadth = breadth;
//			this.nowVisit = nowVisit;
//			this.isKey = isKey;
//		}
//		
//		@Override
//		public String toString() {
//			return "QueueData [r=" + r + ", c=" + c + ", breadth=" + breadth + ", nowVisit=" + nowVisit + ", isKey="
//					+ isKey + "]";
//		}
//	}
//	
//	private static int[] dr = {-1, 0, 1, 0};
//	private static int[] dc = {0, 1, 0, -1};
//	private static String doors = "ABCDEF";
//	private static String keys = "abcdef";
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		System.out.println(1<<6);
//		int R = Integer.parseInt(st.nextToken());
//		int C = Integer.parseInt(st.nextToken());
//		
//		char[][] map = new char[R][C];
//		int sr = -1;
//		int sc = -1;
//		
//		for (int r = 0; r < R; r++) {
//			String row = br.readLine();
//			for (int c = 0; c < C; c++) {
//				char value = row.charAt(c);
//				map[r][c] = value;
//				if(value == '0') {
//					sr = r;
//					sc = c;
//					map[r][c] = '.';
//				}
//			}
//		}
//		
//		bfs(map, sr, sc, R, C);
//	}
//
//	private static void bfs(char[][] map, int sr, int sc, int R, int C) {
////		System.out.println("sr: " + sr + "sc: " + sc);
//		int[][][] visited = new int[7][R][C];
//		Queue<QueueData> queue = new ArrayDeque<>();
//		//Map of가 JAVA 9부터 지원
//		Map<Character, Boolean> initKey = Map.of(
//				'a', false,
//				'b', false,
//				'c', false,
//				'd', false,
//				'e', false,
//				'f', false
//				);
//		
//		visited[0][sr][sc] = 1;
//		queue.offer(new QueueData(sr, sc, 0, 0, initKey));
//		
//		while(!queue.isEmpty()) {
//			QueueData curr = queue.poll();
//			System.out.println(curr);
//			if(map[curr.r][curr.c] == '1') {
//				System.out.println(curr.breadth);
//				System.exit(0);
//			}
//			for (int i = 0; i < 4; i++) {
//				int nr = curr.r + dr[i];
//				int nc = curr.c + dc[i];
//				if(indexValid(nr, nc, R, C) && visited[curr.nowVisit][nr][nc] == 0 && map[nr][nc] != '#') {
//					System.out.println(map[nr][nc]);
//					if(doors.contains(""+map[nr][nc])) {
////						System.out.println("1");
////						System.out.println((char)(map[nr][nc]+32));
////						System.out.println(curr.isKey.get((char)(map[nr][nc]+32)));
//						if(curr.isKey.get((char)(map[nr][nc]+32))) {
//							int nb = curr.breadth + 1;
//							Map<Character, Boolean> nik = new HashMap<Character, Boolean>(curr.isKey);
//							visited[curr.nowVisit][nr][nc] = nb;
//							QueueData nextData = new QueueData(nr, nc, nb, curr.nowVisit, nik);
//							queue.offer(nextData);
//						}
//					} else if(keys.contains(""+map[nr][nc])) {
////						System.out.println("2");
//						if(curr.isKey.get(map[nr][nc])) {
//							int nb = curr.breadth + 1;
//							Map<Character, Boolean> nik = new HashMap<Character, Boolean>(curr.isKey);
//							visited[curr.nowVisit][nr][nc] = nb;
//							QueueData nextData = new QueueData(nr, nc, nb, curr.nowVisit, nik);
//							queue.offer(nextData);
//						} else {
//							int nv = curr.nowVisit + 1;
//							int nb = curr.breadth + 1;
//							Map<Character, Boolean> nik = new HashMap<Character, Boolean>(curr.isKey);
//							nik.put(map[nr][nc], true);
//							visited[nv][nr][nc] = nb;
//							QueueData nextData = new QueueData(nr, nc, nb, nv, nik);
//							queue.offer(nextData);
//						}
//					} else {
////						System.out.println("3");
//						int nb = curr.breadth + 1;
//						Map<Character, Boolean> nik = new HashMap<Character, Boolean>(curr.isKey);
//						visited[curr.nowVisit][nr][nc] = nb;
//						QueueData nextData = new QueueData(nr, nc, nb, curr.nowVisit, nik);
//						queue.offer(nextData);
//					}
//				}
//			}
//			
//		}
//		
//		System.out.println(-1);
//	}
//	
//	private static boolean indexValid(int nr, int nc, int R, int C) {
//		if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
//			return true;
//		}
//		return false;
//	}
//
//}
