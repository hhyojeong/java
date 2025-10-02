package report.Chapter_4;

/* - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - -

 다음 멤버를 가지고 사각형으 표현하는 Rectangle 클래스를 작성하라.
  -int 타입의 x, y width, height 필드 : 사각형을 구성하는 점과 크기 정보
  -boolean isSquare() : 정사각형이면 ture 아니면 flase 리천
  -boolean contains(Rectangle r) : 현재 사각형 내부에 매개 벼수로 받은 사각형r이 있으며 아니면 false리턴
  -main( ) 메소드와 실행결과는 다음과 갗다

- - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - */

class Rectangle{
    int x;
    int y;
    int width;
    int height;

    public Rectangle (int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    void show(){
     System.out.println("(" + x + "," + y + ")에서 크기가 " + width + "x" + height + "인 사각형");
    }

    boolean isSquare(){
        return width == height;
    }

    boolean contains(Rectangle r){
        boolean topLeftContained = (r.x >= this.x) && (r.y >= this.y);
        boolean bottomRightContained =
                ((r.x + r.width) <= (this.x + this.width)) && ((r.y + r.height) <= (this.y + this.height));
        return topLeftContained && bottomRightContained;
    }

}

public class Q_6 {
    public static void main(String[] args){
        Rectangle a = new Rectangle(3, 3, 6, 6);
        Rectangle b = new Rectangle(4, 4, 2, 3);

        a.show();
        if(a.isSquare()) System.out.println("a는 정사각형입니다.");
        else System.out.println("a는 직사각형입니다.");
        if(a.contains(b)) System.out.println("a는 b를 포함합니다");
    }

}
