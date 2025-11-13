package in_class;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.MalformedURLException;

public class RadioEx extends JFrame {
    public RadioEx() throws MalformedURLException {
        setTitle("라디오버튼 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        URL selectedCarUrl = new URL("https://cdn-icons-png.flaticon.com/512/5639/5639841.png");
        URL selectedShipUrl = new URL("https://cdn-icons-png.flaticon.com/512/1553/1553424.png");
        URL selectedAirplaneUrl = new URL("https://cdn-icons-png.flaticon.com/512/7893/7893979.png");

        ImageIcon originalselectedCar = new ImageIcon(selectedCarUrl);
        ImageIcon originalselectedShip = new ImageIcon(selectedShipUrl);
        ImageIcon originalselectedAirplane = new ImageIcon(selectedAirplaneUrl);

        Image selectedImg1 = originalselectedCar.getImage();
        Image selectedImg2 = originalselectedShip.getImage();
        Image selectedImg3 = originalselectedAirplane.getImage();

        int size = 50;
        Image scaledSelectedImg1 = selectedImg1.getScaledInstance(size, size, Image.SCALE_SMOOTH);
        Image scaledSelectedImg2 = selectedImg2.getScaledInstance(size, size, Image.SCALE_SMOOTH);
        Image scaledSelectedImg3 = selectedImg3.getScaledInstance(size, size, Image.SCALE_SMOOTH);

        ImageIcon carIcon = new ImageIcon(scaledSelectedImg1);
        ImageIcon shipIcon = new ImageIcon(scaledSelectedImg2);
        ImageIcon airplaneIcon = new ImageIcon(scaledSelectedImg3);

        ButtonGroup g = new ButtonGroup();

        JRadioButton car = new JRadioButton("자동차", null);
        JRadioButton ship = new JRadioButton("선박", null);
        JRadioButton airplane = new JRadioButton("비행기", null);

        car.setSelectedIcon(carIcon);
        ship.setSelectedIcon(shipIcon);
        airplane.setSelectedIcon(airplaneIcon);

        car.setSelected(true);

        g.add(car);
        g.add(ship);
        g.add(airplane);

        c.add(car);
        c.add(ship);
        c.add(airplane);

        setSize(250, 150);
        setVisible(true);

    }
    public static void main(String[] args) {
        // main 메소드에서 MalformedURLException을 처리
        try {
            // Look and Feel을 Nimbus로 설정하여 아이콘이 더 잘 보이도록 함
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            new RadioEx();
        } catch (MalformedURLException e) {
            System.err.println("URL 형식이 잘못되었습니다: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
