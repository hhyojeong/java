/*

사용자가 입력하는 8자리 정수는 생일을 나타낸다.
예를 들어 20010316은 2001년 3월 16일을 뜻한다.
Scanner 클래스의 nextInt( )메소드를 이용하여 8자리 정수를 압력받고 년도/월/일을 나누어 출력하라.
8자리 정수가 입력되지 않는 경우는 고려하지 않아도 된다.
*/

import java.util.Scanner;

public class Birthday {
    public static void main(String[] args){

        System.out.print("생일을 입력하세요 >> ");
        Scanner scn = new Scanner(System.in);

        int birthday = scn.nextInt();

        int Y = birthday/10000;
        int M =birthday%10000/100;
        int D = birthday%10000%100;
        System.out.println(Y + "년"+ M + "월"+ D +"일");

        scn.close();
    }

}
