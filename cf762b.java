import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class cf762 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        mouse[] mice = new mouse[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int type = st.nextToken().equals("USB") ? 0 : 1;
            mice[i] = new mouse(cost, type);
        }
 
        Arrays.sort(mice);
 
        long count = 0, ans = 0;
        for (int i = 0; i < m; i++) {
            if (mice[i].type == 0) { //usb
                if (a + c > 0) {
                    count++;
                    ans += mice[i].cost;
                }
                if (a > 0) {
                    a--;
                } else if (c > 0) {
                    c--;
                }
            } else { //ps2
                if (b + c > 0) {
                    count++;
                    ans += mice[i].cost;
                }
                if (b > 0) {
                    b--;
                } else if (c > 0) {
                    c--;
                }
            }
        }
 
        System.out.println(count + " "+ ans);
    }
}
 
class mouse implements Comparable<mouse> {
 
    public int cost, type;
 
    public mouse(int cost, int type) {
        this.cost = cost;
        this.type = type;
    }
 
    public int compareTo(mouse other) {
        return this.cost - other.cost;
    }
}
