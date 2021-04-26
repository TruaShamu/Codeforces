import java.io.IOException;
import java.util.Scanner;
 
public class cf1374c {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int tc = 0; tc < testCases; tc++) {
            int length = sc.nextInt();
            char brackets[] = sc.next().toCharArray();
            //System.out.println(Arrays.toString(brackets));
            int left = 0;
            int right = 0;
            for (int i = 0; i < brackets.length; i++) {
                if (brackets[i] == '(') {
                    left++;
                } else {
                    if (brackets[i] == ')') {//s[i]==')'
                        if (left > 0) {
                            left--;
                        } else {
                            right++;
                        }
                    }
                }
            }
            //System.out.println("LEFT: " + left + " RIGHT: " + right);
            System.out.println(right);
 
        }
    }
}
