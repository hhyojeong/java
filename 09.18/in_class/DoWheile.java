

public class DoWheile {
    public static void main(String[] args) {
        char c = 'a';

        do {
            System.out.print(c);
            c = (char)(c + 1); //1이 4바이트 캐스팅 필요
        }while (c <= 'z');
    }
}
