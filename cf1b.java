import java.util.Scanner;

public class cf1b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            String s = sc.next();
            int indexOfC = s.indexOf('C');
            if (s.charAt(0) == 'R' && s.charAt(1) - '0' <= 9 && indexOfC > 0) {
                int row, col;
                row = Integer.parseInt(s.substring(1, indexOfC));
                col = Integer.parseInt(s.substring(indexOfC + 1));

                StringBuilder colStr = new StringBuilder();
                while (col > 0) {
                    colStr.insert(0, (char) ((col - 1) % 26 + 'A'));
                    col = (col - 1) / 26;
                }
                System.out.println(colStr.toString() + "" + row);
            } else {
                int k, row, col = 0;

                for (k = 0; s.charAt(k) - 'A' >= 0; k++) {
                    col *= 26;
                    col += s.charAt(k) - 'A' + 1;
                }
                row = Integer.parseInt(s.substring(k));
                System.out.println("R" + row + "C" + col);
            }
        }
    }
}
