package report;

/*
    GridLayoutEx에서 샐행결과와 같이 각 버튼의 배경색을 서로 다르게
*/

import javax.swing.*;
import java.awt.*;

public class GridLayoutColorEx {
    JFrame f;
    Color [] colors = {Color.red, Color.orange, Color.yellow,
            Color.green, Color.cyan, Color.blue, Color.magenta,
            Color.gray, Color.pink, Color.lightGray};


    public GridLayoutColorEx() {
        f = new JFrame("GridLayout으로 10개의 버튼을 배치한 프레임");
        buildGUI();
        f.setSize(600,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private void buildGUI() {
        f.setLayout(new GridLayout(1, 10));
        for(int i=0; i<10; i++) {
            JButton btn = new JButton(Integer.toString(i));
            btn.setBackground(colors[i]);
            f.add(btn);
        }
    }
    public static void main(String[] args) {
        try {
            // Nimbus L&F를 적용하여 색상 표시 문제를 해결
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            // Nimbus를 찾지 못할 경우 기본 L&F를 사용
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        new GridLayoutColorEx();
    }
}
