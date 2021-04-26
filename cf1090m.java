import java.util.Scanner;
 
public class cf1090m {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int houses = inputReader.nextInt();
        int colors = inputReader.nextInt();
        int[] houseArray = new int[houses];
        for (int i = 0; i < houses; i++) {
            houseArray[i] = inputReader.nextInt();
        }
        int maxLength = 0;
        int curLength = 0;
        for (int i = 0; i < houses; i++) {
            curLength++;
            if (i < houses - 1) {
                if (houseArray[i] == houseArray[i + 1]) {
                    maxLength = Integer.max(maxLength, curLength);
                    curLength = 0;
                }
            }
 
        }
        maxLength = Integer.max(maxLength, curLength);
        System.out.println(maxLength);
    }
}
