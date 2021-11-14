import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int inp = sc.nextInt();
            if (inp <= 30) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                if (inp == 36 || inp == 40 || inp == 44) {
                    System.out.println("6 10 15 " + (inp - 31));
                } else {
                    System.out.println("6 10 14 " + (inp - 30));
                }
 
            }
        }
    }
}
