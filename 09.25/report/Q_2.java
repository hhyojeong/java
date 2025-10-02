package report.Chapter_4;

/*

cube는 직육면체를 표현하는 클래스이다.
다음 main() 메소드와 실행결과를 참고하여 cube 클래스를 작성하라.

 */

class Cube {
    int volume;
    private int width;
    private int length;
    private int height;

    public Cube (int w, int l, int h) {
        this.width = w;
        this.length = l;
        this.height = h;
    }

    public int getVolume(){
        return this.width * this.length * this.height;
    }

    public void increase(int uw, int ul, int uh) {
        this.width += uw;
        this.length += ul;
        this.height += uh;
    }

    public boolean isZero(){
       return this.width == 0 || this.length == 0 || this.height == 0;

    }

}

/* ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ^        v        ^ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ */

public class Q_2 {
    public static void main (String[] args) {
        Cube cube = new Cube(1 ,2, 3); //가로, 세로, 높이가 1, 2, 3
        System.out.println("큐브의 부피는 " + cube.getVolume());
        cube.increase(1, 2, 3); //가로, 세로, 높이가 1, 2, 3씩 증가
        System.out.println("큐브의 부피는 " + cube.getVolume());
        if(cube.isZero())
            System.out.println("큐브의 부피는 0");
        else
            System.out.println("큐브의 부피는 0이 아님");
    }
}
