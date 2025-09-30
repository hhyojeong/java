package in_class.week_4;

/* ----V-----------------------------^---------------------------------^----------------------------V-------------- */

public class CallByValue {
    public static void main(String[] args) {

     int n = 10;

     increase(n);

     System.out.println(n);

    }
    public static void increase(int m){
        m++;
    }

}
