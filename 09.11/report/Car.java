/*

자동차 제어 장치에는 자동차의 상태를 나타내는 정수형 변수가 있다.
이 변수의 각 비트는 다음과 같이 자동차의 상태를 나타낸다고하자.

-> 비트0 ~5 : 현재 자동차 내 온도 값으로, 십진수로는 0 ~ 31
-> 비트6 : 값이 0이면 에어컨이 꺼져있는 상태, 1이면 켜져있는 상태
-> 비트7 : 값이 0이면 자동차 전기가 정지상태, 1이면 달리는 상태
-> 비트8 : 아무 의미 없음

예를 들어, 자동차의 상태를 나타내는 정수형 변수의 값이 139라면, 이 값은 이진수로 10001011이므로
비트 7의 값이 1이고, 비트 6의 값이 0이면 비트 0~5의 값이 십진수로 11이다.
그러므로 자동차는 '달리는 상태'이고 에어컨은 '꺼진상태'이며 차내 온도는 '11도'이다.
자동차 상태를 나타내는 정수를 입력받아 자동차의 상태를 화면에 출력하는 프로그램을 작성하라.

 */

import java.util.Scanner;

public class Car {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("자동차 상태입력 >> ");
        int car_status = scn.nextInt();

        if((car_status & 128) != 0) System.out.print("자동차는 달리는 상태이고");
            else System.out.print("자동차는 정지 상태이고");

        if((car_status & 64) != 0) System.out.print("에어컨은 켜진 상태이고");
            else System.out.print("에어컨은 꺼진 상태이고");

        int temp = car_status & 63;
        System.out.print("온도는 " + temp + "도 이다.");
        scn.close();
    }
}
