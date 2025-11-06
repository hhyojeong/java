package in_class;

import javax.swing.*;

//JFrame을 상속 받은 MyFrame
public class MyFrame extends JFrame {

    public MyFrame() {
        //타이틀 작성
        setTitle("300x300 스윙 프레임 만들기");

        //타이틀 크기 지정
        setSize(300, 300);
        //프레임 화면에 출력
        setVisible(true);
    }

    public static void main(String[] args){
        //MyFrame 객체, 스윙 프레임 생성
        MyFrame mf = new MyFrame();
    }
}
