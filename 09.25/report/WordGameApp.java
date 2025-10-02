import java.util.Scanner;

class Player {
    String name;             // 접근 제어자 뺌
    Scanner scanner = new Scanner(System.in);

    Player(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    String getWordFromUser() {
        System.out.print(name + " >> ");
        return scanner.next();
    }
}

public class WordGameApp {
    Player[] players;
    Scanner scanner = new Scanner(System.in);

    void run() {
        System.out.println("끝말잇기 게임을 시작합니다...");
        System.out.print("게임에 참가하는 인원은 몇 명입니까>> ");
        int n = scanner.nextInt();
        players = new Player[n];

        // 참가자 이름 입력
        for (int i = 0; i < n; i++) {
            System.out.print("참가자의 이름을 입력하세요>> ");
            String name = scanner.next();
            players[i] = new Player(name);
        }

        System.out.println("시작하는 단어는 아버지입니다.");
        String prevWord = "아버지";

        int turn = 0; // 순서
        while (true) {
            Player currentPlayer = players[turn % n];
            String newWord = currentPlayer.getWordFromUser();

            if (!checkSuccess(prevWord, newWord)) {
                System.out.println(currentPlayer.getName() + "이(가) 졌습니다.");
                break;
            }
            prevWord = newWord;
            turn++;
        }
    }

    boolean checkSuccess(String prevWord, String newWord) {
        int lastIndex = prevWord.length() - 1;
        char lastChar = prevWord.charAt(lastIndex);
        char firstChar = newWord.charAt(0);
        return lastChar == firstChar;
    }

    public static void main(String[] args) {
        WordGameApp game = new WordGameApp();
        game.run();
    }
}
