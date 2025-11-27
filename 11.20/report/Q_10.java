package report;
/*
    paintComponent() 를 사용하여 이미지를 패널에 출력할 때 4등분하고, 서로 상, 하, 좌, 우 10픽셀씩
    떨어져서 그려지도록 하라. 이미지는 컴포넌트를 사용하지 말고 그래픽으로만 구현하라. 동일한 이미지를 4번 로딩하여도 안된다.
    GridLayout을 사용해도 안된다.
*/

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Q_10 extends JFrame {
    private Image image;

    public Q_10() {
        setTitle("Image Split into 4 Parts ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        URL imgUrl = getClass().getResource("save.png");

        if (imgUrl != null) {
            ImageIcon icon = new ImageIcon(imgUrl);
            image = icon.getImage(); // Image 객체로 추출
        } else {
            // 파일을 찾지 못했을 때 안내
            JOptionPane.showMessageDialog(this,
                    "이미지 파일(save.png)을 report 폴더에서 찾을 수 없습니다.",
                    "경로 오류",
                    JOptionPane.ERROR_MESSAGE);
        }

        // MediaTracker는 getResource()를 사용할 경우 불필요하거나 복잡도를 높여서 제거했습니다.
        // 대신 paintComponent 안에서 이미지가 로드되었는지 확인합니다.

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // 이미지가 없거나, 로딩이 완료되지 않아 크기를 알 수 없다면 종료
                if (image == null || image.getWidth(this) < 0 || image.getHeight(this) < 0) {
                    g.drawString("이미지를 로딩할 수 없습니다.", 50, 50);
                    return;
                }

                int imgW = image.getWidth(this);
                int imgH = image.getHeight(this);

                // 원본 이미지를 4등분
                int halfW = imgW / 2;
                int halfH = imgH / 2;

                // 각 부분을 10픽셀씩 떨어져서 출력
                int offset = 10;

                // 목적지 X, Y 좌표 계산 (가독성을 위해 변수화)
                int leftX = offset;
                int rightX = offset + halfW + offset;
                int topY = offset;
                int bottomY = offset + halfH + offset;
                int destW = halfW;
                int destH = halfH;

                // 1. 왼쪽 위 (원본: 0, 0 ~ halfW, halfH)
                g.drawImage(image,
                        leftX, topY, leftX + destW, topY + destH, // 목적지
                        0, 0, halfW, halfH,                             // 원본
                        this);

                // 2. 오른쪽 위 (원본: halfW, 0 ~ imgW, halfH)
                g.drawImage(image,
                        rightX, topY, rightX + destW, topY + destH, // 목적지
                        halfW, 0, imgW, halfH,                           // 원본
                        this);

                // 3. 왼쪽 아래 (원본: 0, halfH ~ halfW, imgH)
                g.drawImage(image,
                        leftX, bottomY, leftX + destW, bottomY + destH, // 목적지
                        0, halfH, halfW, imgH,                           // 원본
                        this);

                // 4. 오른쪽 아래 (원본: halfW, halfH ~ imgW, imgH)
                g.drawImage(image,
                        rightX, bottomY, rightX + destW, bottomY + destH, // 목적지
                        halfW, halfH, imgW, imgH,                         // 원본
                        this);
            }
        };

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Q_10());
    }
}