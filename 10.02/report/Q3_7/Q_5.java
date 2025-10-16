package report.Q3_7;

/*

Point 클래스를 상속받아 3차원 점을 나타내는 Point3D 클래스를 작성하라.
다음 main()메소드를 포함하여 실행 결과와 같이 출력되게 하라.

 */

import report.Q3_7.Point;

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

class Point3D extends Point{
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void moveUp(int value){
      z += value;
    }

    public void moveDown(int value){
        z -= value;
    }

    public void move(int x, int y, int z) {
        super.move(x, y);
        this.z = z;
    }

    public String toString(){
        return "(" + getx() + ", " + gety() + ", " + z + ")의 점"  ;
    }

}


/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
public class Q_5 {
    public static void main(String[] args){
        Point3D p = new Point3D(3,2,1);
        System.out.println(p.toString() + "입니다");

        p.moveUp(3);
        System.out.println(p.toString() + " 입니다");
        p.moveDown(2);
        System.out.println(p.toString() + " 입니다");
        p.move(5, 5);
        System.out.println(p.toString() + " 입니다");
        p.move(100, 200, 300);
        System.out.println(p.toString() + " 입니다");
    }
}
