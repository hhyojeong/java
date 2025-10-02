package report.Chapter_4;

import java.util.Scanner;

/*

 한 달의 다이어리를 관리하는 프로그램을 작성하라.
 한 달은 30일로 정한다.
 이 프로그램은 사용자로부터 날짜와 기억할 일을 간단히 저장하거나, 검색하는 등의 기능을 수행하며,
 실행예시는 다음과 같다.
 기억할 일은 빈칸 없이 4글자 이하의 문자열만 다룬다.

 */


    public class MonthDiary {
        private int year, month;
        private DayDiary[] days;
        private Scanner scanner = new Scanner(System.in);

        public MonthDiary(int year, int month) {
            this.year = year;
            this.month = month;

            switch(month) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    days = new DayDiary[31];
                    break;
                case 4: case 6: case 9: case 11:
                    days = new DayDiary[30];
                    break;
                case 2:
                    days = new DayDiary[28];
                    break;
            }

            for (int i = 0; i < days.length; i++) {
                days[i] = new DayDiary();
            }
        }

        // 1: 기록
        public void writeDiary() {
            System.out.print("날짜(1~" + days.length +")와 텍스트(빈칸없이 4글자이하)>>");
            int day = scanner.nextInt();
            String text = scanner.next();
            days[day-1].setText(text);
        }

        // 2: 보기
        public void viewDiary() {
            for(int i=0; i<days.length; i++) {
                System.out.print(days[i].getText() + "\t");
                if((i+1) % 7 == 0 ) {
                    System.out.println();
                }
            }
            System.out.println();
        }

        public void run() {
            System.out.println("***** " + year + "년 " + month + "월 다이어리 *****");

            while (true){
                System.out.print("기록:1, 보기:2, 종료:3>> ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        writeDiary();
                        break;
                    case 2:
                        viewDiary();
                        break;
                    case 3:
                        System.out.println("프로그램을 종료합니다.");
                        return;
                }
            }
        }

        public static void main(String[] args) {
            MonthDiary monthDiary = new MonthDiary(2024, 10);
            monthDiary.run();
        }
    }

    // DayDiary 클래스
   class DayDiary {
        String text;

        public DayDiary() {
            text = "...";
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

    }

