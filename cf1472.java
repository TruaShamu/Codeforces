import java.io.*;
import java.util.*;
 
// Codeforces 1472 G
public class MovingCapital {
	public static int N;
	public static int M;
	public static ArrayList<Integer>[] adj;
	public static int[] dist;
	public static boolean[] visited;
	public static int[] dp;
	public static void main(String[] args) {
		Kattio io = new Kattio();
		int tc = io.nextInt();
		while (tc-- > 0) {
			N = io.nextInt();
			M = io.nextInt();
			adj = new ArrayList[N];
			dist = new int[N];
 
			visited = new boolean[N];
			dp = new int[N];
			for (int i=0; i< N; i++) {
				adj[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				int a = io.nextInt() - 1;
				int b = io.nextInt() - 1;
				adj[a].add(b);
			}
 
			Arrays.fill(dist, -1);
			dist[0] = 0;
			calcDist();
			dfs(0);
			for (int i = 0; i < N; i++) {
				System.out.print(dp[i] + " ");
			}
			System.out.println();
		}
 
	}
 
	public static void calcDist() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int next : adj[cur]) {
				if (dist[next] == -1) {
					dist[next] = dist[cur] + 1;
					queue.add(next);
				}
			}
		}
 
	}
 
	public static void dfs(int u) {
		visited[u] = true;
		dp[u] = dist[u];
		for (int v : adj[u]) {
			if (!visited[v] && dist[u] < dist[v]) {
				dfs(v);
			}
 
			if (dist[u] < dist[v]) {
				// away from city.
				dp[u] = Math.min(dp[u], dp[v]);
			} else {
				// go towards city --> it can't go up twice, so it's just limited to the depth of the next node.
				dp[u] = Math.min(dp[u], dist[v]);
			}
		}
	}
 
 
	static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;
 
		// standard input
		public Kattio() { this(System.in, System.out); }
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
			} catch (Exception e) { }
			return null;
		}
 
		public int nextInt() { return Integer.parseInt(next()); }
		public double nextDouble() { return Double.parseDouble(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
