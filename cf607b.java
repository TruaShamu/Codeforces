import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class cf607b {
    public static int maxn=505;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
 
        //Read input
        int[] a = new int[maxn];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
 
        int[][] d = new int[maxn][maxn];
 
        for (int len = 1; len <= n; len++) {
            for (int beg = 0, end = len - 1; end < n; beg++, end++) {
                if (len == 1) {
                    d[beg][end] = 1;
                } else {
                    d[beg][end] = 1 + d[beg + 1][end];
                    if (a[beg] == a[beg + 1]) {
                        d[beg][end] = Integer.min(1 + d[beg + 2][end], d[beg][end]);
                    }
                    for (int match = beg + 2; match <= end; match++) {
                        if (a[beg] == a[match]) {
                            d[beg][end] = Integer.min(d[beg + 1][match - 1] + d[match + 1][end], d[beg][end]);
                        }
                    }
                }
            }
        }
 
        System.out.println(d[0][n-1]);
    }
}
