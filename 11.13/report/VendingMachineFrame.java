package report;

/*
    커피 자판기 시뮬레이터를 작성해보자.
    커피 자판기 시뮬레이터는 실제 커피 자판기의 기능을 축소화하여 다음 기능을 가진다.
    -커피의 종류는 커피만 들어가 있는 Black Coffee,
     커피와 설탕이 들어있는 Sugar Coffee,
     커피, 설탕, 크림이 모두 들어있는 Dabang Coffee의 3가지로 한다.
    -화면에는 컵, 커피, 물, 설탕, 크림의 현재 양을 보여주며 커피를 뽑을 때마다 이 값들이 모두 조절된다.
    -Rest 버튼을 두고, 이 버튼을 누르면 컵, 커피, 물, 설탕, 크림이 통에 가득채워진다.
    -커피를 선택하였을 때 재료가 부족하면 커피를 먹을 수 없다고 경고창을 출력한다.
    -커피를 선택하였을 때 커피 이미지를 출력하고 경고창을 이용하여 알린다.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VendingMachineFrame extends JFrame {

    // 중앙 패널을 재료를 표시하는 내부 클래스 Coffee_로 지정합니다.
    private Coffee_ centerPanel;

    public VendingMachineFrame() {
        setTitle("Open Challenge 14: Welcome, Hot Coffee!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // 1. North Panel (상단)
        JPanel northPanel = createNorthPanel();
        add(northPanel, BorderLayout.NORTH);

        // 2. Center Panel (중앙): 내부 클래스 Coffee_ 객체 생성
        centerPanel = new Coffee_();
        add(centerPanel, BorderLayout.CENTER);

        // 3. South Panel (하단)
        JPanel southPanel = createSouthPanel();
        add(southPanel, BorderLayout.SOUTH);

        setSize(600, 500);
        setVisible(true);
    }

    private JPanel createNorthPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        JLabel titleLabel = new JLabel("Welcome, Hot Coffee!!!");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(titleLabel);
        return panel;
    }

    private JPanel createSouthPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton blackBtn = new JButton("Black Coffee");
        JButton sugarBtn = new JButton("Sugar Coffee");
        JButton dabangBtn = new JButton("Dabang Coffee");
        JButton resetBtn = new JButton("Reset");

        // ActionListener 부착 (재료 요구량: 커피, 물, 설탕, 크림)
        blackBtn.addActionListener(new CoffeeButtonListener(0, 1, 1, 0, 0)); // Coffee 1, Water 1
        sugarBtn.addActionListener(new CoffeeButtonListener(1, 1, 1, 1, 0)); // Coffee 1, Water 1, Sugar 1
        dabangBtn.addActionListener(new CoffeeButtonListener(2, 2, 1, 1, 1)); // Coffee 2, Water 1, Sugar 1, Cream 1
        resetBtn.addActionListener(new ResetButtonListener());

        panel.add(blackBtn);
        panel.add(sugarBtn);
        panel.add(dabangBtn);
        panel.add(new JSeparator(SwingConstants.VERTICAL));
        panel.add(resetBtn);

        return panel;
    }

    // 커피 버튼 이벤트 리스너 클래스
    private class CoffeeButtonListener implements ActionListener {
        private int type;
        private int reqCoffee, reqWater, reqSugar, reqCream;

        public CoffeeButtonListener(int type, int c, int w, int s, int cr) {
            this.type = type;
            this.reqCoffee = c;
            this.reqWater = w;
            this.reqSugar = s;
            this.reqCream = cr;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean isEnough = centerPanel.coffee >= reqCoffee &&
                    centerPanel.water >= reqWater &&
                    centerPanel.sugar >= reqSugar &&
                    centerPanel.cream >= reqCream;

            if (isEnough) {
                centerPanel.coffee -= reqCoffee;
                centerPanel.water -= reqWater;
                centerPanel.sugar -= reqSugar;
                centerPanel.cream -= reqCream;

                centerPanel.makeCoffee(type);
                // 🔔 성공 메시지 수정
                JOptionPane.showMessageDialog(VendingMachineFrame.this, "뜨거워요 즐거운하루", "커피 제조 성공", JOptionPane.INFORMATION_MESSAGE);

            } else {
                // 🔔 실패 메시지 수정
                JOptionPane.showMessageDialog(VendingMachineFrame.this, "부족한 것 있습니다. 채워주세요", "재료 부족", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    // Reset 버튼 이벤트 리스너 클래스
    private class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            centerPanel.resetMaterials();
            JOptionPane.showMessageDialog(VendingMachineFrame.this, "재료통을 가득 채웠습니다.", "Reset", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class Coffee_ extends JPanel {
        private int coffeeType = -1;
        private final int Max = 10;

        public int coffee = Max;
        public int water = Max;
        public int sugar = Max;
        public int cream = Max;

        // 💡 클래스 로더를 이용한 이미지 로드 (가장 확실한 방법)
        private ImageIcon cupIcon;
        private ImageIcon coffeeIcon;

        public Coffee_(){
            setBackground(Color.WHITE);
            setLayout(null);

            // 생성자에서 이미지 로드
            try {
                // 리소스 경로가 유효하지 않으면 NullPointerException 발생 가능
                cupIcon = new ImageIcon(getClass().getResource("/report/cup.png"));
                coffeeIcon = new ImageIcon(getClass().getResource("/report/coffee.png"));
            } catch (NullPointerException e) {
                // 이미지 파일을 찾지 못하면 오류 메시지 출력 (디버깅용)
                System.err.println("FATAL ERROR: Image resource not found. Check if cup.png and coffee.png are in the 'report' folder.");
                // 임시로 빈 아이콘 설정
                cupIcon = new ImageIcon();
                coffeeIcon = new ImageIcon();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            int panelWidth = getWidth();
            int panelHeight = getHeight();
            int boxWidth = panelWidth / 6;
            int boxHeight = panelHeight / 3 * 2;
            int startX = panelWidth / 10;
            int startY = panelHeight / 5;

            // 재료 통 그리기
            drawMaterialBox(g2, startX, startY, boxWidth, boxHeight, coffee, "Coffee", Color.BLACK);
            drawMaterialBox(g2, startX + boxWidth, startY, boxWidth, boxHeight, water, "Water", Color.BLUE);
            drawMaterialBox(g2, startX + boxWidth * 2, startY, boxWidth, boxHeight, sugar, "Sugar", Color.YELLOW);
            drawMaterialBox(g2, startX + boxWidth * 3, startY, boxWidth, boxHeight, cream, "Cream", new Color(255, 204, 153));

            // 컵 이미지 출력
            // 💡 이미지 로드가 성공했을 때만 그리기 시도
            if (cupIcon.getImage() != null && cupIcon.getIconWidth() > 0) {
                int cupX = panelWidth - startX - cupIcon.getIconWidth();
                int cupY = (panelHeight - cupIcon.getIconHeight()) / 2;
                g2.drawImage(cupIcon.getImage(), cupX, cupY, this);

                // 커피 이미지 출력
                if (coffeeType != -1 && coffeeIcon.getImage() != null && coffeeIcon.getIconWidth() > 0) {
                    int coffeeWidth = coffeeIcon.getIconWidth() / 2;
                    int coffeeHeight = coffeeIcon.getIconHeight() / 2;
                    // 이미지를 컵 위치에 맞게 조정합니다.
                    g2.drawImage(coffeeIcon.getImage(), cupX + 20, cupY + 60, coffeeWidth, coffeeHeight, this);
                }
            }
        }

        private void drawMaterialBox(Graphics2D g2, int x, int y, int w, int h, int current, String label, Color color) {
            // 겉 테두리
            g2.setColor(Color.DARK_GRAY);
            g2.drawRect(x, y, w, h);

            // 채워진 부분
            int filledHeight = (int) ((double) current / Max * h);
            int filledY = y + h - filledHeight;

            g2.setColor(color);
            g2.fillRect(x, filledY, w, filledHeight);

            // 잔량 텍스트
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("Arial", Font.BOLD, 14));
            g2.drawString(label, x + w/2 - g2.getFontMetrics().stringWidth(label)/2, y - 5);
            g2.drawString(String.valueOf(current), x + w/2 - g2.getFontMetrics().stringWidth(String.valueOf(current))/2, y + h + 15);
        }

        // 재료를 최대로 채우는 메소드
        public void resetMaterials() {
            coffee = water = sugar = cream = Max;
            repaint();
        }

        // 커피 제조 후 재료 감소 및 상태 변경
        public void makeCoffee(int type) {
            this.coffeeType = type;
            repaint();

            // 커피 이미지 잠시 후 사라지게 하는 스레드
            new Thread(() -> {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {}
                this.coffeeType = -1;
                repaint();
            }).start();
        }
    }

    // 메인 함수
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VendingMachineFrame());
    }
}