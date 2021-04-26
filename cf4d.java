import java.util.Arrays;
import java.util.Scanner;
 
public class cf4d {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        int H = sc.nextInt();
        Envelope[] envelopes = new Envelope[N];
        for (int i = 0; i < N; i++) {
            int width = sc.nextInt();
            int height = sc.nextInt();
            envelopes[i] = new Envelope(width, height, i + 1);
            envelopes[i].max = envelopes[i].w > W && envelopes[i].h > H ? 1 : 0;
        }
        sc.close();
        Arrays.sort(envelopes);
        int maxIndx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j].fitsIn(envelopes[i]) && envelopes[j].max >= envelopes[i].max && envelopes[j].max > 0) {
                    envelopes[i].max = envelopes[j].max + 1;
                    envelopes[i].prev = j;
                }
            }
            if (envelopes[i].max > envelopes[maxIndx].max) {
                maxIndx = i;
            }
        }
        int current = maxIndx, maxVal = envelopes[maxIndx].max;
        int[] path = new int[maxVal];
        for (int i = maxVal - 1; i >= 0; i--) {
            path[i] = envelopes[current].n;
            current = envelopes[current].prev;
        }
        System.out.println(maxVal);
        if (maxVal > 0) {
            for (int i = 0; i < path.length; i++) {
                System.out.print(path[i] + " ");
            }
        }
 
    }
}
class Envelope implements Comparable<Envelope> {
    int w, h, max, prev, n;
 
    Envelope(int width, int height, int number) {
        w = width;
        h = height;
        n = number;
    }
 
    public boolean fitsIn(Envelope oEnvelope) {
        return oEnvelope.w > w && oEnvelope.h > h;
    }
 
    @Override
    public int compareTo(Envelope oEnvelope) {
        return w - oEnvelope.w;
    }
 
}
