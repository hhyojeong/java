package report.Q12;

/*

    다음은 '키'와 '값'의 두 문자열을 하나의 아이템으로 저장하는 추상 클래스 PairMap이다.
    put()은 '키'와 '값'을 저장하고 get()은 '키'로 검색하여 '값'을 리턴하는 메소드이다.

 */

import report.Q12.Dictionary;

public class DictionaryApp {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);
        dic.put("황기태", "자바");
        dic.put("이재문", "파이썬");
        dic.put("이재문", "C++"); // 값 수정
        System.out.println("이재문의 값은 " + dic.get("이재문"));
        System.out.println("황기태의 값은 " + dic.get("황기태"));
        dic.delete("황기태");
        System.out.println("황기태의 값은 " + dic.get("황기태"));
    }
}