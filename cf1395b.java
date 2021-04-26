import java.util.Scanner;
 
public class cf1395b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println((x + 1) + " " + (y + 1));
                if (j < columns - 1) {
                    y = (y + 1) % columns;
                }
            }
            x = (x + 1) % rows;
        }
    }
}
