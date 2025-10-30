package in_class;

class Point{
    private int x, y;
    public Point(int x, int y){
        this.x =x; this.y = y;
    }
    public boolean equals(Object obj){
        Point p = (Point)obj;
        if(x == p.x && y == p.y) return true;
        else return false;
    }

}

public class EqualsEx {
    public static void main() {
        Point a = new Point(2, 3);
        Point b = new Point(2, 4);
        Point c = new Point(3, 4);

        if(a.equals(b)){
            System.out.println("a와 b는 같습니다.");
        } else{
            System.out.println("a와 b는 다릅니다.");
        }
        if(a.equals(c)) {
            System.out.println("a와 c는 같습니다.");
        }else{
            System.out.println("a와 c는 다릅니다.");
        }

    }
}
