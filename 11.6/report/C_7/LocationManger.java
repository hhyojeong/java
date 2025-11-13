package report;

/*
    도시 이름, 위도, 경도 정보를 가진 Location 클래스를 작성하고, 다음 문제를 풀어라.
*/

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import report.Location;

public class LocationManger {
    public static void main(String[] args){

        HashMap<String, Location> location = new HashMap<>();
        Scanner scn = new Scanner(System.in);

        System.out.print("도시, 경도, 위도를 입력하세요.\n");

            for(int i=0; i<4; i++) {
                System.out.print(">>");
                String in = scn.nextLine();

                String[] parts = in.split(", | ");

                String city = parts[0];
                double latitude = Double.parseDouble(parts[1]);
                double hardness = Double.parseDouble(parts[2]);

                Location newL = new Location(city, latitude, hardness);
                location.put(city, newL);

            }
            System.out.println("-------------------------------------");
            Set<String> keys = location.keySet();

            for (String city : keys) {
            // city: 서울, locationMap.get(city): Location 객체
            System.out.println(city + " " + location.get(city).toString());
            }
            System.out.println("-------------------------------------");

            while(true){
                System.out.print("도시이름>>");
                String sCity = scn.nextLine();

                if (sCity.equals("그만")) {
                    break;
                }

                Location foundLoc = location.get(sCity);

                if (foundLoc != null) {
                    // 객체가 존재하면 출력 (Location.toString() 사용)
                    System.out.println(sCity + " " + foundLoc.toString());
                } else {
                    // 객체가 없으면 "피리는 없습니다." 메시지 출력
                    System.out.println(sCity + "는 없습니다.");
                }


            }

        scn.close();

    }
}
