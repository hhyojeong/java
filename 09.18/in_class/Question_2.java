
public class Question_2 {
    public static void main(String[] args) {
        int i;
        int a;

        for (i = 5; i >= 1; i--) {
            for(a =0; a < 5-i; a++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
