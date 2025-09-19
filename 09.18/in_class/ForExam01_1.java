import java.util.Scanner;

public class ForExam01_1{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int i, sum = 0, number;
        System.out.print("정수를 입력 : ");
        number = scn.nextInt();

        for(i = 1; i <= number; i++) {
            sum = sum += i; // sum = sum += i; <- 동일 -> sum+=i;
        }
        System.out.println("1부터" + (i - 1) + "까지의 합 = " + sum);
    }
}