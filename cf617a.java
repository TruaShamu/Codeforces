import java.util.Scanner;
 
public class cf617a {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int distance = Integer.parseInt(inputReader.nextLine());
        int div5 = distance/5;
        if (distance%5!= 0) {
            System.out.println(div5+1);
        }
        else {
            System.out.println(div5);
        }
    }
}
