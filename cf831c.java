import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] marks = new int[K]; //Prefix sum
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            marks[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < K; i++) {
            marks[i] += marks[i - 1];
        }
 
        int[] points = new int[N]; //Scores
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }
 
        Set<Integer> iValues = new HashSet<>();
        Set<Integer> currentValues = new HashSet<>();
 
 
        for (int val : points) {
            for (int prefix : marks) {
                currentValues.add(val - prefix); //Original score
            }
 
            if (val != points[0]) {
                iValues.retainAll(currentValues);
            } else iValues = currentValues;
 
            currentValues = new HashSet<>();
 
        }
 
 
        System.out.println(iValues.size());
    }
}
