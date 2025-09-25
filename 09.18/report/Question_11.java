package report.Chapter3;

/*

  구구단 퀴즈의 답을 검사하는 프로그램을 작성하라. 랜덤하게 구구단을 묻고 사용자의 답을 입력받아 정답인지 판단한다.
  3번 틀리면 종료한다.

  ***** 구구단을 맞추는 퀴즈입니다. *****
  8x5=40
  정답입니다. 잘했습니다.
  3x1=4
  1번 틀렸습니다. 분발하세요.
  7x6=5
  2번 틀렸습니다. 분발하세요.
  9x4=36
  정답입니다. 잘했습니다.
  8x4=6
  3번 틀렸습니다. 퀴즈 종료합니다.

*/

import java.util.Random;
import java.util.Scanner;


public class Question_11 {

    public static void main(String[] args) {
        Random r = new Random();
        Scanner scn = new Scanner(System.in);

        int a, b, answer, count=0;

        System.out.println("***** 구구단을 맞추는 퀴즈입니다. *****");
        while(count!=3) {
            a=r.nextInt(1,10);
            b=r.nextInt(1,10);
            System.out.print(a + "x" + b + "=");
            answer = scn.nextInt();

            if(answer == a*b) {
                System.out.println("정답입니다. 잘했습니다.");
            }
            else {
                System.out.print((count+1) + "번 틀렸습니다. ");
                if(count < 2) {
                    System.out.println("분발하세요.");

                }
                else {
                    System.out.print("퀴즈 종료합니다.");
                    break;
                }
                count++;
            }
        }
        scn.close();
    }

}
