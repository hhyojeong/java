package report.Chapter3;

/*

무엇을 계산하는 코드인가요? 실행결과 출력되는 내용은?

배열에서 n[i] > 0( n의 배열 속 양수) &&  n[i] % 4 == 0 (n 배열 속 양수 중 4의 배수)
그러므로 교집합인 20 72 256
출력내용 =>20 72 256

 */

import java.util.Arrays;

public class ForLoopArray {
    public static void main(String[] args) {

        int n[] = {1, -2, 6, 20, 5, 72, -16, 256};

        for (int i = 0; i < n.length; i++) {

            if (n[i] > 0 && n[i] % 4 == 0) {
                System.out.print(n[i] + " ");
                }
        }
    }

}
