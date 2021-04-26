import java.util.Scanner;
 
public class cf4b {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int d = s.nextInt(), sumTime = s.nextInt(), sumMin = 0, sumMax = 0;
        int[] minTime = new int[d], maxTime = new int[d];
        for (int i = 0; i < d; i++) {
            minTime[i] = s.nextInt();
            maxTime[i] = s.nextInt();
            sumMin += minTime[i];
            sumMax += maxTime[i];
        }
        if (sumTime < sumMin || sumTime > sumMax) {
            System.out.print("NO");
        } else {
            System.out.println("YES");
            int left = sumTime - sumMin;
            for (int i = 0; i < d; i++) {
                int next = Math.min(left, maxTime[i] - minTime[i]);
                System.out.print(minTime[i] + next + " ");
                left -= next;
            }
        }
    }
}
