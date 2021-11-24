import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class cf839c {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
 
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++)
            nodes[i] = new Node();
 
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            nodes[a].adj.add(nodes[b]);
            nodes[b].adj.add(nodes[a]);
        }
 
        System.out.println(dfs(nodes[0], null));
    }
 
    public static double dfs(Node cur, Node last) {
        if (cur.expected != -1) {
            return cur.expected;
        }
        cur.expected = 0;
 
        int cnt = 0;
        for (Node n : cur.adj) {
            if (n == last) {
                continue;
            }
            cnt++;
            cur.expected += dfs(n, cur) + 1;
        }
        if (cnt > 0) {
            cur.expected = cur.expected / cnt;
        }
 
        return cur.expected;
    }
 
    static class Node {
        double expected = -1;
        ArrayList<Node> adj = new ArrayList<>();
    }
 
}
