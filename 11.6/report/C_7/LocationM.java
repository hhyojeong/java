package report;

import report.Location;
import java.util.ArrayList;
import java.util.Scanner;

public class LocationM {
    public static void main(String[] args) {

        ArrayList<Location> locations = new ArrayList<>();
        Scanner scn = new Scanner(System.in);

        System.out.println("도시, 위도, 경도를 입력하세요.");

        for (int i = 0; i < 4; i++) {
            System.out.print(">> ");
            String in = scn.nextLine();

            // 입력 문자열 분리
            String[] parts = in.split(", | ");
            String city = parts[0];
            double latitude = Double.parseDouble(parts[1]);
            double hardness = Double.parseDouble(parts[2]);

            Location newLoc = new Location(city, latitude, hardness);

            locations.add(newLoc);

        }
        System.out.println("-------------------------------------");
        for (Location loc : locations) {
            // Location 객체의 getCity()와 toString() 사용
            System.out.println(loc.getC() + " " + loc.toString());
        }

        while (true) {
            System.out.print("도시 이름 >> ");
            String searchCity = scn.nextLine();

            if (searchCity.equals("그만")) {
                break;
            }

            boolean found = false;

            for (Location loc : locations) {
                if (loc.getC().equals(searchCity)) {
                    // 일치하는 요소를 찾으면 출력
                    System.out.println(searchCity + " " + loc.toString());
                    found = true;
                    break; // 찾았으니 검색 종료
                }

            }
            if (!found) {
                System.out.println(searchCity + "는 없습니다.");
            }
        }
        scn.close();
    }
}