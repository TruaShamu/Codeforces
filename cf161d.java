// CF 161 D -- DISTANCE IN TREE
 
import java.io.*;
import java.util.*;
 
public class Main {
    static int N, K;
    static ArrayList<Integer> adj[];
    static int dp[][]; // DP[i][j] = number of nodes of distance j from node i.
    static long ans = 0;
 
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        N = io.nextInt();
        K = io.nextInt();
        dp = new int[N + 1][K + 1];
        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            int a = io.nextInt();
            int b = io.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
 
        dfs(1, 0);
        System.out.println(ans);
 
    }
 
    static void dfs(int cur, int par) {
        dp[cur][0] = 1; // The current node's distance from itself fis 0.
        for (int next : adj[cur]) {
            if (next != par) {
                // Visit children.
                dfs(next, cur);
                for (int i = 0; i < K; i++) {
                    // Update the answer.
                    ans += dp[cur][i] * dp[next][K - 1 - i];
                }
 
                // Add dp from the children of the node.
                for (int i = 1; i <= K; i++) {
                    dp[cur][i] += dp[next][i - 1];
                }
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
}
