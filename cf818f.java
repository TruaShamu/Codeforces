import java.util.Scanner;
 
public class cf818f {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int graphs = sc.nextInt();
        for (int i = 0; i < graphs; i++) {
            long n = sc.nextLong();
            long x = (int) Math.floor((-1 + Math.sqrt(1 + 8 * n)) / 2.0);
            if (n - x - 1 < x * (x - 1) / 2 + 1) {
                System.out.println(n - x + x * (x - 1) / 2);
            } else {
                System.out.println(2 * (n - x - 1));
            }
        }
    }
 
}
