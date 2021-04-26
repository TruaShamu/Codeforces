import java.util.Scanner;
 
public class cf492e {
    public static int[] Y, K;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int dx = sc.nextInt() % n;
        int dy = sc.nextInt() % n;
        Y = new int[n];
        K = new int[n];
        for (int i = 0, sx = 0, sy = 0; i < n; i++) {
            K[i] = 0;
            Y[sx] = sy;
            sx += dx;
            if (sx >= n) {
                sx -= n;
            }
            sy += dy;
            if (sy >= n) {
                sy -= n;
            }
        }
        int ans = 0, l = -1, r = -1;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int t = (y - Y[x] + n) % n;
            K[t]++;
            if (K[t] > ans) {
                ans = K[t];
                l = x;
                r = y;
            }
        }
        System.out.print("" + l + " " + r);
    }
}
 
