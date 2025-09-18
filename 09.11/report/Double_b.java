/*

실행 사례와 같이 실수(double)에 대한사칙연산을 수행하는 프로그램을 작성하라.
연산은 "더하기" "빼기" "곱하기" "나누기"로 하고,
계산식은 "2.3 더하기 3.6"과 같이 빈 칸으로 분리하여 입력한다.
0으로 나누기가 입력되면, "0으로 나눌 수 없습니다"를 출력하고,
연산 명령이 "더하기", "빼기", "곱하기", "나누기"가 아닌 경우
"사칙연산이 아닙니다"를 출력하고 종료한다.

 */


import java.util.Scanner;


public class Double_b {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("연산입력 >> ");

        double a = scn.nextDouble();
        String op = scn.next();
        double b = scn.nextDouble();
        double result;

        switch (op) {
            case "더하기":
                result = a + b;
                System.out.println(a + " " + op + " " + b + result);
                break;
            case "빼기":
                result = a - b;
                System.out.println(a + " " + op + " " + b + result);
                break;
            case "나누기":
                result = a / b;
                System.out.println(a + " " + op + " " + b +"는 "+result);
                break;
                default:
        }
    }
}