package report.Chapter3;

/*
  갬블링 게임 프로그램을 작성해보자. 사용자가 엔터키를 입력하면 0,1,2 중에서 랜덤하게 3개의 수를 생성하여 출력하고,
  3개가 모두 같은 값일 때 "성공, 대박났어요!"를 출력한다. 실행 예시를 참고하여 프로그램을 작성하라.

  ***** 갬블링 게임을 시작합니다. *****
  엔터키 입력>>
  1 1 0
  엔터키 입력>>
  0 2 1
  엔터키 입력>>
  1 0 2
  엔터키 입력>>
  2 2 2
  성공! 대박났어요!
  계속하시겠습니까?(yes/no)>>yes
  엔터키 입력>>
  2 2 0
  엔터키 입력>>
  0 0 2
  엔터키 입력>>
  2 1 2
  엔터키 입력>>
  2 2 2
  성공! 대박났어요!
  계속하시겠습니까?(yes/no)>>no
  게임을 종료합니다.
 */

import java.util.Random;
import java.util.Scanner;

public class Question_14 {

    public static void main(String[] args) {
        Random r = new Random();
        Scanner scn = new Scanner(System.in);

        int a, b, c;
        String enter, answer;

        System.out.println("***** 갬블링 게임을 시작합니다. *****");
        while(true) {
            System.out.print("엔터키 입력>>");
            enter = scn.nextLine();

            a=r.nextInt(3);
            b=r.nextInt(3);
            c=r.nextInt(3);

            System.out.println(a +" "+ b +" "+ c);

            if(a == b && a == c) {
                System.out.println("성공! 대박났어요!");

                boolean bool = false;

                while(bool != true) {

                    System.out.print("계속하시겠습니까?(yes/no)>>");
                    answer = scn.nextLine();

                    switch(answer) {
                        case "n":
                            System.out.print("게임을 종료합니다.");
                            scn.close();
                            System.exit(0);
                        case "y":
                            bool = true;
                            break;
                        default:
                            System.out.println("y/n만 입력해주세요.");
                    }
                }
            }
        }
    }

}
