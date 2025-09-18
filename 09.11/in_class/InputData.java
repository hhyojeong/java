import java.util.Scanner;

public class InputData {
    public static  void main(String args[]){
        System.out.print("도시, 이름, 나이, 체중 독신여부를 빈칸으로 구분하여 기재하시오");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String city = scanner.next();
        int age = scanner.nextInt();
        double weight = scanner.nextDouble();
        boolean single = scanner.nextBoolean();

        System.out.println("이름 = " + name);
        System.out.println("도시 = " + city);
        System.out.println("나이 = " + age);
        System.out.println("체중 = " + weight);
        System.out.println("기혼 여부 = " + single);


    }
}
