package report.Q3_7;

/*

Point 클래스를 상속받아 양수만 가능한 점을 나타내는 PositivePoint 클래스를 작성하라.
다음 main() 메소드를 포함하여 실행 결과와 같이 출력되게 하라.

 */

import report.Q3_7.Point;

class PositivePoint extends Point{

    public PositivePoint(int x, int y){
        super((x > 0) ? x : 1, (y > 0) ? y : 1);
    }

    public void move(int x, int y) {
        if (x > 0 && y > 0)
            super.move(x, y);
    }

    public String toString(){
        return "(" + getx() + ", " + gety() + ")" + "점";
    }

}

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

public class Q_6 {
    public static void main(){

        PositivePoint p = new PositivePoint(10, 10);
        p.move(5, 5);
        System.out.println(p.toString()+ "입니다.");

        p.move(2, -2);
        System.out.println(p.toString() + "입니다");

        PositivePoint q = new PositivePoint(-10, -10);

        System.out.println(q.toString() + "입니다.");

    }
}
