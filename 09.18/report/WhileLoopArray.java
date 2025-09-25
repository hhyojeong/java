package report.Chapter3;

/*

    int n[] = {-1, -2, 6, 20, 5, 72, -16, 256};

        for(int i = 0; i < n.length; i++) {

            if (n[i] > 0 && n[i] % 4 == 0) {
                System.out.print(n[i] + " ");
            }

        }

    (2)위의 코드를 main( ) 메소드로 만들고 ForLoopArray 클래스로 완성하라.

 */

public class WhileLoopArray {
    public static void main(String[] args){

        while(true){
            int n[] = {1, -2, 6, 20, 5, 72, -16, 256};
            int i=0;
            while (true) {
                while (i < n.length) {
                    if (n[i] > 0 && n[i] % 4 == 0) {
                        System.out.print(n[i] + " ");
                    }
                    i++; // 조건 확인 후 i를 1씩 증가
                }
            }
        }
    }
}

