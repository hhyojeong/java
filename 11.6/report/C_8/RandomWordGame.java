package report;

/*
 여러패널과 컴포넌트를 가진 스윙 응용프로그램을 만들어보자.
 컨텐트팬에 BorderLayout 배치 관리자를 설치하고, NORTH, CENTER, SOUTH 영역에는 JPanel을 상속받은 패널을 붙인다.
 NORTH 패널에는 1개의 JLabel을 이용하여 "단어 조합 게임!..." 문자열을 부착하고, 1개의 JButton을 이용하여 "new Text" 버튼을 부착한다.
 그리고 SOUTH 패널에는 미리 준비된 문장 "I can't help falling in love with you"을 단어들로 분리하고, 각 단어를 CENTER 패널 내 랜덤한 위치에 배치한다..
 이때 x의 범위는 0~ 350.y의 범위는 0 ~ 180 사이로 한다. 프레임의 크기는 400 x 300으로한다.
 이 문제는 단어 게임의 GUI를 만드는 과정만 구현한다.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RandomWordGame extends JFrame {
    private JPanel wordPanel = new JPanel(); // 단어를 표시할 패널
    private JButton newTextButton = new JButton("New Text");
    private JTextField nameField = new JTextField(15);
    private String text = "I can't help falling in love with you";
    private Random random = new Random();

    public RandomWordGame() {
        setTitle("Open Challenge 9");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 🔹 NORTH: "New Text" 버튼
        JPanel northPanel = new JPanel();
        northPanel.add(newTextButton);
        add(northPanel, BorderLayout.NORTH);

        // 🔹 CENTER: 단어 패널
        wordPanel.setLayout(null); // 자유 배치
        add(wordPanel, BorderLayout.CENTER);

        // 🔹 SOUTH: 이름 입력 필드
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.YELLOW);
        southPanel.add(new JLabel("이름"));
        southPanel.add(nameField);
        add(southPanel, BorderLayout.SOUTH);

        // 🔹 버튼 클릭 시 단어 재배치
        newTextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showWordsRandomly();
            }
        });

        setSize(400, 300);
        setVisible(true);
    }

    private void showWordsRandomly() {
        wordPanel.removeAll(); // 기존 단어 지움

        String[] words = text.split(" ");
        for (String w : words) {
            JLabel label = new JLabel(w);
            int x = random.nextInt(380 - 10) + 10; // 10~380
            int y = random.nextInt(180 - 10) + 10; // 10~180
            label.setSize(label.getPreferredSize());
            label.setLocation(x, y);
            wordPanel.add(label);
        }

        wordPanel.repaint();
    }

    public static void main(String[] args) {
        new RandomWordGame();
    }
}