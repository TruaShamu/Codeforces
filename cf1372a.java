import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        for (int i = 0; i < testcases; i++) {
            int n = sc.nextInt();
            for (int j = 0; j < n - 1; j++) {
                System.out.print(1 + " ");
            }
            System.out.println(1);
        }
    }
}
