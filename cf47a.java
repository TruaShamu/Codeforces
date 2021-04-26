import java.util.Scanner;
 
public class cf47a {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int Number = Integer.parseInt(inputReader.nextLine());
        //if (Number != 1) {
        double root = Math.pow(2 * Number, .5);
        int rootInt = (int) root;
        //System.out.println("root = " + rootInt);
        //int multiply = root * (root + 1);
        //System.out.println();
        if ((rootInt * (rootInt + 1)) == (2 * Number)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
 
    //}
}
