package report.Chapter3;

/*

 (3) do-while 문을 이용하여 동잃게 실행되는 DoWhileLoopArray 클래스를 작성하라

*/

public class DoWhileArrary {

    public static void main(String[] args) {

        int n[] = {1, -2, 6, 20, 5, 72, -16, 256};
        int i=0;

        do {
            if(n[i] > 0 && n[i] % 4 == 0) {
                System.out.print(n[i] + " ");
            }
            i++;
        } while(i<n.length);
    }

}
