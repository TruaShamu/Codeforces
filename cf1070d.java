import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int days = inputReader.nextInt();
        long capacity = inputReader.nextLong();
        long[] garbageAmount = new long[days];
        for (int i = 0; i < days; i++) {
            garbageAmount[i] = inputReader.nextLong();
        }
        long r = 0;
        long ans = 0;
        for (int i = 0; i < days; i++) {
            long xx = (garbageAmount[i] + r) / capacity;
            if (xx == 0 && r == 0) {
                r = garbageAmount[i] % capacity;
                continue;
            }
            if (xx == 0 && r != 0) {
                r = 0;
                ans++;
                continue;
            }
            ans += xx;
            r = (garbageAmount[i] + r) % capacity;
        }
        if (r != 0)
            ans++;
        System.out.println(ans);
 
 
    }
}
 
