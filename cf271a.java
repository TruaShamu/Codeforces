import java.util.Scanner;
 
public class cf271a {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int year = inputReader.nextInt();
        for (int i = year + 1; ; i++) {
            String str = Integer.toString(i);
            if (different(str)) {
                System.out.println(i);
                break;
            }
 
        }
    }
 
    public static boolean different(String str) {
        for (int char1 = 0; char1 < str.length(); char1++) {
            for (int char2 = 0; char2 < str.length(); char2++) {
                if (char1 == char2) {
                    continue;
                }
                if (str.charAt(char1) == str.charAt(char2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
