import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
 
public class cf1230a {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        ArrayList<Integer> bags = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int val = inputReader.nextInt();
            bags.add(val);
            sum += val;
        }
        Collections.sort(bags);
        Collections.reverse(bags);
 
        if (sum - bags.get(0) == bags.get(0) || sum - bags.get(0) - bags.get(3) == bags.get(0) + bags.get(3)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
 
    }
}
