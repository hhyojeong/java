package report.Chapter_4;
/* - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - -

다음 main( ) 메소드는 Average 클래스를 이용하여 정수를 저장하고 평균을 구하여 출력한다.
이코드와 실행 결과를 참고하여 Average 클래스를 작성하라. Average클래스는 최ㅐㄷ 10개의 정수까지만 저장할 수있다.

- - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - */

import java.util.Scanner;

class Average{

    //저장할 배열
    private int[] data;
    //저장된 정수의 개수
    private int nextIndex;
    //최대저장
    private static final int Max = 10;

    //생성자
    public Average(){
        System.out.println("****** 저장된 데이터 모두 출력 ****** ");
        this.data = new int[Max];
        this.nextIndex = 0; //배열초기화 nextIndex를 0으로
    }

    public void put (int n){
        if(nextIndex < Max){
            data[nextIndex] = n;
            nextIndex += 1;
        }
    }

    public void showAll(){
        for(int i = 0; i < nextIndex; i++){
            System.out.print(data[i]);
            if(i < nextIndex -1){
                System.out.print(" ");
            }
        }
        System.out.println("");
    }

    public double getAvg(){
        if(nextIndex == 0){
            return 0.0;
        }
        int sum = 0;

        for(int i = 0; i < nextIndex; i++){
            sum += data[i];
        }
        return (double)sum/ nextIndex;
    }
}




public class Q_4 {
    public static void main(String[] args){
        Average avg = new Average();
        avg.put(10);
        avg.put(15);
        avg.put(100);
        avg.showAll();
        System.out.print("평균은 " + avg.getAvg());
    }
}
