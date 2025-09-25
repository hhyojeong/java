package report.Chapter3;

/*
1. 다음 프로그램에 대해 물음에 답하라
    (1)무엇을 계산하는 코드인가? 실행결과 출력되는 내용은?

        무엇을 계산하는 코드인가?
        i += i + 3 더해지는 i(i+3에의해 더해져 복사된 i의 값)이
        if( i > 50)을 통해 51이 넘어버리면 멈추어야한다.

        int sum=0, i =1;이므로
        처음 whlie이 실행되면서
        sum(업데이트 될 sum) = 0(sum의 초기값) + 1(i의 초기값) => 복사된 sum은 1이되고
        i (업데이트 될 i)= 1(i의초기값) + 3 => 업데이트된 i = 4
        그 다시 함수가 돌면서
        sum(업데이트 될 sum) = 1(업데이트된 sum) + 4(업데이트 된 i) => 복사된 sum은 1이되고
        i (업데이트 될 i)= 4(업데이트 된 i) + 3 => 업데이트된 i = 7
        51의 넘지않는 i의 값은 49가 된다.
        그러므로 sum += sum + i는 425가되며
        System.out.print(sum) sum값의 결과로 425가 송출된다.

        실행결과 => 425


    (2)위의 코드를 main( ) 메소드로 만들고 WhileLoop 클래스로 완성하라.



    (4)do-while 문을 이용하여 동일하게 실행되는 DoWhileLoop 클래스를 작성하라.
 */

public class WhileLoop {

    public static void main(String[] args) {

        int sum = 0, i = 1;
        while (i < 50) {

            while (true) {
                sum += i;
                i += 3;
                break;
            }
        }
        System.out.println(sum);
    }
}
