import java.io.*;
import java.util.*;

public class cf510c {
    public static int N;
    public static ArrayList<Integer>[] adj;
    public static int[] inDegree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[26];
        inDegree = new int[26];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        Queue<Integer> q = new LinkedList<>();

        //@todo Input
        char[][] input = new char[N][];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine().toCharArray();
        }

        //@todo Process
        for (int i = 1; i < N; i++) {
            int dif = 0;
            int minLen = Math.min(input[i].length, input[i - 1].length);
            // Shift to the different character
            while (dif < minLen && input[i][dif] == input[i - 1][dif]) {
                dif++;
            }

            if (dif == minLen) {
                // the next one must be longer than the previous one.
                if (input[i].length < input[i - 1].length) {
                    System.out.println("Impossible");
                    return;
                } else {
                    continue;
                }
            }
            // add an edge.
            int to = input[i][dif] - 'a';
            int from = input[i - 1][dif] - 'a';
            inDegree[to]++;
            adj[from].add(to);

        }
        // initiate topological sort.
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }


        String ans = "";
        while (!q.isEmpty()) {
            int cur = q.poll();
            ans += (char) (cur + 'a');
            for (int i = 0; i < adj[cur].size(); i++) {
                int to = adj[cur].get(i);
                inDegree[to]--;
                if (inDegree[to] == 0) {
                    q.add(to);
                }
            }
        }
        if (ans.length() < 26) {
            System.out.println("Impossible");
        } else {
            System.out.println(ans);
        }
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
