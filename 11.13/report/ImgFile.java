package report;


/*
    "파일" 메뉴에 "열기" 메뉴 아이템을 하나 만든다.
    이 메뉴 아이템을 선택하면 파일 열기 다이얼로그를 출력하고 사용자가 JPG 이미지 파일을
    선택하면 이미지 프레임의 바탕화면 전체(컨텐츠팬)에 그리는 스윙 응용프로그램을 작성하라.
    이미지를 그리기 위해서 JLabel을 이용하지 말고 Graphics의 drawImage() 메소드를 이용하라.

*/


import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ImgFile extends JFrame {
    // 이미지를 그릴 커스텀 패널
    private ImagePanel imagePanel;

    public ImgFile() {
        setTitle("메뉴로 배경 이미지 로딩하기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        // JLabel 대신 이미지를 그릴 ImagePanel을 생성하고 추가합니다.
        imagePanel = new ImagePanel();
        c.add(imagePanel, BorderLayout.CENTER);

        createMenu();
        setSize(350, 300); // 크기를 조금 늘렸습니다.
        setVisible(true);
    }

    private void createMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu fileMenu = new JMenu("파일");
        JMenuItem openItem = new JMenuItem("열기");

        // 리스너 등록
        openItem.addActionListener(new OpenActionListener());
        fileMenu.add(openItem);
        mb.add(fileMenu);
        setJMenuBar(mb);
    }

    // 이미지를 그리는 데 사용될 커스텀 JPanel
    class ImagePanel extends JPanel {
        private Image img; // 그려질 이미지 객체

        // 외부(ActionListener)에서 이미지를 설정할 수 있도록 public 메소드 제공
        public void setImage(Image img) {
            this.img = img;
        }

        // JPanel이 다시 그려져야 할 때(repaint() 호출 시) 스윙에 의해 자동 호출됨
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // 부모 클래스의 paintComponent 먼저 호출 (패널 초기화)
            if (img != null) {
                // 패널의 전체 크기에 맞춰 이미지를 그립니다.
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    // "열기" 메뉴 아이템의 액션 리스너
    class OpenActionListener implements ActionListener {
        private JFileChooser chooser;

        public OpenActionListener() {
            chooser = new JFileChooser();
        }

        // 'aactionPerformed' -> 'actionPerformed'로 오타 수정
        @Override
        public void actionPerformed(ActionEvent e) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "JPG Images", // 요구사항에 맞게 JPG만 필터링
                    "jpg", "jpeg");
            chooser.setFileFilter(filter);

            // 다이얼로그를 프레임(ImgFile.this) 중앙에 표시
            int ret = chooser.showOpenDialog(ImgFile.this);
            if (ret != JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(ImgFile.this, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 선택된 파일의 경로로 ImageIcon을 생성하고, ImageIcon에서 Image 객체를 얻음
            String filePath = chooser.getSelectedFile().getPath();
            Image newImage = new ImageIcon(filePath).getImage();

            // ImagePanel에 이미지를 설정
            imagePanel.setImage(newImage);

            // ImagePanel을 다시 그리도록 요청 (paintComponent가 호출됨)
            imagePanel.repaint();
        }
    }

    public static void main(String[] args) {
        new ImgFile();
    }
}
