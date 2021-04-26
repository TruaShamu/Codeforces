import java.util.Scanner;
 
public class cf746a {
    public static int lemons;
    public static int apples;
    public static int pears;
 
    public static void main(String[] args) {
 
        Scanner inputReader = new Scanner(System.in);
        lemons = Integer.parseInt(inputReader.nextLine());
        apples = Integer.parseInt(inputReader.nextLine());
        pears = Integer.parseInt(inputReader.nextLine());
        int lowerBound = calculateLowerBound();
        int totalFruits = 7 * lowerBound;
        System.out.println(totalFruits);
 
    }
 
    public static int calculateLowerBound() {
        int curLowerBound = lemons;
        curLowerBound = Integer.min(curLowerBound, apples / 2);
        curLowerBound = Integer.min(curLowerBound, pears / 4);
        return curLowerBound;
    }
 
}
