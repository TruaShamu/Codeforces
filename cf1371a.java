import java.io.IOException;
import java.util.Scanner;
 
public class cf1371a {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int n = sc.nextInt();
            if (n % 2 == 1) {
                System.out.println(n / 2 + 1);
            } else {
                System.out.println(n / 2);
            }
        }
    }
}
