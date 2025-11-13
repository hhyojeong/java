package report;

import java.util.ArrayList;
import java.util.Scanner;

public class Shopping_App {
    public static void main(String[] args) {

        ArrayList<String> itemNames = new ArrayList<>();
        ArrayList<Integer> itemPrices = new ArrayList<>();

        itemNames.add("고추장");
        itemPrices.add(3000);
        itemNames.add("만두");
        itemPrices.add(500);
        itemNames.add("새우깡");
        itemPrices.add(1500);
        itemNames.add("콜라");
        itemPrices.add(600);
        itemNames.add("참치캔");
        itemPrices.add(2000);
        itemNames.add("치약");
        itemPrices.add(1000);
        itemNames.add("연어");
        itemPrices.add(2500);
        itemNames.add("삼겹살");
        itemPrices.add(2500);

        System.out.print("쇼핑 비용을 계산해드립니다. 구입가능한 물건과 가격은 다음과 같습니다.\n");

        for (int i = 0; i < itemNames.size(); i++) {
            System.out.print("[" + itemNames.get(i) + "," + itemPrices.get(i) + "]");
        }

        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.print("\n물건과 개수를 입력하세요 >>");
            String input = scn.nextLine().trim();

            if (input.equals("그만 ")) {
                break;
            }

            String[] shopping = input.split(" ");
            long totalCost = 0;
            boolean errorFound = false;

            for (int i = 0; i < shopping.length; i +=2) {
                String itemName = shopping[i];

                if (i + 1 >= shopping.length) {
                    errorFound = true;
                    System.out.println("입력에 문제가 있습니다!");
                    break;
                }

                String countStr = shopping[i + 1];
                int count = 0;

                int itemIndex = itemName.indexOf(itemName);
                if (itemIndex == -1) {
                    errorFound = true;
                    System.out.println(itemName+"은 없는 상품입니다!");
                    break;
                }
                try {
                    count = Integer.parseInt(countStr);
                    if (count < 0) {
                        errorFound = true;
                        break;
                    }
                    int price = itemPrices.get(itemIndex);
                    totalCost += (long) price * count;
                }catch (NumberFormatException e) {
                    errorFound = true;
                    break;
                    }
                }
            if (!errorFound) {
                System.out.println("전체 비용은 " + totalCost + "원입니다.");
            }
        } // end of while loop

        scn.close();
    }
}