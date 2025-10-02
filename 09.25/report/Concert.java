package report.Chapter_4;

import java.util.Scanner;

/*

 간단한 콘서트 예약 시스템을 만들어보자.
 다수의 클래스를 다루고 객체의 배열을 다루기에는 아직 자바 프로그램 개발이 익숙하지 않은 초보자에게 다소 무리가 있을 것이다.
 그러나 반드시 넘어야할 산이다.
 이 도전을 통해 산을 넘어갈 수 있는 체력을 키워보자. 예약시스템의 기능은 다음과 ㅏㄱㅌ다.
 ->공연은 하루에 한 번 있다
 ->촤적은 s석 a석 b석으로 나뉘며 각각 10개의 좌석이 있다.
 ->예약 시스템의 메뉴는 "예약", "조회", "조회", "끝내기"가 있다
 ->예약한 한자리만 가능하고, 좌석타입, 예약자 이름 좌석 번호를 순서대로 입력받아 예약한다.
 ->조회는 모든 좌석을 출력한다
 ->취소는 예약자의 이름을 입력받아 취소한다.
 ->없는 이름. 없는 번호, 없는 메뉴, 잘못된 취소 등에 대해서 오류 메시지를 출력하고 사용자가 다시 시도하로독 한다.

 */

class Seats {
    private String seat;

    public Seats() { seat = "---"; }
    public String getSeat() { return seat; }
    public void setSeat(String name) { seat = name; }
}

class Section {
    Seats seats[] = new Seats[10];

    public Section() {
        for (int i = 0; i < seats.length; i++)
            seats[i] = new Seats();
    }

    public void show() {
        for (int i = 0; i < seats.length; i++) {
            System.out.print(seats[i].getSeat() + " ");
        }
        System.out.println();
    }

    public void book(String name, int num) {
        if (num < 1 || num > seats.length) {
            System.out.println("잘못된 좌석 번호입니다.");
            return;
        }
        if (!seats[num - 1].getSeat().equals("---")) {
            System.out.println("이미 예약된 좌석입니다.");
            return;
        }
        seats[num - 1].setSeat(name);
    }

    public void cancel(String name) {
        boolean found = false;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i].getSeat().equals(name)) {
                seats[i].setSeat("---");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("예약자 이름을 찾을 수 없습니다.");
        }
    }
}

public class Concert {
    Scanner scanner = new Scanner(System.in);
    Section sSection = new Section();
    Section aSection = new Section();
    Section bSection = new Section();

    public void inputBook() {
        System.out.print("좌석구분 S(1), A(2), B(3)>> ");
        int section = scanner.nextInt();
        Section selectedSection;

        switch (section) {
            case 1:
                selectedSection = sSection;
                System.out.print("S>> ");
                break;
            case 2:
                selectedSection = aSection;
                System.out.print("A>> ");
                break;
            case 3:
                selectedSection = bSection;
                System.out.print("B>> ");
                break;
            default:
                System.out.println("유효하지 않은 섹션입니다.");
                return;
        }

        selectedSection.show();

        System.out.print("이름>> ");
        String name = scanner.next();
        System.out.print("번호>> ");
        int seatNum = scanner.nextInt();

        selectedSection.book(name, seatNum);
    }

    public void printAllSection() {
        System.out.print("S>> ");
        sSection.show();
        System.out.print("A>> ");
        aSection.show();
        System.out.print("B>> ");
        bSection.show();
        System.out.println("<<<조회를 완료하였습니다.>>>");
    }

    public void cancel() {
        System.out.print("좌석구분 S(1), A(2), B(3)>> ");
        int section = scanner.nextInt();
        Section selectedSection;

        switch (section) {
            case 1: selectedSection = sSection; break;
            case 2: selectedSection = aSection; break;
            case 3: selectedSection = bSection; break;
            default:
                System.out.println("유효하지 않은 섹션입니다.");
                return;
        }

        selectedSection.show();

        System.out.print("이름>> ");
        String name = scanner.next();

        selectedSection.cancel(name);
    }

    public static void main(String[] args) {
        Concert concert = new Concert();
        Scanner scanner = new Scanner(System.in);

        System.out.println("명품콘서트홀 예약 시스템입니다.");

        while (true) {
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>> ");
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    concert.inputBook();
                    break;
                case 2:
                    concert.printAllSection();
                    break;
                case 3:
                    concert.cancel();
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("유효한 메뉴의 숫자를 입력해주세요.");
                    break;
            }
        }
    }
}

