package report.Chapter3;

/*
  몇 개의 정수를 저장할 것인지 개수를 입력받고,, 그 만큼의 배열을 생성하라. 그리고 배열에 1~100 범위의 랜덤한 정수를 저장한 후,
  정수들과 평균을 출력하라. 단, 같은 정수가 저장되지 않게 하라.

  정수 몇 개 저장하시겠습니까>>12
  랜덤한 정수들...67 69 31 48 27 20 92 55 50 47 93 75
  평균은 56.166666666666664
 */

import java.util.Random;
import java.util.Scanner;

public class Question_8 {

    public static void main(String[] args) {
        Random r = new Random();
        Scanner scn = new Scanner(System.in);

        System.out.print("정수 몇 개 저장하시겠습니까>> ");
        int num = scn.nextInt();
        int array[] = new int[num];
        int sum = 0;
        double averege;

        System.out.print(" 랜덤한 정수들... ");
        for(int i=0; i<num; i++) {
            array[i]= r.nextInt(1, 101);
            System.out.print(array[i] + " ");
            sum += array[i];
        }
        System.out.println();

        averege = (double)sum/num;
        System.out.print("평균은 " + averege);

        scn.close();
    }


}
