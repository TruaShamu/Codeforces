import java.io.IOException;
import java.util.Scanner;
 
/*
Boboniu Likes To Play With Balls
 */
public class cf1395 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
 
            if (calc(r, g, b, w)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
 
 
    }
 
    public static boolean calc(int r, int g, int b, int w) {
        int odd = r % 2 + g % 2 + b % 2 + w % 2;
        //Calculate number of odd
        if (odd > 2) {
            if (r == 0 || g == 0 || b == 0) return false;
            return true;
        } else if (odd == 2)
            return false;
        else {
            return true;
        }
    }
}
