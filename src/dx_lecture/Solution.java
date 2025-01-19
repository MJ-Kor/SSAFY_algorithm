package dx_lecture;

import java.util.Scanner;

class Solution {
	private static Scanner sc;
	private static UserSolution usersolution = new UserSolution();

	private final static int MAX_N	= 1000;
	private final static int MAX_M	= 20;

	private static int Map[][] = new int[MAX_N][MAX_N];
	private static int Pieces[][] = new int[MAX_M][MAX_M];
	private static int mSeed;

	public static class Result {
		int y, x;
	}

	private static int pseudo_rand()
	{
		mSeed = mSeed * 431345 + 2531999;
		return mSeed & 0x7FFFFFFF;
	}

	private static int run(int Ans)
	{
		int N, M, K;

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		for (int i = 0; i < N; ++i) {
			int num;
			int cnt = N / 30;
			int idx = 0;
			for (int k = 0; k < cnt; ++k) {
				num = sc.nextInt();
				for (int m = 0; m < 30; ++m) {
					Map[i][idx++] = num & 0x01;
					num = num >> 1;
				}
			}

			if (N % 30 > 0) {
				num = sc.nextInt();
				for (int m = 0; m < (N % 30); ++m) {
					Map[i][idx++] = num & 0x01;
					num = num >> 1;
				}
			}
		}

		usersolution.init(N, M, Map);

		for (int t = 0; t < K; ++t) {
			mSeed = sc.nextInt();
			int num = sc.nextInt();
			int sy = sc.nextInt();
			int sx = sc.nextInt();

			for (int i = 0; i < M; ++i)
				for (int k = 0; k < M; ++k)
					Pieces[i][k] = 0;

			int y = pseudo_rand() % M;
			int x = pseudo_rand() % M;
			Pieces[y][x] = 9;
			for (int i = 1; i < num; ++i) {
				y = pseudo_rand() % M;
				x = pseudo_rand() % M;
				Pieces[y][x] = 1;
			}

			Result answer = usersolution.findTreasureChest(Pieces);
			if ((answer.y != sy) || (answer.x != sx))
				Ans = 0;
		}

		return Ans;
	}

	public static void main(String[] args) throws Exception {

		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		sc = new Scanner(System.in);

		int TC = sc.nextInt();
		int Ans = sc.nextInt();
		for (int testcase = 1; testcase <= TC; ++testcase) {
            System.out.println("#" + testcase + " " + run(Ans));
		}

		sc.close();
	}
}
