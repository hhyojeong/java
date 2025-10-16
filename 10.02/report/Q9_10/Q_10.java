package report.Q9_10;

import report.Q9_10.BaseArray;

import java.util.Scanner;
import java.util.Scanner;

/*

BaseArray를 상속받아 값이 큰 순소로 배열을 항상유지하는 SortedArray를 작성하라.
 다음 main() 메소드를 포함하고 실행결과와 같이 출력되게 하라.

 */

class SortedArray extends BaseArray {

    public SortedArray(int size) {
        super(size);
    }

    public void add(int n) {
        if (nextIndex == array.length) return; // 배열이 꽉 찬 경우

        // 삽입할 위치 찾기
        int i = nextIndex - 1;
        while (i >= 0 && array[i] > n) {
            array[i + 1] = array[i];
            i--;
        }
        // 값 삽입
        array[i + 1] = n;
        nextIndex++;
    }
}

public class Q_10 {
    public static void main(String[] agrs){

        SortedArray sArray = new SortedArray(10);
        Scanner scn = new Scanner(System.in);
        System.out.print(">>");

        for(int i = 0; i<sArray.length(); i++){
            int n = scn.nextInt();
            sArray.add(n);
        }

        sArray.print();
        scn.close();

    }
}
