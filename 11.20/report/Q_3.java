package report;

/*
    JLabel 컴포넌트를 이용하여 이미지("apple.jpg")를 출력하고, 이미지 위에 마우스를 드래깅하여 이미지를
    이동시키는 프로그램을 작성하라.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class Q_3 extends JFrame{
    private JLabel imageLabel;
    private Point initialClick;
    public Q_3() {
        setTitle("Draggable Image Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(null);

        imageLabel = new JLabel(); // 레이블 먼저 생성

        URL imgUrl = getClass().getResource("apple.jpeg");

        if (imgUrl != null) {
            ImageIcon icon = new ImageIcon(imgUrl);
            imageLabel.setIcon(icon);
            // 아이콘 크기에 맞춰 레이블 크기 및 초기 위치 설정
            imageLabel.setBounds(100, 100, icon.getIconWidth(), icon.getIconHeight());
        } else {
            // 파일을 못 찾았을 때 안내 메시지 출력
            JOptionPane.showMessageDialog(this,
                    "이미지 파일(apple.jpg)을 찾을 수 없습니다! report 폴더에 넣어주세요.",
                    "오류",
                    JOptionPane.ERROR_MESSAGE);
            imageLabel.setText("Image Not Found");
            imageLabel.setBounds(100, 100, 150, 30); // 텍스트가 보이도록 크기 설정
        }

        imageLabel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int thisX = imageLabel.getLocation().x;
                int thisY = imageLabel.getLocation().y;

                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                int X = thisX + xMoved;
                int Y = thisY + yMoved;

                imageLabel.setLocation(X,Y);
            }
        });

        add(imageLabel);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Q_3();
    }
}