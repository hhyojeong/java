package report.Q11;

/*
다음 IStack 인터페이스를 상속받아 문자열을 저장하는 StringStack 클래스를 구현하라.
push()는 스택의 꼭대기에 삽입하고 pop()은 스택의 꼭대기에 저장된 문자열을 리턴하는 메소드이다.
*/

import report.Q11.StringStack;

import java.util.Scanner;

public class StackApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("스택 용량>>");
        int size = scanner.nextInt();
        StringStack sStack = new StringStack(size);

        while(true) {
            System.out.print("문자열 입력>>");
            String str = scanner.next();

            if(str.equals("그만")) {
                break;
            }
            if(sStack.push(str) == false) {
                System.out.println("스택이 꽉 차서 " + str + " 저장 불가");
            }
        }
        System.out.print("스택에 저장된 문자열 팝 : ");
        while(true) {
            String str = sStack.pop();
            if(str == null) { break; }
            System.out.print(str + " ");
        }
        System.out.println();
        scanner.close();
    }
}