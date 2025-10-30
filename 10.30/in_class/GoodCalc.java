package in_class;

//오버라이딩
abstract class Calculator{
    abstract int add(int a, int b);
    abstract int substract(int a, int b);
    abstract double average(int[] a);

}


public class GoodCalc extends Calculator {
    @Override
    int add(int a, int b) {
        return a+b;
    }

    @Override
    int substract(int a, int b) {
        return a - b;
    }

    @Override
    double average(int[] a) {
        double sum=0;
        for(int i = 0; i<a.length; i++){
            sum += a[i];
        }
        return sum/a.length;
    }
    public static void main(String[] args){
        Calculator c = new GoodCalc();
        System.out.println(c.add(2,3));
        System.out.println(c.substract(2,3));
        System.out.println(c.average (new int []{2,3,4}));

    }
}
