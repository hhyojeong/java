package report;

/*
    패널에 paintComponent()를 이용하여 이미지를 그리는 2개의 문제이다.
    1) FlowLayout 배치 관리자를 가진 패널의 바탕 크기에 일치하도록 "back.jpg"
    이미지를 출력하고 그 위에 "Hide/Show" 버튼이 보이도록 프로그램을 작성하라.
    이 문제는 그래픽과 컴포넌트를 동시에 사용할 수 있음을 보여주기 위한 것이다.
    2) "Hide/Show" 버튼이 클릭되면 이미지가 보이게 하고 다시 클릭하면 안보이게 하라.
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;

public class Q_1 extends JFrame{
    private ImageIcon backgroundIcon;
    private boolean showImage = true;
    private JButton toggleButton;

    public Q_1() {
        setTitle("Hide/Show Image Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        URL imgUrl = getClass().getResource("cat.png");

        if (imgUrl != null) {
            backgroundIcon = new ImageIcon(imgUrl);
        } else {
            JOptionPane.showMessageDialog(this, "back.jpg 파일이 없습니다.");
        }

        JPanel panel = new JPanel(new FlowLayout()) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // 이미지가 로드되었고, showImage가 true일 때만 그리기
                if (showImage && backgroundIcon != null) {
                    g.drawImage(backgroundIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        toggleButton = new JButton("Hide/Show");
        toggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showImage = !showImage; // true <-> false 전환
                panel.repaint();        // 화면 다시 그리기 요청
            }
        });

        panel.add(toggleButton);

        add(panel);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Q_1();
    }
}