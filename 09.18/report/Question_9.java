package report.Chapter3;

/*
   4x4 크기의 2차원 정수 배열에 0~255 범위의 정수 16개를 랜덤하게 생성하여 저장한 후, 배열을 실행 사례와 같이 출력하라

    4x4 배열에 랜덤한 값을 저장한 후 출력합니다.
  	35	42	120	12
  	67	57	204	228
  	19	208	58	203
 	224	221	23	94
 */

import java.util.Random;

public class Question_9 {
    public static void main(String[] args) {

        Random r = new Random();
        int array[][] = new int[4][4];

        System.out.println("4x4 배열에 랜덤한 값을 저장한 후 출력합니다. ");
        for(int i=0; i<array.length; i++) {
            for(int j=0; j<array[i].length; j++) {
                array[i][j] = r.nextInt(256);
                System.out.print(array[i][j] + "	");
            }
            if(i==3) {
                break;
            }
            System.out.println();
        }
    }


}
