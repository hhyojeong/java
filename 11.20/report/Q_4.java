package report;

/*
    앞의 3번 문제를 수정하여 JLabel을 이용하지 않고, 컨텐트팬에 그래픽으로 이미지를 출력하도록 하라.
    그리고 3번 문제와 동일하게 이미지 영역 위에 마우스를 누르고 드래깅 하여 이미지를 이동시켜 보자.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class Q_4 extends JFrame {
    private Image image;
    private int imgX = 100; // 이미지 시작 X 좌표
    private int imgY = 100; // 이미지 시작 Y 좌표
    private int imgWidth = -1; // 이미지 너비 (초기값 -1)
    private int imgHeight = -1; // 이미지 높이 (초기값 -1)

    // 마우스 클릭 지점과 이미지 좌상단 간의 거리(Offset)를 저장하여 부드럽게 드래그합니다.
    private int xOffset;
    private int yOffset;
    private boolean dragging = false;

    public Q_4() {
        setTitle("Draggable Image without JLabel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // --------------------------------------------------------
        // [수정된 부분 1] 이미지 로딩: Toolkit 대신 ImageIcon/getResource 사용
        // --------------------------------------------------------
        // 문제 3번과 동일한 "apple.jpg" 파일이 report 폴더에 있다고 가정합니다.
        URL imgUrl = getClass().getResource("cat.png");

        if (imgUrl != null) {
            ImageIcon icon = new ImageIcon(imgUrl);
            image = icon.getImage(); // Image 객체로 추출
            imgWidth = icon.getIconWidth();
            imgHeight = icon.getIconHeight();
        } else {
            JOptionPane.showMessageDialog(this, "이미지 파일(apple.jpg)을 찾을 수 없습니다!");
        }

        // 커스텀 패널 생성
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // 이미지의 너비/높이가 정상적으로 로드되었을 때만 그립니다.
                if (image != null && imgWidth > 0) {
                    g.drawImage(image, imgX, imgY, this);
                }
            }
        };

        // 마우스 이벤트 처리
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                // 클릭 위치가 이미지 내부인지 확인 (imgWidth/Height가 -1이면 실행 안 함)
                if (imgWidth > 0 &&
                        mouseX >= imgX && mouseX <= imgX + imgWidth &&
                        mouseY >= imgY && mouseY <= imgY + imgHeight) {

                    dragging = true;
                    // 마우스 클릭 위치와 이미지 좌상단(imgX, imgY) 사이의 거리를 저장
                    xOffset = mouseX - imgX;
                    yOffset = mouseY - imgY;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dragging = false;
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragging) {
                    imgX = e.getX() - xOffset;
                    imgY = e.getY() - yOffset;

                    // initialClick을 갱신하던 코드를 삭제하여 이미지의 움직임이 튀는 현상을 방지했습니다.

                    panel.repaint();
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Q_4();
    }
}