import java.util.Scanner;
 
public class cf1020b {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i < n + 1; i++) {
            int[] s = new int[n + 1];
            int j = arr[i];
            s[i]++;
            while (++s[j] <= 1) {
                j = arr[j];
            }
            System.out.print(j + " ");
        }
 
    }
 
 
}
