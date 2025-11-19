package report;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/*
    메뉴를 이용하여 오디오를 연주하는 프로그램을 작성하라.
    "오디오"메뉴에 "연주"와 "종료" 메뉴 아이템을 두고, "연주" 메뉴아이템이 선택되면 JFileChooser를 이용하여 wav 파일을 선택하여 연주를 시작하고,
    "종료" 메뉴아이템이 선ㄴ택되면 연주를 종료한다.
*/

public class AudioSelect extends JFrame {
    private Clip audioClip;
    private JLabel statusLabel = new JLabel("오디오 파일을 선택하세요", JLabel.CENTER);

    public AudioSelect() {
        super("오디오 파일을 찾아 연주/종료 제어");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new BorderLayout());

        statusLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        add(statusLabel, BorderLayout.CENTER);

        // 1. 메뉴바 설정
        setJMenuBar(createMenuBar());

        // 2. 창 닫기 시 자원 해제
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                stopAudio(); // 종료 전에 오디오 중지
                dispose();
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu audioMenu = new JMenu("오디오");

        JMenuItem playItem = new JMenuItem("연주");
        JMenuItem stopItem = new JMenuItem("종료");

        // 리스너 연결
        playItem.addActionListener(e -> startAudio());
        stopItem.addActionListener(e -> stopAudio());

        audioMenu.add(playItem);
        audioMenu.add(stopItem);
        menuBar.add(audioMenu);

        return menuBar;
    }

    private void startAudio() {
        // 기존 클립이 있다면 중지하고 닫습니다.
        stopAudio();

        // JFileChooser를 사용하여 WAV 파일 선택
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("오디오 파일 선택");

        // 파일 필터 설정 (wav, au, mid, rmf)
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Audio Files(wav, au, mid, rmf)", "wav", "au", "mid", "rmf");
        chooser.setFileFilter(filter);

        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            try {
                // 새로운 클립 로드 및 재생
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(selectedFile);
                audioClip = AudioSystem.getClip();
                audioClip.open(audioStream);

                audioClip.loop(Clip.LOOP_CONTINUOUSLY); // 반복 재생

                // 상태 업데이트
                statusLabel.setText(selectedFile.getName() + " 연주하고 있습니다.");

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                statusLabel.setText("오디오 파일을 재생할 수 없습니다.");
                JOptionPane.showMessageDialog(this,
                        "오디오 파일(" + selectedFile.getName() + ") 로드 또는 재생 오류.",
                        "오디오 오류", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        } else {
            // 파일 선택이 취소된 경우
            statusLabel.setText("오디오 파일 선택이 취소되었습니다.");
        }
    }

    private void stopAudio() {
        if (audioClip != null) {
            if (audioClip.isRunning()) {
                audioClip.stop(); // 재생 중인 경우 정지
            }
            audioClip.close(); // 클립 자원 해제
            audioClip = null; // 참조 해제
            statusLabel.setText("연주가 종료되었습니다.");
        } else {
            statusLabel.setText("현재 연주 중인 오디오가 없습니다.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AudioSelect();
        });
    }
}
