import java.util.Scanner;
 
public class 1163a {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int initialCats = (inputReader.nextInt());
        int leavingCats = (inputReader.nextInt());
        if (leavingCats == 0) {
            System.out.println(1);
            System.exit(0);
        }
        if ((leavingCats - 1) < (initialCats / 2)) {
            System.out.println(leavingCats);
        } else {
            if ((leavingCats + 1) >= (initialCats / 2)) {
                System.out.println(initialCats - leavingCats);
            }
        }
 
    }
}
