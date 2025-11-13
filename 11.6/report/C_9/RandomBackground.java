package report;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/*
 실행 예시를 참고하여 스윙 프로그램을 작성하라.
 'm'키를 입력할 때마다 80x80 크기의 블록을 (100,100) 위치에 랜덤한 배경색으로 만들고,
 만들어진 모든 블록들은 마우스로 드레깅하면 원하는 위치로 이동시킬 수 있게 한다.
*/

public class RandomBackground extends JFrame {
    private Container contentPane;
    private Random random = new Random();

    public RandomBackground() {
        // 1. 프레임 기본 설정
        setTitle("블록 생성 및 드래그");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);


        contentPane = getContentPane();
        contentPane.setLayout(null);


        contentPane.addKeyListener(new MyKeyListener());

        contentPane.setFocusable(true);
        contentPane.requestFocus();

        setVisible(true); // 프레임 보이기
    }

    /**
     * 'm' 키 입력을 감지하는 내부 클래스 (KeyAdapter 사용)
     */
    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            // 'm' 키가 눌렸는지 확인
            if (e.getKeyChar() == 'm') {
                // 새로운 블록을 생성하는 메소드 호출
                createNewBlock();
            }
        }
    }

    /**
     * 새로운 블록(JLabel)을 생성하고 컨테일에 추가하는 메소드
     */
    private void createNewBlock() {
        // 1. 새 JLabel 생성
        JLabel newBlock = new JLabel();

        // 2. 랜덤 배경색 생성
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        newBlock.setBackground(new Color(r, g, b));
        newBlock.setOpaque(true);


        newBlock.setSize(80, 80);
        newBlock.setLocation(100, 100);

        MyMouseDragListener dragListener = new MyMouseDragListener();
        newBlock.addMouseListener(dragListener);
        newBlock.addMouseMotionListener(dragListener);


        contentPane.add(newBlock);

        contentPane.revalidate();
        contentPane.repaint();
    }

    class MyMouseDragListener extends MouseAdapter implements MouseMotionListener {

        private Point offset; // 클릭 위치와 블록 좌상단 모서리 간의 차이

        @Override
        public void mousePressed(MouseEvent e) {
            // 1. 클릭된 블록(JLabel) 객체 가져오기
            Component pressedComp = e.getComponent();

            // 2. (개선) 클릭된 블록을 맨 앞으로 가져오기
            contentPane.setComponentZOrder(pressedComp, 0);

            // 3. 클릭된 위치(e.getPoint())를 offset으로 저장
            offset = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            // 1. 드래그 중인 블록 객체 가져오기
            Component draggedComp = e.getComponent();

            Point containerMousePos = draggedComp.getParent().getMousePosition();

            if (containerMousePos == null) {

                return;
            }

            int newX = containerMousePos.x - offset.x;
            int newY = containerMousePos.y - offset.y;

            draggedComp.setLocation(newX, newY);


        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RandomBackground();
            }
        });
    }
}
