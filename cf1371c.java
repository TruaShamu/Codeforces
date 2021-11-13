import java.io.IOException;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long t, a, b, n, m, k;
        t = sc.nextLong();
        for  (int i=0; i< t; i++) {
            a = sc.nextLong();
            b = sc.nextLong();
            n = sc.nextLong();
            m = sc.nextLong();
            if (a > b) {
                k = a;
                a = b;
                b = k;
            }
            if (a < m) {
                System.out.println("No");
                continue;
            }
            if (a + b < n + m) {
                System.out.println("No");
                continue;
            }
            System.out.println("Yes");
        }
    }
}
