package report.Q3_7;

/*

    Point를 상속받아 색을 가진 점을 나타내는 colorpint 클래스를 작성하라.
    다음 main() 메소드를 포함하여 실행 결과와 같이 출력하게 되게하라

 */

import report.Q3_7.Point;
import report.Q3_7.Color;
import java.awt.*;

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

class ColorPoint extends Point implements ColorInterface{
    private String color;

    public ColorPoint(int x, int y, String color){
        super(x, y);
        this.color = color;
    }

    public void setXY(int x, int y) {
        move(x, y);
    }

    public void setColor(String color) {
        this.color = color;
    }


    public String toString(){
        return this.color + "색의 " + "(" + getx() +", "+ gety()  + ")의 점";
    }
}

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

interface ColorInterface{
    void setXY(int x, int y);
    void setColor(String color);
}

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

public class Q_3 {
    public static void main(String[] args){
        ColorPoint cp = new ColorPoint(5, 5, "RED");
        cp.setXY(10, 20);
        cp.setColor("BLUE");
        String str = cp.toString();
        System.out.println(str + "입니다.");
    }
}
