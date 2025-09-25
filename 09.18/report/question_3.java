package report.Chapter3;

/*
  Scanner를 이용하여 양의 정수를 입력받고 다음과 같이 *를 출력하는 프로그램을 작성하라. 양의 정수가 입력될 때까지 계속 입력을 받도록 하라.
  다음 실행 사례는 5를 입력받은 경우이다.

  양의 정수 입력>>-2
  양의 정수 입력>>5
  *****
  ****
  ***
  **
  *
 */

import java.util.Scanner;


public class question_3 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char c = '*';
        int num = 0;

        while(num <= 0) {
            System.out.print("양의 정수 입력>> ");
            num = scn.nextInt();
        }

        for(int i=0; i <= num; i++) {
            for(int j = 1; j <= num-i; j++) {
                System.out.print(c);
            }
            for(int k = 1; k <= i; k++) {
                System.out.print((char)(c-10));
            }
            System.out.println();
        }

        scn.close();
    }


}
