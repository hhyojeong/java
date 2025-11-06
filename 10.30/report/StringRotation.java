package report;
/*
 문자열을 입력받아 실행예시와 같이 한글자씩 회전시키는 프로그램을 작성하라.
*/

import java.util.Scanner;

public class StringRotation {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        System.out.println("문자열을 입력하세요. 빈 칸이 있어도 되고 영어 한글 모두 됩니다.");
        String str = scn.nextLine();

        for(int i = 0; i<=str.length(); i++){
            System.out.print(str.substring(i));
            System.out.println(str.substring(0, i));
        }
    scn.close();
    }
}
