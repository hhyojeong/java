/*

임베디드 컴퓨터에서는 변수의 각 비트를 장치의 상태를 나타내기 위해 사용한다.
예를 들어 냉장고의 상태를 나타내기 위해 8비트 정수 중 하위 4비트가 사용된다고 하자.

-> 비트0(최하위 비트) : 값이 0이면 전원이 꺼져있고 1이면 켜져있음
-> 비트1 : 값이 0이면 문이 열려있고, 1이면 닫혀있음
-> 비트2 : 값이 0이면 냉장고 전구가 손상된 상태이고, 1이면 정상작동
-> 비트3 : 값이 0이면 냉장고 온도가 3도 이상이고. 1이면 3도미만
-> 비트4 : 아무의미 없음

이때 다음 실행 예시와 같이 냉장고의 상태를 나타내는 8비트를 입력받고
하위 4비트를 분석하여 냉장고의 상태를 출력하는 프로그램을 작성하라.

 */


import java.util.Scanner;

public class Cumputer {
    public static void main(String[] args){
        Scanner scn =  new Scanner(System.in);
        System.out.print("냉장고 상태 입력 >> ");
        String str = scn.next();
        byte status = Byte.parseByte(str, 2);

        if((status & 0b00000001) != 0) System.out.print("전원 켜져 있음.");
            else System.out.print("전원 꺼져있음");

        if((status & 0b00000010) != 0) System.out.print("문이 닫혀있음");
            else System.out.print("문 열려있음");

        if((status & 0b00000100) != 0) System.out.print("냉장고 온도 3도 미만");
        else System.out.print("냉장고 온도 3도 이상");

        scn.close();
    }
}

