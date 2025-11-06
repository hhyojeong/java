package in_class;

/*
 책보고해서 예제 방식이 pdf파일과 마우스 이벤트 처리하는 좌포 위치가 다릅니다.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventAllEx extends JFrame {
    private JLabel la = new JLabel(" Move Me");

    public MouseEventAllEx(){
        setTitle("MouseListener와 MouseMotionListener 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        MouseListener listener = new MyMouseListener();
        c.addMouseListener((MouseListener)listener);
        c.addMouseMotionListener((MouseMotionListener)listener);

        c.add(la);
        setSize(300, 200);
        setVisible(true);
    }

    class MyMouseListener implements MouseListener, MouseMotionListener {

        public void mousePressed(MouseEvent e) {
            la.setText("mousePressed(" + e.getX() + "," + e.getY() + ")");
        }

        public void mouseReleased(MouseEvent e) {
            la.setText("mouseReleased(" + e.getX() + "," + e.getY() + ")");
        }

        public void mouseClicked(MouseEvent e) {}

        public void mouseEntered(MouseEvent e) {
            Component comp = (Component) e.getSource();
            comp.setBackground(Color.CYAN);
        }

        public void mouseExited(MouseEvent e) {
            Component comp = (Component) e.getSource();
            comp.setBackground(Color.YELLOW);
        }
        public void mouseDragged (MouseEvent e) {
            la.setText("mouseDragged(" + e.getX() + "," + e.getY() + ")");
        }
        public void mouseMoved (MouseEvent e){
                    la.setText("mouseMoved (" + e.getX() + "," + e.getY() + ")");
                }
            }
    public static void main(String[] args){
        new MouseEventAllEx();
    }
}