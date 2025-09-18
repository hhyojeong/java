/*

분식점 가격 계산프로그램을 작성해보자.
떡볶이 1인분은 2000원, 김말이 1인분은 1000원, 쫄면 1인분은 3000원이다

*/

import java.util.Scanner;

public class Snack {

    public static void main(String[] args){
        System.out.println("**** 자바 분식입니다. 주문하면 금액을 알려드립니다. ****");
        Scanner scn = new Scanner(System.in);

        System.out.print("떡볶이 몇 인분 >> ");
        int D = scn.nextInt();
        int Dd = D*2000;

        System.out.print("김말이 몇 인분 >> ");
        int K = scn.nextInt();
        int Kk = K*1000;

        System.out.print("쫄면 몇 인분 >> ");
        int G = scn.nextInt();
        int Gg = G*3000;

        int T = Dd + Kk + Gg;

        System.out.println("전체금액은 " + T +"원입니다." );



    }
}
