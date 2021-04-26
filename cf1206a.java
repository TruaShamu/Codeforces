import java.util.Scanner;
 
public class cf1206a {
    //Brute force solution
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int aSize = inputReader.nextInt();
        int[] a = new int[aSize];
        for (int i = 0; i < aSize; i++) {
            a[i] = inputReader.nextInt();
        }
        int bSize = inputReader.nextInt();
        int[] b = new int[bSize];
        for (int i = 0; i < bSize; i++) {
            b[i] = inputReader.nextInt();
        }
        for (int i : a) {
            for (int j : b) {
                int sum = i + j;
                if (!contains(b, sum) && !contains(a, sum)) {
                    System.out.println(i + " " + j);
                    System.exit(0);
                }
 
            }
        }
 
    }
 
    public static boolean contains(int[] array, int number) {
        for (int i : array) {
            if (i == number) {
                return true;
            }
        }
        return false;
    }
}
