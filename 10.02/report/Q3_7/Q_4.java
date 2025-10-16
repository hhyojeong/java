package report.Q3_7;

/*

 Point를 상속받아 색을 가진 점을 나타내는 ColorPoint2클래스를 작성하라.
 다음 main() 메소드를 포함하여 실행 결과와 같이 출력되게 하라.

 */


/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
//불러오기
import report.Q3_7.Point;
import report.Q3_7.Color;

class ColorPoint2 extends Point implements ColorsInterface{
    private String color;

    public ColorPoint2() {
        super(0,0 ); // Point() 호출 (0, 0)
        this.color = "WHITE";
    }

    public ColorPoint2 (int x, int y, String color){
        super(x, y);
        this.color = color;
    }

    public ColorPoint2(int x, int y) {
        super(x, y); // x, y 좌표를 Point에 전달하여 초기화
        this.color = "BLACK"; // 요구사항에 맞게 "BLACK"으로 설정
    }

    public void set(String color) {
        this.color = color;
    }

    public void set(int x, int y) {
        move(x, y);
    }

    public double getDistance(ColorPoint2 p){
        double deltaX = p.getx() - this.getx();
        double deltaY = p.gety() - this.gety();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public String toString(){
        return this.color + "색의 " + "(" + getx() +", "+ gety()  + ")의 점";
    }

}

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

interface ColorsInterface{
    void set(String color);
    void set(int x, int y);
}

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

public class Q_4 {
    public static void main(String[] args){

        ColorPoint2 zeroPoint = new ColorPoint2();
        System.out.println(zeroPoint.toString() + "입니다.");
        //(0.0)의 위치의 "WHITE" 색 점

        ColorPoint2 cp = new ColorPoint2(10, 10, "Red");
        cp.set("BLUE");
        cp.set(10, 20);
        System.out.println(cp.toString()+ "입니다.");

        ColorPoint2 thresholdPoint = new ColorPoint2(100, 100);
        //(100, 100)의 위치는 "BLACK" 점
        System.out.println("cp에서 임계점까지의 거리는 "  + cp.getDistance(thresholdPoint));
    }

}
