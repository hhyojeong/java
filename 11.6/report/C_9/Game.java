package report;

/*
    어릴 적 구슬치기를 하던 생각이 난다. 구슬들을 주먹으로 쥐고 홀인지 짝인지 맞추는 게임이다.
    이 게임을 실행 예시와 같이 스윙으로 작성하라.
    프로그램이 실행되면 '?'가 출력된 박스에 1에서 10 사이의 정수를 숨기면, 사용자가 이 정수가 홀인지 짝인지 맞추는 게임이다.
    그림 (a)는 초기에 출력된 화면이며 '?'의 박스에는 랜덤하게 생성된 정수(현재 3)가 숨겨져 있다. 그림(b)에서
    사용자가 "홀"이라고 판단되면, "홀"버튼과 "확인"버튼을 순차적으로 누르면 된다. 이경우 숨겨진 정수가 3이므로 성공한 경우이다.
    (c)는 숨겨진 정수가 5인 경우로, 사용자가 "짝"버튼과 "확인"버튼을 순차적으로 누르는 경우, 실패하게 된다.
    그림 (d)는 "홀"이나 "짝"버튼을 누르지 않고 "확인"버튼을 누른 경우로, "홀이나 짝 먼저 선택"을 출력하여 경고한다.
    언제든 "다시" 버튼을 누르면 '?'의 박스에 새로운 랜덤한 정수를 숨겨둔다.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Game extends JFrame {
    public Game() {
        // 1. 프레임 기본 설정
        setTitle("홀짝 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 230); 


        setContentPane(new GamePanel());


        setVisible(true);
    }


    class GamePanel extends JPanel implements ActionListener {

        private int hiddenNumber;
        private String userBet = null;
        private Random random = new Random();

        // GUI 컴포넌트 선언
        private JLabel numberLabel;
        private JLabel messageLabel;
        private JButton oddButton;
        private JButton evenButton;
        private JButton confirmButton;
        private JButton againButton;

        public GamePanel() {
            setLayout(new BorderLayout());

            numberLabel = new JLabel("?", SwingConstants.CENTER); // 텍스트 중앙 정렬
            numberLabel.setFont(new Font("맑은 고딕", Font.BOLD, 48)); // 폰트 크게
            numberLabel.setOpaque(true); // 배경색을 칠하기 위해 Opaque 설정
            numberLabel.setBackground(Color.LIGHT_GRAY); // (a)의 박스 색상
            numberLabel.setPreferredSize(new Dimension(100, 100)); // 크기 고정
            add(numberLabel, BorderLayout.NORTH);


            messageLabel = new JLabel("무엇일까요?", SwingConstants.CENTER);
            messageLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
            add(messageLabel, BorderLayout.CENTER);

            JPanel southPanel = new JPanel();
            oddButton = new JButton("홀");
            evenButton = new JButton("짝");
            confirmButton = new JButton("확인");
            againButton = new JButton("다시");

            oddButton.addActionListener(this);
            evenButton.addActionListener(this);
            confirmButton.addActionListener(this);
            againButton.addActionListener(this);

            southPanel.add(oddButton);
            southPanel.add(evenButton);
            southPanel.add(confirmButton);
            southPanel.add(againButton);
            add(southPanel, BorderLayout.SOUTH);

            startNewGame();
        }

        private void startNewGame() {

            hiddenNumber = random.nextInt(100) + 1;
            numberLabel.setText("?");
            numberLabel.setBackground(Color.LIGHT_GRAY);
            messageLabel.setText("무엇일까요?");
            userBet = null;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "홀":
                    userBet = "홀";
                    messageLabel.setText("홀 선택됨");
                    break;

                case "짝":
                    userBet = "짝";
                    messageLabel.setText("짝 선택됨");
                    break;

                case "확인":
                    if (userBet == null) {
                        messageLabel.setText("홀이나 짝 먼저 선택");
                        return;
                    }

                    numberLabel.setText(Integer.toString(hiddenNumber));

                    boolean isHiddenOdd = (hiddenNumber % 2 != 0);

                    if ((isHiddenOdd && userBet.equals("홀")) ||
                            (!isHiddenOdd && userBet.equals("짝"))) {
                        messageLabel.setText("맞았어요.");
                        numberLabel.setBackground(Color.GREEN); // 정답 표시
                    }
                    else {
                        messageLabel.setText("아쉽군요");
                        numberLabel.setBackground(Color.PINK); // 오답 표시
                    }
                    break;

                case "다시":
                    startNewGame();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Game();
            }
        });
    }
}
