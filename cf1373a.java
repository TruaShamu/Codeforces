import java.util.Scanner;

public class cf1373a {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long a = in.nextLong();
            long b = in.nextLong();
            long c = in.nextLong();
            if (a >= c) {
                System.out.println(-1 + " " + b);
            } else if (a * b <= c) {
                System.out.println(1 + " " + -1);
            } else {
                System.out.println(1 + " " + b);
            }

        }
    }
}
