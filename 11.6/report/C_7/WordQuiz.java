package report;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

// 단어와 뜻을 저장하는 클래스
class Word {
    private String english;
    private String korean;

    public Word(String english, String korean) {
        this.english = english;
        this.korean = korean;
    }

    public String getEnglish() {
        return english;
    }

    public String getKorean() {
        return korean;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Word word = (Word) obj;
        return english.equals(word.english);
    }
}


public class WordQuiz {
    private Vector<Word> wordVector;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public WordQuiz() {
        wordVector = new Vector<>();
        initWords();
    }

    // 17개의 단어 저장 함수
    private void initWords() {
        wordVector.add(new Word("human", "인간"));
        wordVector.add(new Word("painting", "그림"));
        wordVector.add(new Word("bear", "곰"));
        wordVector.add(new Word("eye", "눈"));
        wordVector.add(new Word("picture", "사진"));
        wordVector.add(new Word("society", "사회"));
        wordVector.add(new Word("love", "사랑"));
        wordVector.add(new Word("animal", "동물"));
        wordVector.add(new Word("flower", "꽃"));
        wordVector.add(new Word("apple", "사과"));
        wordVector.add(new Word("book", "책"));
        wordVector.add(new Word("car", "자동차"));
        wordVector.add(new Word("tree", "나무"));
        wordVector.add(new Word("excellent", "훌륭한"));
        wordVector.add(new Word("king", "왕"));
        wordVector.add(new Word("queen", "여왕"));
        wordVector.add(new Word("computer", "컴퓨터"));
    }

    // 퀴즈 실행 로직
    public void run() {
        System.out.println("\"명품영어\"의 영어 단어 테스트를 시작합니다. -1 입력하면 종료합니다.");

        while (true) {
            // 단어 리스트가 4개 미만이면 퀴즈를 진행할 수 없습니다.
            if (wordVector.size() < 4) {
                System.out.println("퀴즈를 위한 단어가 부족합니다. (최소 4개 필요)");
                break;
            }

            // 1. 퀴즈에 사용할 4개의 단어 (정답 1개 + 오답 3개)를 무작위로 선택
            Vector<Word> quizWords = new Vector<>();
            Vector<Word> tempVector = new Vector<>(wordVector);

            Collections.shuffle(tempVector);

            // 앞에서부터 4개를 뽑아서 quizWords에 넣습니다.
            for (int i = 0; i < 4; i++) {
                quizWords.add(tempVector.get(i));
            }

            // 2. 퀴즈의 정답 단어 설정 (퀴즈 단어 중 하나)
            int answerIndexInQuiz = random.nextInt(4);
            Word answerWord = quizWords.get(answerIndexInQuiz);

            // 3. 퀴즈 보기의 순서를 무작위로 섞습니다.
            Collections.shuffle(quizWords);

            // 4. 문제 출력 및 사용자 입력 받기
            System.out.println(answerWord.getEnglish() + "? ");

            // 보기 출력
            for (int i = 0; i < 4; i++) {
                System.out.printf("(%d)%s ", i + 1, quizWords.get(i).getKorean());
            }
            System.out.print(":>");

            try {
                int userChoice = scanner.nextInt();

                // 종료 조건
                if (userChoice == -1) {
                    System.out.println("\"명품영어\"를 종료합니다...");
                    break;
                }

                // 입력된 보기는 1~4번이므로 인덱스는 0~3
                int choiceIndex = userChoice - 1;

                // 입력 유효성 검사 추가
                if (choiceIndex < 0 || choiceIndex > 3) {
                    continue;
                }

                // 사용자가 선택한 보기에 해당하는 단어
                Word selectedWord = quizWords.get(choiceIndex);

                // 5. 정답 판정
                if (selectedWord.equals(answerWord)) {
                    System.out.println("Excellent !!");
                } else {
                    System.out.println("No !!");
                }

            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해 주세요.");
                scanner.nextLine(); // 입력 버퍼 비우기
            }
        } // ⭐ while 루프 닫기

        scanner.close();
    } // ⭐ run() 메서드 닫기

    public static void main(String[] args) {
        WordQuiz quiz = new WordQuiz();
        quiz.run();
    }
}
