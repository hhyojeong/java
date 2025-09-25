package report.Chapter3;

/*
  사용자로부터 "남" 혹은 "여"를 입력받아, 남자 또는 여자의 이름을 작명하는 프로그램을 작성하라.
  다음 실행 예시와 같이 "그만"을 입력하면 프로그램은 종료한다.

  ***** 작명 프로그램이 실행됩니다. *****
  남/여 선택>>여
  성 입력>>하
  추천 이름: 하여린
  남/여 선택>>여
  성 입력>>김
  추천 이름: 김하진
  남/여 선택>>남
  성 입력>>홍
  추천 이름: 홍민우
  남/여 선택>>야야야
  남/여/그만 중에서 입력하세요!
  남/여 선택>>그만

 */

import java.util.Random;
import java.util.Scanner;

public class Question_12 {

    public static void main(String[] args) {
        Random r = new Random();
        Scanner scn = new Scanner(System.in);

        String boyMiddleList[] = {"기","민","용","종","현","진","재","승","소","상","지"};
        String boyLastList[] = {"태","진","광","혁","우","철","반","준","구","호","석"};
        String girlMiddleList[] = {"은","원","경","수","현","예","여","송","서","채","하"};
        String girlLastList[] = {"진","연","경","서","리","숙","미","원","린","희","수"};

        String gender, first, middle, last;
        int indexM, indexL;

        System.out.println("***** 작명 프로그램이 실행됩니다. *****");
        while(true) {
            System.out.print("남/여 선택>>");
            gender = scn.next();

            switch(gender) {
                case "남" :
                case "여" :
                    System.out.print("성 입력>>");
                    first = scn.next();

                    System.out.print("추천 이름: ");
                    if(gender.equals("남")) {
                        indexM = r.nextInt(boyMiddleList.length);
                        indexL = r.nextInt(boyLastList.length);

                        System.out.println(first + boyMiddleList[indexM] + boyLastList[indexL]);
                    }
                    else {
                        indexM = r.nextInt(girlMiddleList.length);
                        indexL = r.nextInt(girlLastList.length);

                        System.out.println(first + girlMiddleList[indexM] + girlLastList[indexL]);
                    }
                    break;

                case "그만" :
                    scn.close();
                    System.exit(0);

                default :
                    System.out.println("남/여/그만 중에서 입력하세요!");
            }
        }
    }

}
