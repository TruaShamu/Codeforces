import java.util.Scanner;
 
public class cf78a {
    public static int[] vowelCount = new int[3];
 
    public static void main(String[] args) {
        vowelCount = new int[3];
        Scanner inputReader = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            String input = inputReader.nextLine();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == 'a' || input.charAt(j) == 'i' || input.charAt(j) == 'u' || input.charAt(j) == 'e' || input.charAt(j) == 'o') {
                    vowelCount[i]++;
                }
            }
        }
        if (vowelCount[0] == 5 && vowelCount[1] == 7 && vowelCount[2] == 5) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
