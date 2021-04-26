import java.util.Scanner;
 
public class cf1374b {
    public static int moves;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            long n = sc.nextLong();
            recurse(n);
            System.out.println(moves);
            moves = 0;
        }
    }
 
    public static void recurse(long n) {
        if (n == 1) {
            //System.out.println("REACHED GOAL");
            return;
        }
        if (n == -1 || n % 3 != 0) {
            moves = -1;
            //System.out.println("CANNOT CONTINUE");
            return;
        }
        if (n % 6 == 0) {
            //Divide by 6
            //System.out.println(n + "/6 = " + (n / 6));
            moves++;
            recurse(n / 6);
        } else {
            moves = moves + 2;
            //System.out.println(n + "/3 = " + (n / 3));
            recurse(n / 3);
        }
    }
}
