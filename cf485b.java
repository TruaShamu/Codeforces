import java.util.Scanner;
 
public class cf485b {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int mines = inputReader.nextInt();
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
 
        for (int i = 0; i < mines; i++) {
            long x = inputReader.nextLong();
            long y = inputReader.nextLong();
            maxX = Long.max(maxX, x);
            minX = Long.min(minX, x);
            maxY = Long.max(maxY, y);
            minY = Long.min(minY, y);
        }
        long xDis = Math.abs(maxX - minX);
        long yDis = Math.abs(maxY - minY);
        long maxSide = Long.max(yDis, xDis);
        System.out.println(maxSide * maxSide);
 
 
    }
}
