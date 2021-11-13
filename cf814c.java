import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine()); //length
        String string = br.readLine(); //garland string
        //System.out.println("STRING:" + string);
        String[] line;
 
        int q = Integer.parseInt(br.readLine()); //queries
        while (q-- != 0) {
            line = br.readLine().split(" ");
            int m = Integer.parseInt(line[0]); //pieces to repaint
            char c = line[1].charAt(0); //favorite color
            int left = 0, right = 0, cnt = 0, shift = 0;
            for (int i = 0; i < N; i++) {
                //String equal to favorite color
                if (string.charAt(i) == c) {
                    ++right;
                    cnt = Math.max(cnt, right - left + 1);
                    continue;
                }
                if (shift >= m) {
                    while (string.charAt(left) == c && left < right)
                        ++left;
                    --shift;
                    ++left;
                }
                ++right;
                ++shift;
                cnt = Math.max(cnt, right - left + 1);
            }
            pw.println(--cnt + " ");
        }
        pw.close();
    }
 
 
}
 
 
