import java.util.Scanner;
 
public class cf705a {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int layers = Integer.parseInt(inputReader.nextLine());
        if (layers == 1) {
            PrintOddFinal();
 
 
        } else {
 
            for (int i = 1; i <= layers - 1; i++) {
                //System.out.println("i=" + i);
                if (i % 2 == 0) {
                    //System.out.println("even");
                    PrintEven();
                } else {
                    //System.out.println("odd");
                    PrintOdd();
                }
            }
            if (layers % 2 == 0) {
                PrintEvenFinal();
            } else {
                PrintOddFinal();
            }
 
 
        }
        System.out.println();
    }
 
    public static void PrintEven() {
        System.out.print("I love that ");
    }
 
    public static void PrintOdd() {
        System.out.print("I hate that ");
    }
 
    public static void PrintOddFinal() {
        System.out.print("I hate it");
    }
 
    public static void PrintEvenFinal() {
        System.out.print("I love it");
    }
 
}
