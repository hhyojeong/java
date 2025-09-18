/*

여행경비를 계산하는 프로그램을 작성한다.
방 하나에는 2명까지 투숙가능하며 1명마 투숙해도 1방의 비용을 지불한다.

 */

import java.util.Scanner;

public class Expenses {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        System.out.print("여행지 >> ");
        String Trip = scn.next();

        System.out.print("인원수 >> ");
        int Personnel = scn.nextInt();

        System.out.print("숙박일 >> ");
        int Date = scn.nextInt();

        System.out.print("1인당 항공료 >> ");
        int Airfare = scn.nextInt();

        System.out.print("1방당 숙박비 >> ");
        int Room = scn.nextInt();

        int Day = Date+1;
        int Air = Airfare*Personnel;
        int rooms;
        if(Personnel%2 == 1) {
            rooms = Personnel/2 + 1;
        }
        else{
            rooms = Personnel/2;
        }
        int Rooms = Room*rooms*Day;

        int Total = Air + Rooms;

    System.out.println(Personnel+"명의 " + Date+"박"+Day+"일 여행에는 방이 " + rooms +"필요하며 경비는 "+ Total+"원 입니다.");

    scn.close();

    }

}
