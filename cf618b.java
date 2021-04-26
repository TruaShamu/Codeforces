import java.util.Arrays;
import java.util.Scanner;
 
public class cf618b {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int cases = inputReader.nextInt();
        for (int i = 0; i < cases; i++) {
            int students = 2 * inputReader.nextInt();
            int[] array = new int[students];
            for (int j = 0; j < students; j++) {
                array[j] = inputReader.nextInt();
            }
            Arrays.sort(array);
            System.out.println(array[students / 2] - array[students / 2 - 1]);
        }
 
 
    }
}
