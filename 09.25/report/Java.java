package report.Chapter_4;

/*

자바 클래스를 만드어보자.
다음 main()메소드를 실행하였을 때 예시와 같이 출력되도록 tv class를 작성하라.
 */

class TV{
        String brand;
        int inch, price;
        public TV(String brand, int inch, int price){
            this.brand = brand;
            this.inch = inch;
            this.price = price;
            }
        void show(){
            System.out.println(brand+"에서 만든 "+ price+ "만원짜리의 "+inch+ "인치 TV");
        }

}

public class Java {
    public static void main(String [] args) {
        TV tv = new TV("Samsung", 50, 30);
        tv.show();
    }
}
