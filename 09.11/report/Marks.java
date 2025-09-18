/*

출석 점수가 총 100점일 때, 지각하면 3점 감점, 결석하면 8점을 감점시킨다.
다음 실행 사례와 같이 이름, 지각횟수, 결석횟수 순으로 입력할 때,
두 학생 중 누구의 출석 점수가 높은지 판단하는 프로그램을 작성하라.
점수가 같은 경우 "점수 동일"이라고 출력하라.

 */

import java.util.Scanner;


public class Marks {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("학생1 >> ");
        String a_name = scn.next();
        int a_perception = scn.nextInt();
        int a_absence = scn.nextInt();
        int a_total = 100 - a_absence - a_perception;

        System.out.print("학생2 >> ");
        String b_name = scn.next();
        int b_perception = scn.nextInt();
        int b_absence = scn.nextInt();
        int b_total = 100 - b_absence - b_perception;

       System.out.println(a_name+ "의 감점은 " + a_total + "," + b_name + "의 감점은 " + b_total);

        if(a_total == b_total){
            System.out.print("점수가 동일합니다.");
        } else if (a_total > b_total) {
            System.out.print(a_name+"의 출석 점수가 더 높음."+ a_name + "출석 점수는 "+ a_total );
        }else {
            System.out.print(b_name + "의 출석 점수가 더 높음." + b_name + "출석 점수는 " + b_total);
        }

    }
}
