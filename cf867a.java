import java.util.Scanner;
 
public class cf867a {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int numberOfCharacters = Integer.parseInt(inputReader.nextLine());
        String inputString = inputReader.nextLine();
        int[] frequencyArray = new int[2]; //1st is from SF to SEA, 2nd is from SEA to SF
        char curChar = inputString.charAt(0);
        //System.out.println("curchar initial " + curChar);
        for (int i = 1; i < inputString.length(); i++) {
            if (curChar != inputString.charAt(i)) {
                if (curChar == 'F') {
                    frequencyArray[0]++;
                } else {
                    frequencyArray[1]++;
                }
                curChar = inputString.charAt(i);
            }
 
        }
        //System.out.println(frequencyArray[0] + " " + frequencyArray[1]);
        if (frequencyArray[1] > frequencyArray[0]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
