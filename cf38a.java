import java.util.Scanner;
import java.util.StringTokenizer;
 
public class cf38a {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        String totalRanks = inputReader.nextLine();
        int totalRanksint = Integer.parseInt(totalRanks);
        //System.out.println(totalRanksint);
        //works!
        //System.exit(0);
 
        String ranksCost = inputReader.nextLine();
 
        //System.out.println(ranksCost);
        //System.exit(0);
        StringTokenizer st = new StringTokenizer(ranksCost);
        int[] ranksCostArray = new int[totalRanksint];
 
        for (int i = 0; i < totalRanksint - 1; i++) {
            ranksCostArray[i] = Integer.parseInt(st.nextToken());
        }
        
 
        //String rankDifference = inputReader.next();
        // System.out.println(rankDifference);
        //System.exit(0);
        //StringTokenizer st1 = new StringTokenizer(rankDifference);
        int rank1 = Integer.parseInt(inputReader.next());
        int rank2 = Integer.parseInt(inputReader.next());
 
 
        int totalCost = 0;
        for (int i = rank1 - 1; i < rank2 - 1; i++) {
            totalCost += ranksCostArray[i];
        }
        System.out.println(totalCost);
 
 
    }
}
