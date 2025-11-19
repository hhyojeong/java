package report;

/*
    튤바를 만들고 "종료"버튼을 하나 단다. 이버턴을 선택하면 JOptionPane을 이용하여
    YES_NO_OPTION에 "정말 종료하시겠습니까?" 메시지를 출력하는 학인 다이얼로 그를 출력하라.
    그리고 사용자가 "예(Y)"로 답한 경우에만 응용프로그램을 종료하는 스윙응용프로그램을 작성하라.
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YesOrNo  extends JFrame {
    public YesOrNo(){
        super("종료 확인 다이얼로그");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(400,150);
        setLayout(new BorderLayout());

        JToolBar toolBar = new JToolBar();
        JButton exitButton = new JButton("종료");

        toolBar.add(exitButton);
        add(toolBar, BorderLayout.NORTH);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showExitConfirmationDialog();
            }
        });

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                showExitConfirmationDialog();
            }
        });
        setVisible(true);
        }

    private void showExitConfirmationDialog() {
        // JOptionPane.showConfirmDialog를 사용하여 YES/NO 옵션의 다이얼로그를 띄움
        int result = JOptionPane.showConfirmDialog(
                this,                               // 부모 컴포넌트
                "정말 종료하시겠습니까?",            // 메시지
                "프로그램 종료 확인",                 // 제목
                JOptionPane.YES_NO_OPTION,          // 옵션 타입 (예/아니오 버튼)
                JOptionPane.QUESTION_MESSAGE        // 메시지 타입 (아이콘: 질문)
        );

        // 사용자가 "예" (YES_OPTION)를 선택한 경우에만 프로그램 종료
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0); // 응용프로그램 종료
        }
    }
    public static void main(String[] args) {
        // 이벤트 디스패치 스레드에서 실행
        SwingUtilities.invokeLater(() -> {
            new YesOrNo();
        });
    }

}
