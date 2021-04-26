import java.util.Scanner;

public class cf1253a {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        for (int tc = 0; tc < testcases; tc++) {
            int length = in.nextInt();
            int[] a = new int[length];
            int[] b = new int[length];
            for (int i = 0; i < a.length; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < b.length; i++) {
                b[i] = in.nextInt();
            }

            if (same(a, b)) {
                System.out.println("YES");
                continue;
            }

            boolean answers = true;
            int k = 0;
            int m = -1;
            for (int i = 0; i < length; i++) {
                if (a[i] != b[i]) {
                    if (b[i] < a[i]) {
                        answers = false;
                        break;
                    }
                    k = b[i] - a[i]; // difference
                    m = i; // start
                    break;
                }
            }

            //System.out.println("M: " + m);
            if (m == -1) {
                System.out.println("NO");
                continue;
            }

            for (int i = m; i < length; i++) {
                if (a[i] == b[i]) break;
                a[i] += k;
                //Add all the numbers
            }

            for (int i = 0; i < length; i++) {
                //Check all elements
                if (a[i] != b[i]) {
                    answers = false;
                    break;
                }
            }
            if (answers) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    public static boolean same(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
