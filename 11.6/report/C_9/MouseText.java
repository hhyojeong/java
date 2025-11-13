package report;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseText extends JFrame {
    MouseText(){
        setTitle("마우스 올리기 내리기 예제"); // 제목 지정
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 닫기 버튼을 눌렀을 시 화면 닫기

        JLabel label = new JLabel("Love Java");

        // Jabel 컴포넌트 생성 후 MouseListener를 단다.
        label.addMouseListener(new MyMouseAdapter());

        label.setSize(200,50);
        add(label);
        setSize(400,200);
        setVisible(true);

    }
    public static void main(String[] args) {
        new MouseText();
    }

}
// MouseAdapter를 상속 받는 MyMouseAdapter 클래스
class MyMouseAdapter extends MouseAdapter {
    public void mouseEntered(MouseEvent e) {
        // 마우스가 label 컴포넌트 위에 올라왔을 때
        JLabel l = (JLabel)e.getSource();
        l.setText("Love Java");
    }
    public void mouseExited(MouseEvent e) {
        // 컴포넌트 위에 올라온 마우스가 컴포넌ㄴ트를 벗어났을 때
        JLabel l = (JLabel)e.getSource();
        l.setText("사랑해 자바");
    }
}
