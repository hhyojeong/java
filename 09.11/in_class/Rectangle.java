import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("높이 입력 : ");
        int height = scn.nextInt();
        System.out.print("너비 입력 : ");
        int weight = scn.nextInt();
        int area = height * weight;
        System.out.println("높이 = " + height +", " + "너비 = " + weight + "인 사각형의 면적 = " + area);

        scn.close();
    }
}

