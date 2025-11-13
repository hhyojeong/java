package report;

/*
  컨텐트팬에 버튼을 5개 부착하고, 모든 버튼의 표면에 0을 출력하고, 각 버튼이 클릭될 때마다
 클릭 횟수를 증가시켜 표면을 갱신하는 스윙 프로그램을 작성하라.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Btn extends JFrame {
    public Btn() {
        setTitle("클릭 횟수 카운트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 활성화

        Container c = getContentPane();
        c.setLayout(new FlowLayout()); // 버튼을 가로로 배치하는 FlowLayout 사용

        // 3. 5개의 버튼 생성 및 이벤트 리스너 추가
        for (int i = 0; i < 5; i++) {
            // 버튼 생성, 초기 텍스트는 "0"
            JButton button = new JButton("0");

            // 4. 각 버튼에 ActionListener (이벤트 처리기) 추가
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 1. 이벤트가 발생한 버튼 객체 가져오기
                    JButton clickedButton = (JButton) e.getSource();

                    // 2. 버튼의 현재 텍스트(숫자) 가져오기
                    String currentText = clickedButton.getText();

                    // 3. 텍스트를 정수로 변환
                    int count = Integer.parseInt(currentText);

                    // 4. 카운트 1 증가
                    count++;

                    // 5. 증가된 값을 다시 문자열로 변환하여 버튼 텍스트로 설정
                    clickedButton.setText(Integer.toString(count));
                }
            });

            // 5. 컨텐트 팬에 버튼 추가
            c.add(button);
        }

        setSize(450, 150);
        setVisible(true); // 프레임을 화면에 보이게 함
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Btn();
            }
        });
    }

}
