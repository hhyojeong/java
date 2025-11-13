package report;
/*
    항공사에서 고객의 마일리지를 관리하는 프로그램을 해시맵을 이용하여 작성하라.
    프로그램은 고객의 이름과 마일리지를 함께 저장하며, 마일리지는 누적 저장된다.
*/

import java.util.HashMap;
import java.util.Scanner;

class Customer {
    private String name;
    private int mileage;

    public Customer(String name, int mileage) {
        this.name = name;
        this.mileage = mileage;
    }

    public String getN() { return name; }
    public int getM() { return mileage; }

    // 마일리지 누적 메소드
    public void addMileage(int newMileage) {
        if (newMileage > 0) {
            this.mileage += newMileage; // ← 누적 (오타 수정)
        }
    }

    public String toString() {
        return "(" + name + ":" + mileage + ")";
    }
}

public class AirPlaneApp {
    public static void main(String[] args) {
        HashMap<String, Customer> items = new HashMap<>();
        Scanner scn = new Scanner(System.in);

        System.out.println("*** 마일리지 관리 프로그램입니다. ***");

        while (true) {
            System.out.print("이름과 마일리지 >> ");
            String flyer = scn.nextLine().trim();

            if (flyer.equalsIgnoreCase("그만")) {
                // 저장된 모든 고객 출력
                for (Customer c : items.values()) {
                    System.out.print(c.toString());
                }
                System.out.println();

                // 최고 마일리지 고객 찾기
                Customer top = null;
                for (Customer c : items.values()) {
                    if (top == null || c.getM() > top.getM()) {
                        top = c;
                    }
                }

                if (top != null) {
                    System.out.println("가장 마일리지가 높은 고객은 " + top.getN() + "입니다.");
                }
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String[] parts = flyer.split("\\s+");
            if (parts.length != 2) {
                continue;
            }

            String name = parts[0];
            int mileage;

            try {
                mileage = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                continue;
            }

            // 고객 정보 누적
            if (items.containsKey(name)) {
                items.get(name).addMileage(mileage);
            } else {
                items.put(name, new Customer(name, mileage));
            }
        }

        scn.close();
    }
}
