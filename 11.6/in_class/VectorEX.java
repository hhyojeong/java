package in_class;

import java.util.Vector;

public class VectorEX {

    public static void main(String[] args){
        Vector<Integer> v = new Vector<Integer>();
        v.add(5);
        v.add(4);
        v.add(-1);
        v.add(2, 100);

        System.out.println("벡터의 내의 요소 : "+ v.size());
        System.out.println("백터의 현재 용량 : " + v.capacity());

        for(int i = 0; i<v.size(); i++){
            int n = v.get(i);
            System.out.println(n);
        }

        //벡터 속 모든 정수 더하기
        int sum = 0;
        for(int i = 0; i<v.size(); i++){
            int n = v.elementAt(i);
            sum += n;
        }
        System.out.println("정수 합 : " + sum);
    }
}
