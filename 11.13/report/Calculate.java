package report;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    "Calculat"버튼과 레이블을 가진 프레임을 작성하라. JDialog를 상속받아 CalcDialog 다이얼로그를 다음 그림과 같이 구현하고, "Calculate" 버튼을
    클릭하면 Calculatelog가 출력되도록하라. 사용자로부터 두 정수를 입력받고 "Add" 버턴을 클릭하면 그 결과값이 레이블에 출력되도록하라. CalDialog는 모달 다이얼로그로 만들어라.
*/

public class Calculate extends JFrame {
    private JLabel resultLabel = new JLabel("계산 결과 출력", JLabel.CENTER);
    private JButton calculateButton = new JButton("calculate");

    public Calculate() {
        super("다이얼로그 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);

        // 프레임 레이아웃 설정
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        // 컴포넌트 스타일 설정
        resultLabel.setPreferredSize(new Dimension(100, 25)); // 레이블 크기 지정
        resultLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // 경계선 추가

        // 컴포넌트 추가
        add(calculateButton);
        add(resultLabel);

        // Calculate 버튼 리스너
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // CalcDialog를 모달로 띄움
                // this (CalculationFrame)를 부모로 전달하여 결과를 받을 수 있게 함
                CalcDialog dialog = new CalcDialog(Calculate.this);
                dialog.setVisible(true); // 모달 다이얼로그 표시 (이 코드가 닫힐 때까지 멈춤)

                // 다이얼로그가 닫힌 후, 다이얼로그에서 받은 결과를 레이블에 출력
                int result = dialog.getResult();
                if (result != -1) { // -1은 계산이 취소되었거나 오류가 났음을 의미
                    resultLabel.setText(String.valueOf(result));
                }
            }
        });
        setVisible(true);
    }

    // main 메서드
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calculate();
        });
    }
}

class CalcDialog extends JDialog {
    private JTextField num1Field = new JTextField(5);
    private JTextField num2Field = new JTextField(5);
    private JButton addButton = new JButton("Add");

    private int resultValue = -1; // 계산 결과를 저장할 변수 (-1은 초기값 또는 오류)

    public int getResult() {
        return resultValue;
    }

    public CalcDialog(JFrame owner) {
        // JDialog(Frame owner, String title, boolean modal)
        super(owner, "Calculation Dialog", true); // true: 모달 다이얼로그 설정
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // 좌측 정렬 레이아웃

        // 텍스트 필드와 레이블 배치
        add(new JLabel("두 수를 더합니다.")); // 상단 텍스트

        JPanel inputPanel = new JPanel(new GridLayout(2, 1, 5, 5)); // 입력 필드를 위한 그리드 레이아웃
        inputPanel.add(num1Field);
        inputPanel.add(num2Field);
        add(inputPanel);

        // "Add" 버튼 배치
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 버튼만 중앙 정렬
        buttonPanel.add(addButton);
        add(buttonPanel);

        // "Add" 버튼 리스너
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAndClose();
            }
        });

        // 다이얼로그 설정
        pack(); // 내용에 맞춰 다이얼로그 크기 조정
        setLocationRelativeTo(owner); // 부모 프레임 중앙에 위치
    }

    private void calculateAndClose() {
        try {
            // 텍스트 필드의 값을 정수로 변환
            int num1 = Integer.parseInt(num1Field.getText().trim());
            int num2 = Integer.parseInt(num2Field.getText().trim());

            // 결과 저장
            resultValue = num1 + num2;

            // 다이얼로그 닫기
            dispose();

        } catch (NumberFormatException ex) {
            // 숫자가 아닌 값이 입력되었을 경우
            JOptionPane.showMessageDialog(this,
                    "유효하지 않은 숫자 입력입니다. 정수를 입력하세요.",
                    "입력 오류",
                    JOptionPane.ERROR_MESSAGE);
            resultValue = -1; // 결과 오류 표시
        }
    }
}
