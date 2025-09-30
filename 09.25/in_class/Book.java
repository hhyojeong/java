package in_class.week_4;

public class Book {

    String title, author;
    public Book(String t) {
        title = t;
        author = "작자미상";
    }
    public Book(String t, String a) {
        title = t;
        author = a;
    }

/* ----V-----------------------------^---------------------------------^----------------------------V-------------- */

    public static void main(String[] arag){
        Book littleprince = new Book("어린왕자", "생떼쥐베리");
        Book lovestory = new Book ("춘향전");

        System.out.println(littleprince.author + " " + littleprince.title);
        System.out.println(lovestory.author + " " + lovestory.title);
    }

}
