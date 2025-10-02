package report.Chapter_4;

/*

Gread는 한 학생의 점수를 나타내느 클래스이다.
이름과 3개의 과목 점수를 각각 입력받아 Grade 객체를 생성하고
성적의 평균을 출력하sms main()과 실행예시를 다음과 같다.
main()을 포함하는 Grade 클래스를 작성하라.

 */


import java.util.Scanner;


class Grade {
    String name;
    int java, web, os;

    public Grade  (String name, int java, int web, int os){
        this.name = name;
        this.java = java;
        this.web = web;
        this.os = os;
    }

    public String  getName(){
        return name;
    }

    public int getAverage(){

        int sum;
        sum = java + web + os;
        return sum /3;
    }

}

public class Q_3 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("이름, 자바, 웹프로그래밍, 운영체제 순으로 점수를 입력 >> ");
        String name = scn.next();
        int java = scn.nextInt();
        int web = scn.nextInt();
        int os = scn.nextInt();
        Grade st = new Grade(name, java, web, os);
        System.out.print(st.getName() + "의 평균은 "+ st.getAverage());
        scn.close();
    }
}
