import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
 
public class cf280d {
 
    public static void main(String[] args) {
 
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(), x = in.nextInt(), y = in.nextInt();
        ArrayList<String> arr = new ArrayList<>();
 
        double cnt1 = 1, cnt2 = 1;
 
        while (cnt1 <= x || cnt2 <= y) {
 
            double val1 = cnt1 * 1.0 / x;
            double val2 = cnt2 * 1.0 / y;
 
            if (val1 == val2) {
                arr.add("Both");
                arr.add("Both");
                cnt1++;
                cnt2++;
            } else if (val1 < val2) {
                arr.add("Vanya");
                cnt1++;
            } else {
                arr.add("Vova");
                cnt2++;
            }
        }
 
        int len = arr.size();
        while (t-- > 0) {
            int n = (in.nextInt()) - 1;
            System.out.println(arr.get(n % len));
        }
 
    }
}
