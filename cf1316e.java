import java.util.*;
import java.io.*;
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader r =
		new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
 
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
 
		//Read the audience.
		st = new StringTokenizer(r.readLine());
		pair[] A = new pair[N];
		for (int i = 0; i < N; i++) {
			A[i] = new pair(i, Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(A);
 
		//Read the player skill matrix.
		int[][] skill = new int[N][P];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(r.readLine());
			for (int j = 0; j < P; j++) {
				skill[i][j] = Integer.parseInt(st.nextToken());
			}
		}
 
		//Initialize dp matrix.
		long[][] dp = new long[N + 1][(1 << P)];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(dp[i], -1);
		}
 
		dp[0][0] = 0;
 
		for (int i = 1; i <= N; i++) {
			int ind = A[i - 1].idx;
			for (int m = 0; m < (1 << P); m++) {
 
				//Count the number of bits in the mask.
				int bits = 0;
				for (int j = 0; j < P; j++) {
					if ((m & (1 << j)) > 0) {
						bits++;
					}
				}
 
				int numAud = i - 1 - bits;
				//If the player is added to the audience.
				if (numAud < K) {
					if (dp[i - 1][m] != -1) {
						dp[i][m] = dp[i - 1][m] + A[i - 1].val;
					}
				} else {
					if (dp[i - 1][m] != -1) {
						dp[i][m] = dp[i - 1][m];
					}
				}
 
				//Add the player to the team.
				for (int j = 0; j < P; j++) {
					if ((m & (1 << j)) > 0 ) {
						if ((dp[i - 1][m ^ (1 << j)]) != -1) {
 
							dp[i][m] = Math.max(dp[i][m],
									dp[i - 1][m ^ (1 << j)] + skill[ind][j]);
						}
					}
				}
			}
		}
 
		//Print the answer.
		System.out.println(dp[N][(1<< P)- 1]);
	}
 
	static class pair implements Comparable<pair> {
		int idx, val;
 
		public pair(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
 
		public int compareTo(pair other) {
			return other.val - val;
		}
	}
}
