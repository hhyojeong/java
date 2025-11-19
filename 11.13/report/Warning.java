package report;

/*
    툴바에 그림과 같이 학번을 입력하는 텍스트필드 컴포넌트를 삽입하고 툴바를 프레임의 하단에 부착하라.
    이 텍스트필드 컴포넌트에는 오직 숫자만이 입력되도록 하기 위해 사용하는 숫자가 아니 키를 입력하면 그림과 같은 경고 메시지를 가진 경고창을 출력하도록 하라.
    그림에는 20170304 뒤에 f키가 입력된 경우  출력되는 경고창을 보여준다.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Warning extends JFrame {

    public Warning() {
        super("숫자가 아닌 키가 입력되는 경우 경고창 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        setLayout(new BorderLayout());

        JToolBar toolBar = new JToolBar();
        JTextField studentIdField = new JTextField(8);

        toolBar.add(new JLabel("  학번: ")); // 레이블 추가
        toolBar.add(studentIdField);
        add(toolBar, BorderLayout.SOUTH);

        studentIdField.addKeyListener(new KeyAdapter() {
            // **이 부분을 수정해야 합니다: KeyType -> keyTyped**
            @Override // @Override 어노테이션을 사용하여 오타를 방지하는 것이 좋습니다.
            public void keyTyped(KeyEvent e) { // <-- 이 메서드 이름이 정확해야 합니다.
                char inputChar = e.getKeyChar();

                // 백스페이스(지우기)는 허용하면서 숫자가 아닌 경우를 체크
                if (!Character.isDigit(inputChar) && inputChar != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // 키 입력을 무시하여 텍스트 필드에 입력되지 않게 함
                    showWarningMessage(inputChar); // 경고창 출력
                }
            }
        });
        setVisible(true);
    }

    private void showWarningMessage(char invalidKey) {
        // 1. 메시지 컴포넌트 생성 (아이콘과 텍스트 포함)

        // 아이콘 생성 (ERROR_MESSAGE에 해당하는 붉은 X 아이콘)
        Icon icon = UIManager.getIcon("OptionPane.errorIcon");
        JLabel iconLabel = new JLabel(icon);

        // 메시지 텍스트 (좌측 정렬)
        String text = "<html><p style='padding:5px;'>"+invalidKey+"는 숫자키가 아닙니다."+"<br>"+"숫자를 입력하세요.</p></html>";
        JLabel messageLabel = new JLabel(text);

        // 2. 메시지 패널 구성 (아이콘 + 텍스트)
        JPanel messagePanel = new JPanel(new BorderLayout(10, 0)); // 10px 간격
        messagePanel.add(iconLabel, BorderLayout.WEST); // 아이콘 왼쪽
        messagePanel.add(messageLabel, BorderLayout.CENTER); // 텍스트 중앙

        // 3. '확인' 버튼 생성
        JButton confirmButton = new JButton("확인");

        // 4. 버튼을 담을 패널 생성 및 중앙 정렬 설정 (FlowLayout.CENTER)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(confirmButton);

        // 5. 다이얼로그(경고창) 생성
        JDialog dialog = new JDialog(this, "경고", true); // 모달 다이얼로그 (부모 창 멈춤)

        // 6. 다이얼로그에 컴포넌트 추가
        Container contentPane = dialog.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(messagePanel, BorderLayout.NORTH); // 메시지 상단
        contentPane.add(buttonPanel, BorderLayout.SOUTH); // 버튼 하단

        // 7. 버튼 클릭 시 다이얼로그 닫기 리스너 추가
        confirmButton.addActionListener(e -> {
            dialog.dispose();
        });

        // 8. 다이얼로그 설정 및 표시
        dialog.pack(); // 컴포넌트에 맞춰 크기 조정
        dialog.setLocationRelativeTo(this); // 부모 프레임 중앙에 위치
        dialog.setVisible(true);
    }

        public static void main(String[] args){
            // GUI는 이벤트 디스패치 스레드(EDT)에서 실행하는 것이 안전합니다.
            SwingUtilities.invokeLater(() -> {
                new Warning();
            });
        }

}
