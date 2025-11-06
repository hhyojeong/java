package report;
/*
 n명이 함께하는 겜블링 게밍을 만들어보자.
 실행예시와 같이 게임에 참여하는 선수수를 입력받는다.
 그리고 순서대로 각 선수가 <Enter>키를 입력하면 1~3 사이의 랜덤한 정수 3개를 출력하고 모두 일치하면 승자가된다.
 각 선수는 Player 클래스를 구현하고 게임 전체는 GameblingGame 클래스를  구현하라.
*/

import java.util.Scanner;

public class GamblingGame {
    private Player [] players;
    Scanner scanner = new Scanner(System.in);

    public GamblingGame() {
        System.out.print("갬블링 게임에 참여할 선수 숫자>>");

        int nPlayers = scanner.nextInt();
        scanner.nextLine();

        players = new Player[nPlayers];
        for(int i=0; i<players.length; i++) {
            System.out.print((i+1)+"번째 선수 이름>>");
            players[i] = new Player(scanner.nextLine());
        }
    }

    public void run() {
        int i=0;

        while (true) {
            if (players[i].turn()) {
                System.out.println(players[i].getName()+"님이 이겼습니다!");
                break;
            }
            else {
                System.out.println("아쉽군요!");
                i++;
                i = i%players.length;
            }
        }
    }

    public static void main(String[] args) {
        GamblingGame game = new GamblingGame();
        game.run();
    }
}