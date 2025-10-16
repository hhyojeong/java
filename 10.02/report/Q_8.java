package report;

/*

커피 자판기 프로그램을 작성하고자 한다.
다음은 박스를 표현하 추상 클래스 BOX의 코드이다.
Box 상속받아 자판기 커피의 각 재료를 담을 수 있는 IngredienBox클래스를 작성하라
커피, 프림, 설탕을 각각 담는 3개의 IngredientBox 객체를 생성하고 다음 실행결과와 같이 작동하는 커피 자판기 프로그램을 완성하라.

 */

import java.util.Scanner;

abstract class Box{

    protected int size;
    //현재 박스에 들어있는 재료의 양
    public Box(int size){
        this.size = size;
    }
    //생성자

    public boolean isEmpty(){
        return size == 0;
    }
    //박스가 빈경우 true 리턴

    public abstract boolean consume();
    //박스에 들어있는 재료를 일정량 소비

    public abstract void print();
    //박스에 들어있는 양을 "*"문자로 출력
}

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

class IngredientBox extends Box{
    private String name;

    public IngredientBox(String name, int size){
        super(size);
        this.name = name;
    }

    public boolean consume(){
        if(isEmpty()){
            return false;
        }
        size --;
        return true;
    }

    public void print(){

        System.out.print(name + " ");
        for(int i = 0; i < size; i++){
            System.out.print("*");
        }
        System.out.println(size);
    }

}

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

public class Q_8 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        IngredientBox coffee = new IngredientBox("커피", 5);
        IngredientBox prim = new IngredientBox("프림", 5);
        IngredientBox sugar = new IngredientBox("설탕", 5);

        System.out.println("***** 청춘 커피 자판기 입니다. *****");

        coffee.print(); prim.print(); sugar.print();

        while(true){
            System.out.print("다방커피 : 1, 설탕커피 : 2, 블랙커피 : 3, 종료 : 4 >>  ");
            int order = scn.nextInt();

            switch(order) {
                case 1:
                    if( coffee.consume() && prim.consume() && sugar.consume()) {
                        break;
                    }
                    else {
                        System.out.println("원료가 부족합니다.");
                        break;
                    }
                case 2:
                    if( coffee.consume() && sugar.consume()) {
                        break;
                    }
                    else {
                        System.out.println("원료가 부족합니다.");
                        break;
                    }
                case 3:
                    if(!coffee.consume()) {
                        System.out.println("원료가 부족합니다.");
                        break;
                    }
                    break;
                case 4:
                    System.out.println("청춘 커피 자판기 프로그램을 종료합니다");
                    scn.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                    break;
            }
            coffee.print(); prim.print(); sugar.print();
        }
    }
}
