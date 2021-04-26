import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
 
public class cf280b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lanterns = sc.nextInt();
        long length = sc.nextLong();
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < lanterns; i++) {
            list.add(sc.nextLong());
        }
        Collections.sort(list);
        long head = list.get(0);
        long tail = length - list.get(list.size() - 1);
        double answer = (double) Long.max(head, tail);
        for (int i = 1; i < list.size(); i++) {
            double distance = ((double) (list.get(i) - list.get(i - 1))) / 2;
            answer = (double) Double.max(answer, distance);
        }
        System.out.println(answer);
    }
}
