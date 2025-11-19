package report;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.*;


/*
    연주할 곡을 체크박스로 만들고 사용자가 체크한 곡만 순서대로 연주하는 프로그램을 작성하라.
    연주시작 버턴을 누르면 연주가 시작되고 다음곡에 대해서는 체크박스를 선택/해지 할 수 있다.
    연주되고있는 곡명의 글자색을 달리하는 것은 옵션이다. 연주끝 버턴을 누르면 연주가 멈추고, 연주시작 버튼을 누르면 처음부터 시작한다.
    연주될 wav 파일은 프로젝트의 audio 폴더에 두면된다.
*/

public class AudioPlayer extends JFrame {
    private final String AUDIO_DIR = "audio/"; // 오디오 파일이 있는 폴더 경로

    // UI 컴포넌트들
    private JCheckBox[] checkBoxes;
    private JLabel infoLabel = new JLabel("체크된 곡만 순서대로 한 번 연주합니다.", JLabel.CENTER);
    private JButton startButton = new JButton("연주 시작");
    private JButton stopButton = new JButton("연주 끝");

    // 오디오 제어 변수
    private Clip currentClip;
    private List<JCheckBox> playList; // 체크된 곡만 담는 재생 목록
    private int currentSongIndex = -1; // 현재 재생 중인 곡의 인덱스

    // 폰트 설정
    private final Font playingFont = new Font("맑은 고딕", Font.BOLD, 12);
    private final Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 12);

    public AudioPlayer() {
        super("오디오 연주");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLayout(new BorderLayout());

        // 1. 오디오 파일 목록
        String[] fileNames = {
                "audiowolf.wav",
                "audioidol_drums.wav",
                "audiosirenpolice.wav",
                "audiohiphop.wav"
        };

        // 2. 체크박스 패널 구성
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        checkBoxes = new JCheckBox[fileNames.length];
        for (int i = 0; i < fileNames.length; i++) {
            checkBoxes[i] = new JCheckBox(fileNames[i]);
            checkBoxes[i].setFont(defaultFont);
            if (i == 0 || i == 2) { // 실행 예시처럼 첫 번째와 세 번째는 기본 체크
                checkBoxes[i].setSelected(true);
            }
            mainPanel.add(checkBoxes[i]);
            mainPanel.add(Box.createVerticalStrut(5)); // 간격 추가
        }

        // 3. 버튼 패널 구성
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        // 4. 컴포넌트 배치
        add(infoLabel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // 5. 이벤트 리스너 설정
        startButton.addActionListener(e -> {
            stopAudio(false); // 기존 연주 중단 (재시작 위해)
            preparePlayList();
            currentSongIndex = -1; // 첫 곡부터 시작
            playNextSong();
        });

        stopButton.addActionListener(e -> stopAudio(true)); // 완전히 연주 끝

        setVisible(true);
    }

    private void preparePlayList() {
        playList = new ArrayList<>();
        for (JCheckBox cb : checkBoxes) {
            // 체크된 곡만 목록에 추가
            if (cb.isSelected()) {
                playList.add(cb);
            }
        }
        if (playList.isEmpty()) {
            infoLabel.setText("재생할 곡이 없습니다. 곡을 체크하세요.");
        }
    }

    private void playNextSong() {
        // 이전 곡의 글자색 초기화
        if (currentSongIndex >= 0 && currentSongIndex < playList.size()) {
            playList.get(currentSongIndex).setForeground(Color.BLACK);
            playList.get(currentSongIndex).setFont(defaultFont);
        }

        // 다음 곡 인덱스 증가
        currentSongIndex++;

        if (currentSongIndex < playList.size()) {
            JCheckBox nextSong = playList.get(currentSongIndex);
            File audioFile = new File(AUDIO_DIR + nextSong.getText());

            try {
                // 새로운 클립 로드 및 재생
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                currentClip = AudioSystem.getClip();
                currentClip.open(audioStream);

                // 현재 곡명을 붉은색/볼드체로 표시하여 연주 중임을 알림
                nextSong.setForeground(Color.RED);
                nextSong.setFont(playingFont);
                infoLabel.setText(nextSong.getText() + " 연주 중...");

                // 연주 시작
                currentClip.start();

                // 오디오 종료 리스너 추가: 오디오가 끝나면 다음 곡을 재생하도록 설정
                currentClip.addLineListener(e -> {
                    if (e.getType() == LineEvent.Type.STOP) {
                        // 오디오가 멈췄을 때 다음 곡을 재생 (Swing 스레드에서 실행)
                        SwingUtilities.invokeLater(() -> playNextSong());
                    }
                });

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                infoLabel.setText("오디오 파일 오류: " + nextSong.getText());
                ex.printStackTrace();
                // 오류 발생 시 다음 곡으로 넘어감
                SwingUtilities.invokeLater(() -> playNextSong());
            }
        } else {
            // 모든 곡 연주 완료
            currentClip = null;
            infoLabel.setText("모든 곡 연주 완료.");
        }
    }

    private void stopAudio(boolean isFinished) {
        if (currentClip != null) {
            if (currentClip.isRunning()) {
                currentClip.stop();
            }
            currentClip.close();
            currentClip = null;
        }

        // 현재 연주 중이던 곡의 글자색 초기화
        if (currentSongIndex >= 0 && currentSongIndex < playList.size()) {
            playList.get(currentSongIndex).setForeground(Color.BLACK);
            playList.get(currentSongIndex).setFont(defaultFont);
        }

        if (isFinished) {
            currentSongIndex = -1; // 완전히 종료 시 인덱스 초기화
            infoLabel.setText("연주가 중지되었습니다.");
        }
    }

    public static void main(String[] args) {
        // 오디오 경로가 없으면 생성하도록 안내 (편의상)
        File audioDir = new File("audio");
        if (!audioDir.exists()) {
            audioDir.mkdirs();
        }

        SwingUtilities.invokeLater(() -> {
            new AudioPlayer();
        });
    }
}
