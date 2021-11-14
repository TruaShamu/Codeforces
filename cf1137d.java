import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    public static int[] loc;
    public static BufferedReader br;
 
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        loc = new int[20];
        while (true) {
            out(new int[]{0, 1});
            read();
            out(new int[]{0});
            read();
            if (loc[0] == loc[1]) {
                break;
            }
        }
        while (true) { // t times
            out(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
            read();
            if (loc[0] == loc[2]) {
                break;
            }
        }
        System.out.println("done");
    }
 
 
    public static void read() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String s = st.nextToken();
            for (int j = 0; j < s.length(); j++) {
                loc[s.charAt(j) - '0'] = i;
            }
        }
    }
 
 
    public static void out(int[] arr) {
        System.out.print("next");
        for (int a : arr) {
            System.out.print(" " + a);
        }
        System.out.println();
        System.out.flush();
    }
}
