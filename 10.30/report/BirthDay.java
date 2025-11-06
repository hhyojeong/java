package report;
/*
 Calender 클래스를 활용하여 생일을 입력하면 오늘 이 시간까지 며칠을 살아왔는지 알려주는 프로그램을 작성하라.
 며칠을 계산할 때는 오늘을 포함한다.
 날짜가 바뀔 때 1일을 산것으로 계산한다.
*/
import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BirthDay {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        Calendar now = Calendar.getInstance();

        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);

        System.out.printf("오늘은 %d년 %d월 %d일\n",
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH) + 1,
                now.get(Calendar.DAY_OF_MONTH));
        while(true) {
            System.out.print("생일 입력(년 월 일)>>");
            String input = scn.nextLine();

            if(input.equals("그만"))
                break;

            StringTokenizer st = new StringTokenizer(input, " ");
            int year = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            Calendar inputDate = Calendar.getInstance();
            inputDate.set(year, month-1, day);

            // 입력받은 날짜도 시간을 0:0:0으로 설정
            inputDate.set(Calendar.HOUR_OF_DAY, 0);
            inputDate.set(Calendar.MINUTE, 0);
            inputDate.set(Calendar.SECOND, 0);
            inputDate.set(Calendar.MILLISECOND, 0);

            long diffDays = (now.getTimeInMillis() - inputDate.getTimeInMillis())
                    / (24*60*60*1000);

            if(diffDays > 0)
                System.out.println("오늘까지 " + diffDays + "일 살아왔습니다.");
            else if(diffDays < 0)
                System.out.println(Math.abs(diffDays) + "일 더 살아야 생일이 됩니다.");
            else
                System.out.println("오늘입니다.");
        }
        scn.close();
    }
}
