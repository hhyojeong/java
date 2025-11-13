package report;
 /*
    스윙을 이용하여 실행결과 같은 GUI 모양의 계산기를 작성하라.
  */
import javax.swing.*;
import java.awt.*;

public class Calculate extends JFrame {
    public Calculate() {
        super("자바 스윙 계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildGUI();

        setSize(300, 300);
        setVisible(true);
    }

    private void buildGUI(){
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.add(new NorthPanel(),BorderLayout.NORTH);
        c.add(new CenterPanel(), BorderLayout.CENTER);
        c.add(new SouthPanel(), BorderLayout.SOUTH);
    }

    class NorthPanel extends JPanel {
        public NorthPanel() {
            setLayout(new FlowLayout());
            setOpaque(true);
            setBackground(Color.lightGray);
            add(new JLabel("수식"));
            add(new JTextField(15));
        }
    }
    class SouthPanel extends JPanel {
        public SouthPanel() {
            setLayout(new FlowLayout(FlowLayout.LEFT));
            setOpaque(true);
            setBackground(Color.yellow);
            add(new JLabel("계산 결과"));
            add(new JTextField(15));
        }
    }

    class CenterPanel extends JPanel {
        private JButton buttons[] = {
                new JButton("C"), new JButton("UN"), new JButton("BK"), new JButton("/"),
                new JButton("7"), new JButton("8"), new JButton("9"), new JButton("x"),
                new JButton("4"), new JButton("5"), new JButton("6"), new JButton("-"),
                new JButton("1"), new JButton("2"), new JButton("3"), new JButton("+"),
                new JButton("0"), new JButton("."), new JButton("="), new JButton("%")
        };

        public CenterPanel() {
            setLayout(new GridLayout(5,4,5,5));
            for(int i=0; i<20; i++) {
                add(buttons[i]);
            }
            buttons[18].setBackground(Color.cyan);
        }
    }

    public static void main(String[] args) {
        new Calculate();
    }
}

