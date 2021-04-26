import java.util.Scanner;
 
public class cf1199b {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        float H = (inputReader.nextFloat());
        float L = (inputReader.nextFloat());
        System.out.println((Math.pow(L, 2) - Math.pow(H, 2)) / (2 * H));
    }
}
