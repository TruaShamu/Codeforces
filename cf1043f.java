import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class cf1043f {
    public static int MAX = (int) 3e5 + 3;
    public static int[] gcd;
    public static int[] dist;
    public static Queue<Integer> Q = new LinkedList<>();
    public static ArrayList<Integer>[] div;
    public static int[] cnt;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
 
        gcd = new int[MAX];
        for (int i = 2; i < MAX; ++i) {
            if (gcd[i] != 0) {
                continue;
            }
 
            for (int j = i; j < MAX; j += i) {
                gcd[j] = i;
            }
        }
 
        div = new ArrayList[MAX];
        for (int i=0; i< MAX; i++) {
            div[i] = new ArrayList<>();
        }
        for(int i = 1; i < MAX; ++i) {
            for (int j = i; j < MAX; j += i) {
                div[j].add(i);
            }
        }
 
        dist = new int[MAX];
        for(int i = 1; i < MAX; ++i) {
            dist[i] = -1;
        }
 
        cnt = new int[MAX];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; ++i){
            int a = Integer.parseInt(st.nextToken());
            //System.out.println(a);
            a = base(a);
 
            if(dist[a] != -1) {
                continue;
            }
 
            dist[a] = 1;
            Q.add(a);
 
            for(int v: div[a]) {
                cnt[v]++;
            }
        }
 
        while(!Q.isEmpty()){
            int u = Q.poll();
            getEdges(u, dist[u] + 1);
        }
 
        System.out.println(dist[1]);
 
 
    }
    public static void  getEdges(int u, int d){
        ArrayList<Integer> cur = new ArrayList<>();
        int[] val;
 
        while(u > 1){
            cur.add(gcd[u]);
            u /= gcd[u];
        }
 
        for(int v: cur)
            u *= v;
 
        int T = 1 << (int)cur.size();
        val=  new int[T];
 
        for(int i = 0; i < T; ++i){
            val[i] = u;
            for(int j = 0; j < (int)cur.size(); ++j)
                if((i & (1 << j))>0)
                    val[i] /= cur.get(j);
        }
 
        for(int i = 0; i < T; ++i){
            int s = 0;
            for(int j = i; true; j = (j - 1) & i){
                if((Integer.bitCount(i ^ j) & 1) > 0)
                    s -= cnt[val[j]];
                else
                    s += cnt[val[j]];
 
                if(j == 0)
                    break;
            }
 
            assert(s >= 0);
            if(s>0 && dist[val[i]] == -1){
                dist[val[i]] = d;
                Q.add(val[i]);
            }
        }
    }
 
    public static  int base(int a){
        int ret = 1;
        while(a > 1){
            if(ret%gcd[a] != 0)
                ret *= gcd[a];
            a /= gcd[a];
        }
 
        return ret;
    }
 
}
