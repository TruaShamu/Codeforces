import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class cf1201 {
    public static long[] arr;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        //Read
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
 
        //Sort
        Arrays.sort(arr);
 
        //Binary Searxch
        long s = 1, b = 2000000000;
        while (s != b) {
            //System.out.println(s+" "+b);
            long m = (s + b + 1) / 2;
            if (check(m, n, k)) {
                s = m;
            } else b = m - 1;
        }
        int i=1;
        int j=99;
        System.out.println(b);
    }
 
    public static boolean check(long x, long n, long k) {
        long m = 0;
        for (int i = (int) n / 2; i < n; i++) {
            if (x - arr[i] > 0) {
                m += x - arr[i];
            }
            if (m > k) {
                return false;
            }
        }
        if (m > k) {
            return false;
        } else return true;
    }
}
