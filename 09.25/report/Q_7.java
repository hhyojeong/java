package report.Chapter_4;

/* - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - -

 1개의 메모 정보를 담는 Memo 클래스를 작성하라.
 Memo는 생성자르 비롯하여 다음과 같은 필드와 메소드르 가진다.
  -String 타입의 name, time, cont필드               // 메모자, 메모시점, 메모텍스트
  -bloolena is SameName( )                       //메모 작성자가 같으면 true 리턴, 아니면 false리턴
  -void show ( )                                 //메모출력
  -int length( )                                 //메모 텍스트의 길이 리턴

     Memo 객체를 생성하고 다루는 Main와 실행예시는 다음과 같다.
 - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - */

/* - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - */

class Memo {
    String name;            //메모 작성자
    String time;            //메모 시정
    String content;         //메모 텍스트

    //name 생성자
    public Memo(String name, String time, String content) {
        this.name = name;
        this.time = time;
        this.content = content;
    }

    boolean isSameName(Memo other) {
        return this.name.equals(other.name);
    }

    public String getName() {
        return name;
    }

    void show() {
        System.out.println(name + ", " + time + " " + content );
    }

    public int length() {
        return this.content.length();
    }
}
/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

public class Q_7 {
    public static void main(String[] args){
        Memo a = new Memo("유송연", "10:10", "자바 과제 있음");
        Memo b = new Memo("박채원", "10:15", "시카고 어학 연수가요!");
        Memo c = new Memo("김경미", "11:30", "사랑하는 사람이 생겼어요");

        a.show();
        if(a.isSameName(b)) System.out.println("동일한사람입니다.");
        else System.out.println("다른 사람입니다.");
        System.out.println(c.getName() + "가 작성한 메모의 길이는 "  +  c.length());
    }
}

/* - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - */