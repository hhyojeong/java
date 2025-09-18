/*

생일 케이크에 사용할 초를 준비하려고 한다.
빨간 초는 10살, 파란초는 5살, 노찬초는 1살을 나타낼 때,
다음 실행 사례를 참고하여 나이에 맞는 각 초의 개수를 계산하는 프로그램을 작성하라.
(빨간초, 파란초, 노란초 순으로 개수를 계산하면 된다.) 나이에 0이나 음수가 입력되면,
"나이는 양수로만 입력하세요."라는 출력하고 프로그램을 종료하라

*/

import  java.util.Scanner;

public class Cake {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);


        System.out.print("나이를 입력하세요 >> ");
        int candle = scn.nextInt();

        if(candle < 0){
            System.out.println("나이를 양수로만 입력하세요");
            System.exit(0);
        }

        // 빨간초, 파란초, 노란초 순으로 개수
        int red =candle/10;
        int blue = candle%10/5;
        int yellow = candle%10%5;
        int all = red+blue+yellow;

        System.out.println("빨간초"+red+"개, "+"파란초 "+ blue+"개, "+ "노란초"+yellow+"개. " +"총"+ all+"개가 필요합니다.");

        scn.close();
    }
}
