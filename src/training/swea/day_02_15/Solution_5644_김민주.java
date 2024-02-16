package training.swea.day_02_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5644_김민주 {
	
	static class BC{
		int x;
		int y;
		int Coverage;
		int Performance;
		
		public BC(int x, int y, int coverage, int performance) {
			super();
			this.x = x;
			this.y = y;
			Coverage = coverage;
			Performance = performance;
		}

		@Override
		public String toString() {
			return "BC [x=" + x + ", y=" + y + ", Coverage=" + Coverage + ", Performance=" + Performance + "]";
		}
		
	}
	
	static class User{
		int x;
		int y;
		int chargeSum = 0;
		List<BC> bcs = new ArrayList<>();
		
		public User(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	private static int R = 10;
	private static int C = 10;
	private static int T, M, A;
	private static int[] userAmove, userBmove;
	private static int[] dr = {0, -1, 0, 1, 0};
	private static int[] dc = {0, 0, 1, 0, -1};
	private static BC[] bc; 
	private static User userA;
	private static User userB;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			bc = new BC[A];
			userA = new User(1, 1);
			userB = new User(10, 10);
			userAmove = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			userBmove = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				bc[i] = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			charge();
			for (int time = 0; time < M; time++) {
				userA.x = userA.x + dc[userAmove[time]];
				userA.y = userA.y + dr[userAmove[time]];
				userB.x = userB.x + dc[userBmove[time]];
				userB.y = userB.y + dr[userBmove[time]];
				
				charge();

			}
			
			System.out.println("#" + test_case + " " + (userA.chargeSum + userB.chargeSum));
		}
		
	}
	
	public static void charge() {
		
		// user별 충전 가능한 bc 찾기
		for (int i = 0; i < bc.length; i++) {
			checkRange(bc[i]);
		}
	
		selectBC();
		
	}
	
	public static void checkRange(BC bc) {
		int distanceA = Math.abs(userA.x - bc.x) + Math.abs(userA.y - bc.y);
		int distanceB = Math.abs(userB.x - bc.x) + Math.abs(userB.y - bc.y);
		
		if(distanceA <= bc.Coverage) userA.bcs.add(bc);
		if(distanceB <= bc.Coverage) userB.bcs.add(bc);
	}
	
	public static void selectBC() {
		BC maxA;
		BC maxB;
		
		if(userA.bcs.size() == 0 && userB.bcs.size() != 0) {
			maxB = userB.bcs.remove(0);
			for(BC bc : userB.bcs) {
				if(maxB.Performance < bc.Performance) maxB = bc;
			}
			userB.chargeSum += maxB.Performance;
			userA.bcs.clear();
			userB.bcs.clear();
		} else if(userB.bcs.size() == 0 && userA.bcs.size() != 0) {
			maxA = userA.bcs.remove(0);
			for(BC bc : userA.bcs) {
				if(maxA.Performance < bc.Performance) maxA = bc;
			}
			userA.chargeSum += maxA.Performance;
			userA.bcs.clear();
			userB.bcs.clear();
		} else if(userA.bcs.size() != 0 && userB.bcs.size() != 0) {
			maxA = userA.bcs.get(0);
			maxB = userB.bcs.get(0);
			for(BC bc : userA.bcs) {
				if(maxA.Performance < bc.Performance) {
					maxA = bc;
				}
			}
			for(BC bc : userB.bcs) {
				if(maxB.Performance < bc.Performance) {
					maxB = bc;
				}
			}
			
			userA.bcs.remove(maxA);
			userB.bcs.remove(maxB);
			
			if(maxA == maxB) {
				if(userA.bcs.size()+1 == 1 & userB.bcs.size()+1 != 1) {
					maxB = userB.bcs.get(0);
					for(BC bc : userB.bcs) {
						if(maxB.Performance < bc.Performance) {
							maxB = bc;
						}
					}
					userA.chargeSum += maxA.Performance;
					userB.chargeSum += maxB.Performance;
					userA.bcs.clear();
					userB.bcs.clear();
				} else if(userA.bcs.size()+1 != 1 & userB.bcs.size()+1 == 1) {
					maxA = userA.bcs.get(0);
					for(BC bc : userA.bcs) {
						if(maxA.Performance < bc.Performance) {
							maxA = bc;
						}
					}
					userA.chargeSum += maxA.Performance;
					userB.chargeSum += maxB.Performance;
					userA.bcs.clear();
					userB.bcs.clear();
				} else if(userA.bcs.size()+1 == 1 && userB.bcs.size()+1 == 1) {
					userA.chargeSum += maxA.Performance;
					userA.bcs.clear();
					userB.bcs.clear();
				} else {
					BC nextmaxA = userA.bcs.get(0);
					BC nextmaxB = userB.bcs.get(0);
					for(BC bc : userA.bcs) {
						if(nextmaxA.Performance < bc.Performance) {
							nextmaxA = bc;
						}
					}
					for(BC bc : userB.bcs) {
						if(nextmaxB.Performance < bc.Performance) {
							nextmaxB = bc;
						}
					}
					
					if(nextmaxB.Performance > nextmaxA.Performance) {
						userA.chargeSum += maxA.Performance;
						userB.chargeSum += nextmaxB.Performance;
						userA.bcs.clear();
						userB.bcs.clear();
					} else {
						userB.chargeSum += maxB.Performance;
						userA.chargeSum += nextmaxA.Performance;
						userA.bcs.clear();
						userB.bcs.clear();
					}
				}
			} else {
				userA.chargeSum += maxA.Performance;
				userB.chargeSum += maxB.Performance;
				userA.bcs.clear();
				userB.bcs.clear();
			}
		}
	}
}
