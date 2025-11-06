package report;
/*
 실행 예시와 같이 년도를 입력받아 달력을 출력하는 프로그램을 작성하라.
 이때 날짜와 간련된 클래스 Calender 클래스만 활용하라.
*/
import java.util.Calendar;
import java.util.Scanner;

public class CalendarApp {
    public static void makeCalendar(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);

        for(int i=0; i<12; i++) {
            System.out.println("\n" + year + "년 " + (i+1)+ "월 ");
            System.out.println("일\t월\t화\t수\t목\t금\t토");

            calendar.set(Calendar.MONTH, i);
            calendar.set(Calendar.DAY_OF_MONTH, 1);

            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            for (int j = 0; j < dayOfWeek - 1; j++)
                System.out.print("\t");
            int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

            for (int j = 1; j <= lastDay; j++) {
                System.out.print(j + "\t");
                if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
                    System.out.println();
                calendar.set(Calendar.DAY_OF_MONTH, j + 1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("년도 입력(-1이면 종료)>>");
            int year = scanner.nextInt();
            if(year == -1) break;
            makeCalendar(year);
        }

        scanner.close();

    }

}