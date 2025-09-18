/*

숫자를 입력받아 3~5는 "따뜻한 봄", 6~8은 "바다가 즐거운여름", 9~11은 "낙엽이 지는 아름다운 가을"
12~2의 경우 "눈내리는 하얀 겨울"을 그외 숫자( 문자를 입력하여 발생하는 오류를 처리한 것은
 3장 7절 예외처리에서 다룹니다)를 입련한 경우 "1~12만 입력하세요를 출력하는 프로그램을 작성하라

 */

import  java.util.Scanner;

public class Season_b {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("월을 입력하세요(1~12) >>");
        int season = scn.nextInt();
        String season_;

        switch (season){
            case 3:
            case 4:
            case 5:
                System.out.println("따뜻하 봄");
                break;

            case 6:
            case 7:
            case 8:
                System.out.println("바다가 즐거운여름");
                break;

            case 9:
            case 10:
            case 11:
                System.out.println("낙엽이 지는 아름다운 가을");
                break;

            case 12:
            case 1:
            case 2:
                System.out.println("눈내리는 하얀 겨울");
                break;

            default:
                System.out.println("존재하지 않는 달입니다.");
        }
    }
}
