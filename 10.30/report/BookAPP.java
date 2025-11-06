package report;
/*

 저자, 도서명, 구입자, 이름의 3개의 필드를 가지는 Book클래스를 작성하라.
 생성자는 저자,도서명, 구입자를 매개변수로 전달받아 해당 필드를 초기화하고,
 equals() 메소드는 두 book 객체의 저자와 도서명만 같으면 같은 것으로 판별하도록 한다.
 Book클래스와 함께 다음 실행예시와 같이 main()에서 Book 객체를 할용하는 BookAPP클래스를 작서아하라

 */

class Book extends BookApp{
    private String author;
    private String book_n;
    private String customer;

    public Book(String author, String book_n, String customer){
        this.author=author; this.book_n=book_n; this.customer=customer;
    }

    public String toString(){
        return customer + "이 구입한 도서 : " + author +"의 " + book_n;
    }

    public boolean equals(Object obj){
        Book p = (Book)obj;
        if(author == p.author && book_n == p.book_n) return true;
        else return false;
    }

}

class BookApp {
    public static void main(String[] args){
        Book a = new Book("황기태", "명품자바", "김하진");
        Book b = new Book("황기태", "명품자바", "하여린");
        System.out.println(a);
        System.out.println(b);
        if(a.equals(b))
            System.out.println("같은 책");
        else
            System.out.println("다른 책");
    }
}
