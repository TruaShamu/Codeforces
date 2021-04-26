import java.util.Scanner;
 
public class cf99a {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        String numberString = inputReader.nextLine();
        int decimalLoc = -1;
        for (int i = 0; i < numberString.length(); i++) {
            if (numberString.charAt(i) == '.') {
                decimalLoc = i;
                break;
            }
        }
        if (numberString.charAt(decimalLoc - 1) == '9') {
            System.out.println("GOTO Vasilisa.");
            System.exit(0);
        } else {
            if (numberString.charAt(decimalLoc + 1) < '5') {
                //System.out.println("<5");
                for (int i = 0; i < decimalLoc; i++) {
                    System.out.print(numberString.charAt(i));
                }
                System.out.println();
            } else {
                //System.out.println(">=5");
                for (int i = 0; i < decimalLoc - 1; i++) {
                    System.out.print(numberString.charAt(i));
                }
                int x = (numberString.charAt(decimalLoc - 1)) + 1;
                char c = (char) x;
                System.out.print(c);
                System.out.println();
 
            }
        }
    }
}
