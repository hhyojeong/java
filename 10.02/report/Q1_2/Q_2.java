package report.Q1_2;

/*

다음 main() 메소드와 실행결과를 참고하여 Colortv를 상속받은 SmartTV 클래스를 작성하라.

*/


//TV, Color 불러오기

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */


class Address{
    private String address;

    public Address(String address){
        this.address = address;
    }
    protected String getadress(){
        return address;
    }
}

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

class SmartTV extends TV implements smartInterface{
    private String address;
    private int color;
    private int size;

    public SmartTV(String address, int size, int color){
        this.size = size;
        this.color = color;
        this.address = address;

    }

    public void printProperty(){
        System.out.println("나의 smartTV는 " + address + " 주소의 "+ size + "인치" + color + "컬러");
    }

}

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

interface smartInterface{
    void printProperty();
}

/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

public class Q_2 {
    public static void main(String[] args){
        SmartTV smartTV = new SmartTV("192.168.0.5", 77, 20000000);

        smartTV.printProperty();
    }
}
