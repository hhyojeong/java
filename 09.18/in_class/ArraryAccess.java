import java.util.Scanner;

public class ArraryAccess {

    public static void main(String[] args) {
        int intArrary[] = new int [5];
        Scanner scn = new Scanner(System.in);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        System.out.print("정수값 5개를 입력하세요 : ");
        for(int i = 0; i <= 4; i++){
            intArrary[i] = scn.nextInt();

            if(intArrary[i] > max ){
                max = intArrary[i];
            }
            if(intArrary[i] < min ){
                min = intArrary[i];
            }
        }

        System.out.println("최대값 = " + max);
        System.out.println("최소값 = " + min);
    }

}
