import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class cf702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] cities = new long[n];
        long[] towers = new long[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }
 
        long r = 0;
        long lower = 0;
        long upper = towers[0];
        int indexOfCities = 0;
        //distance to the first tower
        while (indexOfCities < n && cities[indexOfCities] <= upper) {
            r = Math.max(r, upper - cities[indexOfCities]);
            indexOfCities++;
        }
 
 
        for (int i = 1; i < m; i++) {
            lower = towers[i - 1]; //tower to the left
            upper = towers[i]; //tower to the right
            while (indexOfCities < n && cities[indexOfCities] <= upper) {
                //                   dist right            dist left
                r = Math.max(r, Math.min(upper - cities[indexOfCities], cities[indexOfCities] - lower));
                indexOfCities++;
            }
        }
 
        lower = towers[m - 1];
        //System.out.println(low);
        while (indexOfCities < n) {
            r = Math.max(r, cities[indexOfCities] - lower);
            indexOfCities++;
        }
 
        System.out.println(r);
    }
}
