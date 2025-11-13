package report;

import java.util.HashMap;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> accounts = new HashMap<>();

        System.out.println("*** 명품 은행에 오신 것을 환영합니다. ***");

        while (true) {
            System.out.print("입금:1, 출금:2, 조회:3, 전체 조회:4, 종료:5>>");
            int menu = sc.nextInt();

            if (menu == 5) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (menu) {
                case 1: // 입금
                    System.out.print("계좌명과 액수>>");
                    String name = sc.next();
                    int amount = sc.nextInt();
                    int current = accounts.getOrDefault(name, 0);
                    accounts.put(name, current + amount);
                    break;

                case 2: // 출금
                    System.out.print("계좌명과 액수>>");
                    name = sc.next();
                    amount = sc.nextInt();
                    if (!accounts.containsKey(name)) {
                        System.out.println("해당 계좌가 없습니다!");
                        break;
                    }
                    current = accounts.get(name);
                    if (current < amount) {
                        System.out.println("잔액이 부족하여 출금할 수 없음!!");
                    } else {
                        accounts.put(name, current - amount);
                    }
                    break;

                case 3: // 개별 조회
                    System.out.print("계좌명>>");
                    name = sc.next();
                    if (accounts.containsKey(name)) {
                        System.out.println("(" + name + ":" + accounts.get(name) + "원)");
                    } else {
                        System.out.println("해당 계좌가 없습니다!");
                    }
                    break;

                case 4: // 전체 조회
                    for (String key : accounts.keySet()) {
                        System.out.print("(" + key + ":" + accounts.get(key) + "원)");
                    }
                    System.out.println();
                    break;

                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
        }

        sc.close();
    }
}
