package report.Q1_2;

/*

다음 main() 메소드와  실행결과를 참고하여 tv를 상속받은 ColorTV 클래스를 작성하라.

 */

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

class ColorTV extends TV implements TvInterface{
    private int color;
    private int size;

    public ColorTV(int size, int color) {
        this.color = color; // color 초기화
        this.size = size;
    }
    public void printProperty() {
        // getSize()는 protected로 선언되어 있어 상속받은 클래스에서 사용 가능
        System.out.println(size + "인치 " + color + "컬러");
    }
}

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

interface TvInterface{
    void printProperty();
}

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

public class Q_1 {
    public static void main(String[] args){
        ColorTV myTv = new ColorTV(65, 6553);
        myTv.printProperty();
    }
}
