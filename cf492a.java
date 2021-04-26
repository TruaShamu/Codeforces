import java.util.Scanner;
 
public class cf492a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalCubes = sc.nextInt();
        int totalUsed = 0;
        for (int height = 0; ; height++) {
            int rowCubes = ((height) * (height + 1)) / 2;
            if (totalUsed + rowCubes > totalCubes) {
                System.out.println(height - 1);
                System.exit(0);
            }
            if (totalUsed + rowCubes == totalCubes) {
                System.out.println(height);
                System.exit(0);
            }
            totalUsed = totalUsed + rowCubes;
        }
 
    }
}
