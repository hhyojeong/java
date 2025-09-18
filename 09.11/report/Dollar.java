/*

Scanner 클래스를 이용하여 달러를 입력받아 실행 사례와 같이 원화로 바꾸는
프로그램을 작성하라.$1=1200

 */

import java.util.Scanner;

public class Dollar {
    public static void main(String[] args){
        System.out.println("$1=1200원입니다.");
        Scanner scn = new Scanner(System.in);

        System.out.print("달러를 입력하세요 >> ");
        int dollar = scn.nextInt();

        System.out.println("$"+dollar+"는 "+ dollar*1200 + "입니다.");
    scn.close();
    }
}
