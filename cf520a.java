import java.util.Scanner;
 
public class cf520a {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        boolean[] appears = new boolean[26];
        int length = inputReader.nextInt();
        String input = inputReader.next();
        for (char uc = 65; uc < 91; uc++) {
            if (input.indexOf(uc) != -1) {
                appears[uc - 65] = true;
            }
        }
        for (char lc = 97; lc < 123; lc++) {
            //System.out.println(lc);
            if (input.indexOf(lc) != -1) {
                appears[lc - 97] = true;
            }
        }
 
        if (works(appears)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
 
    }
 
    public static boolean works(boolean[] array) {
        for (boolean oBoolean : array) {
            if (!oBoolean) {
                return false;
            }
        }
        return true;
    }
}
