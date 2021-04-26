import java.util.Scanner;
 
public class cf1395 {
    public static int[] aArray;
    public static int[] bArray;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        aArray = new int[n];
        bArray = new int[m];
        for (int i = 0; i < n; i++) {
            aArray[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            bArray[i] = sc.nextInt();
        }
        for (int i = 0; i < 512; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (((aArray[j] & bArray[k]) | i) == i) {
                        count++;
                        break;
                    }
 
                }
            }
            if (count == n) {
                System.out.println(i);
                break;
            }
        }
 
    }
}
