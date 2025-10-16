package report.Q9_10;

import report.Q9_10.BaseArray;
import java.util.Scanner;

/*

BaseArray 클래스를 상속 받아 임계점보다 크면 1, 아니면 0의 값을 가지는 BaseArray를 작성하라.
다음 main() 메소드를 포함하고 실행결과와 같이 출력되게하라

 */

class BinaryArray extends BaseArray{
    private int threshold;

    public BinaryArray(int size, int threshold){
        super(size);
        this.threshold = threshold;
    }

    public void add(int n){

        if(n > threshold) {
            super.add(1);
        }else{
            super.add(0);
        }
    }

}

public class Q_9 {
    public static void main(String[] args){

        //임계값
        int threshold = 50;

        //bArray 객체는 threshold 보다 크면 1, 아니면 0의 값만 가지는 배열처럼 행동
        BinaryArray bArray = new BinaryArray(10, threshold);

        Scanner scn = new Scanner(System.in);
        System.out.print(">>");

        //bArray.length()는 10
        for(int i = 0; i<bArray.length(); i++){
            int n = scn.nextInt();
            bArray.add(n);
        }

        bArray.print();
        scn.close();

    }
}
