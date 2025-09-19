import java.util.Scanner;

public class ArraryExam_1 {
    public static void main(String[] args) {

        int intArrary[] = new int[5];
        int sum = 0;
        Scanner scn = new Scanner(System.in);

        for(int i = 0; i < intArrary.length; i++){
            intArrary[i] = scn.nextInt();
            sum += intArrary[i];
        }
        for(int i = 0; i < intArrary.length; i++){
            System.out.println("intArray[" + i + "] = " +intArrary[i]);
        }
        System.out.println("sum = " + sum);
        System.out.println("Mean = " + (double)(sum/intArrary.length));

    }
}
