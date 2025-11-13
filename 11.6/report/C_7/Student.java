package report;

class Student implements Comparable<Student> {
    private String name;
    private String major;
    private int id;
    private double unitA;

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUnitA(double unitA) {
        this.unitA = unitA;
    }

    public Student(String name, String major, int id, double unitA){
        this.name=name; this.major=major; this.id=id; this.unitA=unitA;
    }

    public String getName() {
        return name;
    }

    public double getUnitA() {
        return unitA;
    }

    public int getId() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    public int compareTo(Student other) {
        // other.unitA - this.unitA : 내림차순 정렬 공식
        return Double.compare(other.unitA, this.unitA);
    }
}
