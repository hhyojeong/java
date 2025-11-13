package in_class;


import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.MalformedURLException;

public class RadioButtonEx extends JFrame {
    public RadioButtonEx() throws MalformedURLException {
        setTitle("라디오버튼 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        URL cherryUrl = new URL("https://cdn-icons-png.flaticon.com/512/4416/4416670.png" );
        URL selectedCherryUrl = new URL("https://cdn-icons-png.flaticon.com/512/766/766023.png");

        ImageIcon originalcherryIcon = new ImageIcon(cherryUrl);
        ImageIcon originalselectedcherryIcon = new ImageIcon(selectedCherryUrl);

        Image img = originalcherryIcon.getImage();
        Image selectedImg = originalselectedcherryIcon.getImage();

        int size = 50;
        Image scaledImg = img.getScaledInstance(size, size, Image.SCALE_SMOOTH);
        Image scaledSelectedImg = selectedImg.getScaledInstance(size, size, Image.SCALE_SMOOTH);
        ImageIcon cherryIcon = new ImageIcon(scaledImg);
        ImageIcon selectedcherryIcon = new ImageIcon(scaledSelectedImg);

        JRadioButton cherry = new JRadioButton("체리", cherryIcon);
        cherry.setSelectedIcon(selectedcherryIcon);

        ButtonGroup g = new ButtonGroup();

        JRadioButton apple = new JRadioButton("사과");
        JRadioButton pear = new JRadioButton("배", true);

        cherry.setBorderPainted(true);
        cherry.setSelectedIcon(selectedcherryIcon);

        g.add(apple);
        g.add(pear);
        g.add(cherry);

        c.add(apple);
        c.add(pear);
        c.add(cherry);

        setSize(250, 150);
        setVisible(true);

    }

    public static void main(String[] args) {
        try {
            new RadioButtonEx();
        } catch (MalformedURLException e) {
            System.err.println("URL 형식이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();
        }
    }
}