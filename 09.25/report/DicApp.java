package report.Chapter_4;

/*

다음과 같은 Dictionary 클래스가 있다.
실행 결과와 같이 작동하도록  Dictionary 클래스에 kor2eng() 메소드를 작성하고,
실행결과와 같이 출력하는 DicApp 클래스를 작성하라.

 */

import java.util.Scanner;

class Dictionary {

    private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String[] eng = {"love", "baby", "money", "future", "hope"};

    public static String kor2Eng(String word) {
        for(int i=0; i<kor.length; i++) {
            if(word.equals(kor[i])) {
                return (word+ "은 " + eng[i]);
            }
        }
        return (word + "는 저의 사전에 없습니다.");
    }
}

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

public class DicApp{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("한영 단어 검색프로그램입니다.");

        while (true) {
            System.out.print("한글 단어? ");
            String search = scn.next();
            if(search.equals("그만")) break;
            System.out.println(Dictionary.kor2Eng(search));
        }
        scn.close();

    }
}

