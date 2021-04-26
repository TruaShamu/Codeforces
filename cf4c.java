import java.util.HashMap;
import java.util.Scanner;
 
public class cf4c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            if (!map.containsKey(s)) {
                System.out.println("OK");
                map.put(s, 0);
            } else {
                map.replace(s, map.get(s).intValue() + 1);
                System.out.println(s + map.get(s).intValue());
            }
        }
    }
}
