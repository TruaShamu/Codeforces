import java.util.Scanner;
 
public class cf177a1 {
    public static int rows;
    public static int[][] squareArray;
    public static int sum;
 
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        rows = Integer.parseInt(inputReader.nextLine());
        squareArray = new int[rows][rows];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < rows; column++) {
                squareArray[row][column] = inputReader.nextInt();
            }
        }
        sum = 0;
        //printSquareArray();
 
        findVertical();
        //System.out.println("After vertical " + sum);
        findHorizontal();
        findOverlap();
        findPrimaryDiagonal();
        findSecondaryDiagonal();
        System.out.println(sum);
 
    }
 
    public static void printSquareArray() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(squareArray[i][j]);
            }
            System.out.println();
        }
    }
 
    public static void findVertical() {
 
        int middleColumn = (rows / 2); //(row/2)+1-1
        for (int row = 0; row < rows; row++) {
            //System.out.println("+" + squareArray[row][middleColumn]);
            sum += squareArray[row][middleColumn];
        }
        //System.out.println("sum=" + sum);
    }
 
    public static void findHorizontal() {
        int middleRow = (rows / 2); //(row/2)+1-1
        for (int column = 0; column < rows; column++) {
            //System.out.println("+" + squareArray[middleRow][column]);
            sum += squareArray[middleRow][column];
        }
        //System.out.println("sum=" + sum);
    }
 
    public static void findPrimaryDiagonal() {
        for (int i = 0; i < rows; i++) {
            //System.out.println("+" + squareArray[i][i]);
            sum += squareArray[i][i];
        }
        //System.out.println("sum=" + sum);
 
    }
 
    public static void findSecondaryDiagonal() {
        for (int i = 0; i < rows; i++) {
            sum += squareArray[i][rows - i - 1];
            //System.out.println("+" + squareArray[i][rows - i - 1]);
 
        }
        //System.out.println("sum=" + sum);
    }
 
    public static void findOverlap() {
        sum -= (3 * squareArray[rows / 2][rows / 2]);
        //System.out.println("-" + (3 * squareArray[rows / 2][rows / 2]));
        //System.out.println("sum=" + sum);
    }
}
