package report;
/*
 쇼핑 후 전체 경비를 계산하는  프로그램을 작성하라.
 구입 가능한 품목은 실행예시와 같이 고추장, 만두 등 8가지dlek.
*/

import java.util.HashMap;
import java.util.Scanner;

public class shoppingApp {
    public static void main(String[] args) {

        HashMap<String, Integer> item = new HashMap<String, Integer>();

        // 상품 목록 및 가격 초기화
        item.put("고추장", 3000);
        item.put("만두", 500);
        item.put("새우깡", 1500);
        item.put("콜라", 600);
        item.put("참치캔", 2000);
        item.put("치약", 1000);
        item.put("연어", 2500);
        item.put("삼겹살", 2500);

        System.out.print("쇼핑 비용을 계산해드립니다. 구입가능한 물건과 가격은 다음과 같습니다.\n");

        // 초기 상품 목록 출력
        for (String itemName : item.keySet()) {
            System.out.print("[" + itemName + "," + item.get(itemName) + "]");
        }
        System.out.println(); // 줄 바꿈

        Scanner scn = new Scanner(System.in);

        while(true) {
            System.out.print("물건과 개수를 입력하세요 >>");
            String input = scn.nextLine().trim();

            // 종료 조건
            if (input.equals("그만")) {
                break;
            }

            String[] shopping = input.split(" ");
            long totalCost = 0;
            boolean errorFound = false;

            // 입력 분석 및 비용 계산 (2개씩 건너뛰며 반복)
            for(int i = 0; i < shopping.length; i += 2){
                String itemName = shopping[i];

                // 1. 개수 입력 누락 확인
                if(i + 1 >= shopping.length){
                    errorFound = true;
                    // 문제에서 요구하는 출력에 맞춰 수정
                    System.out.println("입력에 문제가 있습니다!");
                    break;
                }

                String countStr = shopping[i+1];
                int count = 0;

                // 2. 상품 목록에 없는 물건 확인
                if (!item.containsKey(itemName)) {
                    errorFound = true;
                    System.out.println(itemName + "은(는) 없는 상품입니다!");
                    break;
                }

                // 3. 개수가 유효한 숫자인지 확인 및 비용 계산
                try {
                    count = Integer.parseInt(countStr);

                    // 개수가 음수일 경우도 오류로 처리 가능
                    if (count < 0) {
                        errorFound = true;
                        break;
                    }

                    // 모든 검증 통과: 비용 계산
                    int price = item.get(itemName);
                    totalCost += (long)price * count;

                } catch (NumberFormatException e) {
                    errorFound = true;
                    System.out.println("입력에 문제가 있습니다!");
                    break;
                }
            } // end of for loop

            // 오류가 발생하지 않았을 때만 총 비용 출력
            if (!errorFound) {
                System.out.println("전체 비용은 " + totalCost + "원입니다.");
            }
        } // end of while loop

        scn.close();
    }
}