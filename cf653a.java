import java.util.Scanner;
 
public class cf653a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        for (int i = 0; i < testcases; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long n = sc.nextLong();
            long j = (long) (n - y) / (x);
            long answer = y + (j * x);
            System.out.println(answer);
        }
    }
}
