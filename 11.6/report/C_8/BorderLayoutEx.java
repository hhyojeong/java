package report;

/*
    BorderLayout을 사용하여 실행결과와 같이 동서남북에 각각 버튼을 사이의 수평 수직 간격이
    5픽셀, 7픽셀이 되도록 스윙 응용프로그램을 작성하라.
*/

import javax.swing.*;
import java.awt.*;

public class BorderLayoutEx {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout 배치 관리자 연습");
        frame.setLayout(new BorderLayout(5, 7));

        Container c = frame.getContentPane();
        c.setBackground(Color.YELLOW);

        c.add(new JButton("North"), BorderLayout.NORTH);
        c.add(new JButton("West"), BorderLayout.WEST);
        c.add(new JButton("Center"), BorderLayout.CENTER);
        c.add(new JButton("East"), BorderLayout.EAST);
        c.add(new JButton("South"), BorderLayout.SOUTH);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
