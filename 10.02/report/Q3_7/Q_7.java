package report.Q3_7;

/*

    Point 클래스를 상속받아 3차원 색 점을 나타내는 Point3DColor 클래스를 작성하라.
    다음 main( ) 메소드를 포함하여 실행결과와 같이 출력되게 하라.

*/

import report.Q3_7.Point;
import report.Q3_7.Color;

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

class Point3DColor extends Point {
    private int z;
    private String color;

    public Point3DColor(int x, int y, int z, String color) {
        super(x, y);
        this.z = z;
        this.color = color;
    }

    public void move(Point3DColor p) {
        super.move(p.getx(), p.gety());
        this.z = p.z;
    }

    public String toString() {
        return "(" + getx() + "," + gety() + "," + z + ") " + color + "점";
    }

    public boolean equals(Point3DColor p) {
        if (getx() == p.getx() && gety() == p.gety() && z == p.z
                && color.equals(p.color))
            return true;
        else
            return false;
    }
}
/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

public class Q_7 {
    public static void main(String[] args){

        Point3DColor p = new Point3DColor(10, 20, 30, "RED");
        System.out.println(p.toString() + "입니다.");

        Point3DColor q = new Point3DColor(1, 2, 3, "BLUE");
        p.move(q);
        System.out.println(p.toString() + "입니다.");

        Point3DColor r = new Point3DColor(1, 2, 3, "RED");
        if(p.equals(r)) System.out.println("예. 같은 위치 같은 색깔의 점입니다.");
        else System.out.println("아니요");

    }
}
