package report;

/*
    프로그램이 시작되면 바로 오디오를 재생하라.
    그리고 마우스가 프로그램을 벗어나면 연주를 일시 중단시키고, 다시 마우스가 프로그램으로 올라오면 연주를 계속하도록 하라.
*/

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Audio extends JFrame {

    private Clip audioClip;
    private long clipTimePosition = 0; // 정지된 시점의 재생 위치 저장

    public Audio() {
        super("오디오 재생/일시중단 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLayout(new BorderLayout());

        // 텍스트 레이블 (상태 표시용)
        JLabel statusLabel = new JLabel("audiohiphop.wav 재생 준비", JLabel.CENTER);
        statusLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        add(statusLabel, BorderLayout.CENTER);

        // 오디오 클립 초기화 및 재생
        try {
            // 프로젝트 루트 또는 실행 위치에 audiohiphop.wav 파일이 있어야 합니다.
            File audioFile = new File("audiohiphop.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);

            // 1. 프로그램 시작 시 오디오 재생
            audioClip.loop(Clip.LOOP_CONTINUOUSLY); // 반복 재생
            statusLabel.setText("audiohiphop.wav 연주 계속 (마우스가 컨텐트팬 내부에 있음)");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            statusLabel.setText("오디오 파일 로드 오류: audiohiphop.wav를 확인하세요.");
            e.printStackTrace();
            return;
        }

        // 2. 마우스 이벤트 리스너 추가 (MouseAdapter 사용)
        // JFrame의 ContentPane에 리스너를 붙여 창 전체 영역을 감지
        getContentPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                // 3. 마우스가 프로그램 영역을 벗어날 경우 (정지)
                if (audioClip != null && audioClip.isRunning()) {
                    clipTimePosition = audioClip.getMicrosecondPosition(); // 현재 재생 위치 저장
                    audioClip.stop(); // 재생 정지
                    statusLabel.setText("audiohiphop.wav 연주 일시 중단 (마우스가 컨텐트팬을 벗어남)");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // 4. 마우스가 프로그램 영역으로 들어올 경우 (재생 계속)
                if (audioClip != null && !audioClip.isRunning()) {
                    audioClip.setMicrosecondPosition(clipTimePosition); // 저장된 위치로 이동
                    audioClip.start(); // 재생 시작
                    statusLabel.setText("audiohiphop.wav 연주 계속 (마우스가 컨텐트팬 내부에 있음)");
                }
            }
        });

        setVisible(true);
    }

    // 프로그램 종료 시 오디오 자원 해제
    @Override
    public void dispose() {
        if (audioClip != null) {
            audioClip.stop();
            audioClip.close();
        }
        super.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Audio();
        });
    }
}