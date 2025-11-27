package report;

/*
    "open.png" 이미지를 그래픽으로 컨텐트팬의
    (10, 10) 위치에 원본 크기로 그리고, + 키를 입력하면 10% 확대하고 -키를 입력하며너 이미지를 10%
    축소시키는 스윙 응용 프로그램을 작성하라.
    (요청에 따라 이미지는 cat.png를 사용합니다.)
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class Q_5 extends JFrame {
    private Image image;
    private double scale = 1.0; // 초기 배율 (100%)
    private int originalWidth = -1; // 이미지 원본 너비
    private int originalHeight = -1; // 이미지 원본 높이

    public Q_5() {
        setTitle("Image Zoom Example (고양이)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // --------------------------------------------------------
        // [수정된 부분 1] 이미지 로딩: getResource를 사용하여 report 폴더의 cat.png 로드
        // --------------------------------------------------------
        URL imgUrl = getClass().getResource("cat.png");

        if (imgUrl != null) {
            ImageIcon icon = new ImageIcon(imgUrl);
            image = icon.getImage();
            originalWidth = icon.getIconWidth();
            originalHeight = icon.getIconHeight();
        } else {
            // 이미지를 찾지 못했을 때 안내
            JOptionPane.showMessageDialog(this,
                    "이미지 파일(cat.png)을 찾을 수 없습니다! report 폴더에 넣어주세요.",
                    "오류",
                    JOptionPane.ERROR_MESSAGE);
            // 이미지를 못 찾으면 originalWidth/Height는 -1로 유지됩니다.
        }

        // 커스텀 패널 생성
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // 이미지가 정상적으로 로드되었을 때만 그립니다.
                if (image != null && originalWidth > 0) {
                    // 현재 배율에 따른 크기 계산
                    int drawWidth = (int)(originalWidth * scale);
                    int drawHeight = (int)(originalHeight * scale);

                    // (10, 10) 위치에 확대/축소된 크기로 출력
                    g.drawImage(image, 10, 10, drawWidth, drawHeight, this);
                }
            }
        };

        // --------------------------------------------------------
        // [수정된 부분 2] 키 이벤트 처리 시 Panel에 포커스가 유지되도록 설정
        // --------------------------------------------------------
        panel.setFocusable(true);
        panel.requestFocusInWindow();

        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Char 대신 KeyCode를 사용하는 것이 일반적이며 더 안전합니다.
                // 하지만 요청하신대로 Char를 사용하여 '+'와 '-' 키를 인식합니다.
                if (e.getKeyChar() == '+') {
                    scale += 0.1; // 10% 확대
                } else if (e.getKeyChar() == '-') {
                    scale -= 0.1; // 10% 축소
                    if (scale < 0.1) scale = 0.1; // 최소 크기 제한 (너무 작아지지 않도록)
                }
                panel.repaint(); // 변경된 배율로 다시 그리기 요청
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Q_5();
    }
}