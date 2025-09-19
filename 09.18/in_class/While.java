import java.util.Scanner;

public class While {
    public static void main(String[] args) {
        int i = 1, sum = 0, num = 10;
        while (i <= num) {
            sum += i;
            i++;
        }
        System.out.println(sum);
    }
}
