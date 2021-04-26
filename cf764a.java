import java.util.Scanner;

/*
    A. Taymyr is calling you
    */
public class cf764a {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int call = inputReader.nextInt();
        int artist = inputReader.nextInt();
        int minutes = inputReader.nextInt();
        int lcm = lcm(call, artist);
        System.out.println(minutes / lcm);
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
