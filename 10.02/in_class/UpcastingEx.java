package in_class.week_5.inheritance;


class Person {
    String name;
    String id;

    public Person (String namae) {
        this.name = namae;
    }
}

class Student extends Person{
    String grade;
    String department;

    public Student(String name){
        super(name);
    }
}

public class UpcastingEx{
    public static void main(String[] args){
        Person p;
        Student s = new Student(" 홍길동");
        p = s;
    }
}

