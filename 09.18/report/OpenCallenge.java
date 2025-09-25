package report.chapter_3;

/*

숨겨진 카드의 수를 맞추는 게임을 만들어보자.
0에서 99까지의 임의의 수를 가진 카드를 한 장 숨기고 이 카드의 수를 맞추는 게임이다.
아래의 화면과 같이 카드 속의 수가 77인 경우를 보자.
수를 맞추는 사람이 55라고 하면 "더 높게", 다시 70을 입력하면 "더 높게"라는 식으로 범위를 좁혀가면서 수를 맞춘다.
게임을 반복하기 위해 y/n을 묻고, n인 경우 종료된다.

 */

import java.util.Random;
import java.util.Scanner;

public class OpenCallenge {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random  r =  new Random();

        while(true){

            int k = r.nextInt(100); //랜덤숫자 결정
            int max = 99;
            int min = 0;
            int count = 1;

            System.out.println("수를 결정하였습니다. 맞추어보세요");

            System.out.println(min + "~" + max);
            System.out.print(count + " >> ");

            while (true){

                int game = scn.nextInt();

                if (k< game){
                    System.out.println("더 낮게");
                }else if (k > game){
                System.out.println("더 크게");
                }else {
                    System.out.println("맞췄습니다.");
                    break;
                }
                System.out.print(count+1 + " >> ");

                count++;
            }

            System.out.println("다시 시작하시겠습니까?(y/n)");
            String text = scn.next();

            if (text.equals("n")){
                System.out.println("게임을 종료합니다");
                break;
            }
        }
        scn.close();
    }
}
