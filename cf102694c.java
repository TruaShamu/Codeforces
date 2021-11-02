import java.io.*;
import java.util.*;
public class slothNaptime2 {
	public static final int MAXN = (int) 3e5 + 5;
	public static final int LOGN = (int) (Math.log(MAXN) / Math.log(2)) + 1;
	public static ArrayList<Integer>[] adj = new ArrayList[MAXN];
	// anc[i][j] is the 2^j-th parent of i.
	public static int[][] anc = new int[MAXN][LOGN];
	public static int[] depth = new int[MAXN];

	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
		int N = io.nextInt();
		for (int i = 0; i < MAXN; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			int a = io.nextInt() - 1;
			int b = io.nextInt() - 1;
			adj[a].add(b);
			adj[b].add(a);
		}

		dfs(0, 0);

		int Q = io.nextInt();
		for (int i = 1; i <= Q; i++) {
			int start = io.nextInt() - 1;
			int end = io.nextInt() - 1;
			int energy = io.nextInt();
			int lca = LCA(start, end);
			int moveUpLen = depth[start] - depth[lca];
			int moveDownLen = depth[end] - depth[lca];
			int result;
			if (energy <= moveUpLen) {
				// moves up from start towards the lca.
				result = jump(start, energy);
			} else if (energy <= moveUpLen + moveDownLen) {
				// moves up from start to the lca, then goes down towards end.
				result = jump(end, moveDownLen - (energy - moveUpLen));
			} else {
				// reaches the end.
				result = end;
			}
			result++;
			System.out.println(result);
		}
	}

	public static void dfs(int node, int par) {
		anc[node][0] = par;
		depth[node] = depth[anc[node][0]] + 1;

		// initializes binary jumping for the current node.
		for (int lvl = 1; lvl < LOGN; lvl++) {
			anc[node][lvl] = anc[anc[node][lvl - 1]][lvl - 1];
		}
		for (int next : adj[node]) {
			if (next != par) {
				dfs(next, node);
			}
		}
	}

	// jump(i, j) returns jth ancestor of node i.
	public static int jump(int node, int level) {
		for (int i = 0; i < LOGN; i++) {
			if ((level & (1 << i)) > 0) {
				node = anc[node][i];
			}
		}
		return (node > 0) ? node : 1;
	}

	// lca(i, j) returns least common ancestor of nodes i and j.
	public static int LCA(int a, int b) {
		if (depth[a] < depth[b]) {
			int tempA = a;
			a = b;
			b = tempA;
		}

		a = jump(a, depth[a] - depth[b]);
		if (a == b) {
			return a;
		}
		for (int i = LOGN - 1; i >= 0; i--) {
			int newA = anc[a][i];
			int newB = anc[b][i];
			if (newA != newB) {
				a = newA;
				b = newB;
			}
		}
		return anc[a][0];
	}

	static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;

		// standard input
		public Kattio() {
			this(System.in, System.out);
		}

		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}

		// USACO-style file input
		public Kattio(String problemName) throws IOException {
			super(new FileWriter(problemName + ".out"));
			r = new BufferedReader(new FileReader(problemName + ".in"));
		}

		// returns null if no more input
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) {
			}
			return null;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
