import java.io.*;
import java.util.*;
 
public class cfkGood {
 
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int N = io.nextInt();
        int K = io.nextInt();
 
        int[] A = new int[N];
        int difVal = 0; // Number of different values in the window.
        int left = 0;
 
        int maxLen = 0;
        int maxL = 0;
        int maxR = 0;
 
 
        for (int i = 0; i < N; i++) {
            A[i] = io.nextInt();
        }
        int max = Arrays.stream(A).max().getAsInt() + 1;
        int[] freq = new int[max]; // Frequency of each number in the window.
 
        for (int i =0; i< N; i++) {
            int x = A[i];
            // Increment the frequency of the number.
            if (freq[x] == 0) {
                freq[x] = 1;
                difVal++;
            } else {
                freq[x]++;
            }
 
            // If the window isn't valid, shift the left bound rightwards.
            while (difVal > K) {
                freq[A[left]]--;
                if (freq[A[left]] == 0) {
                    difVal--;
                }
                left++;
            }
 
            // Update the window length.
            int curLen = i - left + 1;
            if (curLen > maxLen) {
                maxLen = curLen;
                maxL = left;
                maxR = i;
            }
        }
 
        System.out.println((maxL + 1) + " " + (maxR + 1));
 
 
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
