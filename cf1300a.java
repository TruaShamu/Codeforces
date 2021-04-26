import java.util.Scanner;
 
public class cf1300a {
 
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int testCases = inputReader.nextInt();
        for (int i = 0; i < testCases; i++) {
            int arraySize = inputReader.nextInt();
            int[] input = new int[arraySize];
            int sum = 0;
            int operations = 0;
            int zeroes = 0;
            for (int j = 0; j < arraySize; j++) {
                input[j] = inputReader.nextInt();
                if (input[j] == 0) {
                    zeroes++;
                }
                sum += input[j];
            }
            if (zeroes == 0) {
                if (sum == 0) {
                    System.out.println(1);
                    continue;
                } else {
                    System.out.println(0);
                    continue;
                }
            } else {
                operations = zeroes;
                sum = sum + zeroes;
                if (sum == 0) {
                    System.out.println((operations + 1));
                    continue;
                } else {
                    System.out.println((operations));
                    continue;
                }
            }
 
        }
    }
 
 
}
