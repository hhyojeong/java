package in_class;

import javax.swing.*;
import java.awt.*;

public class MyName extends JFrame {
    public MyName() {
        setTitle("내이름 출력하기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        setSize(500, 500);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);

            // "김"
            g.drawLine(50, 100, 100, 100);
            g.drawLine(100, 100, 100, 150);
            g.drawLine(120, 100, 120, 150);
            g.drawRect(60, 160, 50, 40);

            // "효"
            g.drawLine(220, 80, 220, 90);
            g.drawLine(200, 95, 240, 95);
            g.drawOval(205, 105, 30, 30);
            g.drawLine(210, 145, 210, 175);
            g.drawLine(230, 145, 230, 175);
            g.drawLine(180, 175, 260, 175);

            // "정"
            g.drawLine(300, 100, 360, 100);
            g.drawLine(330, 100, 300, 150);
            g.drawLine(330, 100, 360, 150);
            g.drawLine(370, 125, 390, 125);
            g.drawLine(390, 100, 390, 150);
            g.drawOval(320, 160, 50, 50);

            // ❤️ 하트 모양 추가
            g.setColor(Color.RED);
            int x = 400, y = 80; // 하트 위치
            // 왼쪽 원
            g.fillOval(x, y, 20, 20);
            // 오른쪽 원
            g.fillOval(x + 20, y, 20, 20);
            // 아래 삼각형
            int[] heartX = {x, x + 40, x + 20};
            int[] heartY = {y + 10, y + 10, y + 40};
            g.fillPolygon(heartX, heartY, 3);
        }
    }

    public static void main(String[] args) {
        new MyName();
    }
}