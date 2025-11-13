package in_class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL; // 리소스 로드를 위해 추가

public class ComboActionEx extends JFrame {
    private String [] fruits = {"apple", "banana", "kiwi", "mango"};

    // 파일 경로 배열은 유지
    private String [] fileNames = {
            "/in_class/1202063.png" ,
            "/in_class/6482627.png",
            "/in_class/5582717.png",
            "/in_class/3944211.png"
    };

    private ImageIcon [] images;
    private JLabel imgLabel; // 선언만
    private JComboBox <String> strCombo; // 선언만

    public ComboActionEx(){

        // 1. 🖼️ images 배열 초기화 및 이미지 로드 (가장 먼저 실행)
        images = new ImageIcon[fileNames.length];
        for (int i = 0; i < fileNames.length; i++) {
            URL url = getClass().getResource(fileNames[i]);
            if (url != null) {
                images[i] = new ImageIcon(url);
            } else {
                System.err.println("이미지 파일을 찾을 수 없습니다: " + fileNames[i]);
                images[i] = new ImageIcon(); // 빈 아이콘으로 대체
            }
        }

        // 2. 컴포넌트 초기화 (이미지가 로드된 후)
        imgLabel = new JLabel(images[0]); // 이제 images[0]에 유효한 값이 있음
        strCombo = new JComboBox<String>(fruits);

        setTitle("콤보박스 활용예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(strCombo);
        c.add(imgLabel);

        strCombo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> cd = (JComboBox<String>) e.getSource();
                int index = cd.getSelectedIndex();
                imgLabel.setIcon(images[index]);
            }
        });

        setSize(300, 250);
        setVisible(true);
    }
    public static void main(String[] args){
        new ComboActionEx();
    }
}