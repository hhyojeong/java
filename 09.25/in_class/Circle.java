package in_class.week_4;

/*

-> 객체 만들기 방법 3가지

Circle.java
Circle_Rectangle.java
TriangleTest.jave
4
 */

public class Circle {

    int radius;
    String name;

    public Circle() {
    }

    public Circle(int radiu) {
        this.radius = radius;
    }

    double getArea(){

        return Math.PI *  radius * radius; //math는 class이고 pi가 statcic으로 설정되어 있어 사용할 수 있는 것

    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.radius = 5;
        double c1Area = c1.getArea();
        System.out.println("원의 면적 = " + c1Area);
    }

}