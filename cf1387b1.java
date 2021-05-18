import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class cf1387b1 {
    public static ArrayList<Integer>[] adj;
    public static int[] pos;
    public static int ans;
    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        int N = r.nextInt();
        adj = new ArrayList[N];

        ans = 0;
        for (int i=0; i< N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i=0; i< N-1; i++) {
            int a = r.nextInt()-1;
            int b = r.nextInt()-1;
            adj[a].add(b);
            adj[b].add(a);
        }
        pos = new int[N];
        for (int i=0; i< N; i++) {
            pos[i] = i;
        }

        dfs(0, -1);
        System.out.println(ans);
        for (int i = 0; i < N; i++) {
            System.out.print(pos[i] + 1 + " ");
        }
    }

    public static void dfs(int cur, int par) {
        for (int next : adj[cur]) {
            if (next == par) {
                continue;
            }
            dfs(next, cur);

            //Switch with neighbor node.
            if (pos[next] == next) {
                ans+= 2;
                int temp = pos[cur];
                pos[cur] = pos[next];
                pos[next] = temp;
            }
        }

        if (cur == 0 && pos[cur]==0) {
            int next = adj[0].get(0);
            ans += 2;
            int temp = pos[cur];
            pos[cur] = pos[next];
            pos[next] = temp;
        }
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}
