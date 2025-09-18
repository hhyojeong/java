/*

2차원 평면에서 사각형은 두 점으로 표현할 수 있다.
사용자로부터 사각형을 구성하는 두 점(x1, y1).(x2, y2)을 입력받고 이 사각형이
(10, 10)과 (200, 300)의 사각형에 완전히 포함되면 "포함되다." 아니면 "포함되지 않는다."를
출력하는 프로그램을 작성하라.
실행사례는 다음과 같다.

 */

import java.util.Scanner;

public class Squre_2 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("점 (x1, y2), (x2, y2)의 좌표 입력 >> ");

        int x1 =scn.nextInt();
        int y1 =scn.nextInt();
        int x2 =scn.nextInt();
        int y2 =scn.nextInt();

        if (x1 >= 10 && x1 <= 200 && x2 >= 10 && x2 <= 200) {
            if (y1 >= 10 && y1 <= 300 && y2 >= 10 && y2 <= 300) {
                System.out.print("(" + x1 + ", " + y1 + ") (" + x2 + ", " + y2 + ") 사각형은 (10, 10) (200, 300) 사각형에 포함된다.");
            } else {
                System.out.print("(" + x1 + ", " + y1 + ") (" + x2 + ", " + y2 + ") 사각형은 (10, 10) (200, 300) 사각형에 포함되지 않는다.");
            }
        } else {
            System.out.print("(" + x1 + ", " + y1 + ") (" + x2 + ", " + y2 + ") 사각형은 (10, 10) (200, 300) 사각형에 포함되지 않는다.");
        }

    }
}
