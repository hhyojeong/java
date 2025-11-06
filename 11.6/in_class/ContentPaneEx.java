package in_class;

import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame {
    public ContentPaneEx(){

        //프레임 타이틀 달기
        setTitle("ContenPane과 JFrame 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //컨텐트팬 알아내기
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.ORANGE);    //오렌지 배경 설정
        contentPane.setLayout(new FlowLayout());    //컨텐트팬에 FlowLayout 배치관리자 달기

        contentPane.add(new JButton("OK")); //ok 버튼
        contentPane.add(new JButton("close"));  //cancel 버튼
        contentPane.add(new JButton("Ignore")); //lgnore 버튼

        setSize(300, 150);  //프레임 크기 300 150
        setVisible(true); //화면 출력
    }

    public static void main(String[] args){
        new ContentPaneEx();
    }
}
