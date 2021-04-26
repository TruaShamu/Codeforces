import java.io.IOException;
import java.util.Scanner;
 
public class cf1283a {
    public static void main(String[] args) throws IOException {
        Scanner inputReader = new Scanner(System.in);
        int testCases = inputReader.nextInt();
        for (int i = 0; i < testCases; i++) {
            int hour = inputReader.nextInt();
            int minute = inputReader.nextInt();
            System.out.println(1440 - (60*hour) - minute);
        }
 
    }
}
