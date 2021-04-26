import java.util.Scanner;
 
public class cf136a {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        int participantNum = Integer.parseInt(inputReader.nextLine());
        int[] inputArray = new int[participantNum];
        int[] outputArray = new int[participantNum];
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = inputReader.nextInt() - 1;
            outputArray[inputArray[i]] = i;
        }
        for (int i = 0; i < outputArray.length; i++) {
            outputArray[i] += 1;
        }
        for (int i = 0; i < participantNum - 1; i++) {
            System.out.print(outputArray[i] + " ");
        }
        System.out.println(outputArray[participantNum - 1]);
 
    }
}
