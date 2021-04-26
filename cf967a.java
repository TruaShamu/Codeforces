import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
 
public class cf967a {
    public static void main(String[] args) throws IOException {
        Scanner inputReader = new Scanner(System.in);
        int lines = inputReader.nextInt();
        int minTime = inputReader.nextInt();
        int gap = (2 * minTime) + 1;
        //System.out.println(gap);
 
        ArrayList<Integer> times = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            int hours = inputReader.nextInt();
            int minutes = inputReader.nextInt();
            times.add((hours * 60) + minutes);
        }
 
        times.add(Integer.MAX_VALUE);
        Collections.sort(times);
        //System.out.println(times);
 
        int minutes = 0;
        if (times.get(0) >= (minTime + 1)) {
            System.out.println(0 + " " + 0);
            System.exit(0);
        }
        for (int i = 1; i < times.size(); i++) {
            if (times.get(i) - times.get(i - 1) > gap) {
                minutes = times.get(i - 1) + minTime;
                break;
            }
        }
        minutes+=1;
        System.out.println((minutes / 60) + " " + ((minutes % 60)));
 
 
    }
}
