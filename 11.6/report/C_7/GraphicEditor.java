package report;

/*
    Vector<Shape>을 이용하여 그래픽 편집기를 만들어보자.
    "삽입", "삭제", "모두보기", "종료"의 4가지 기능을 구현한다.
*/

import java.util.Scanner;
import java.util.Vector; // Vector 사용
import java.util.InputMismatchException; // 예외 처리 추가

// --- 1. 추상 클래스 Shape 및 도형 클래스 ---

// 추상 클래스 Shape (public을 제거하고 기본 접근 지정자 사용)
abstract class Shape {
    public abstract void draw();
}

// Line 클래스
class Line extends Shape {
    @Override
    public void draw() {
        System.out.println("Line");
    }
}

// Rect 클래스 (오타 수정: Rect로 변경)
class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("Rect");
    }
}

// Circle 클래스
class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}


// --- 2. Editor 클래스 (Vector를 이용한 로직 구현) ---

class Editor {
    private Vector<Shape> shapeList;

    public Editor() {
        shapeList = new Vector<>();
    }

    // 도형 삽입: Vector의 add() 사용
    public void insert(Shape shape) {
        shapeList.add(shape);
    }

    // 모두 보기: Vector 순회
    public void printAll() {
        if (shapeList.isEmpty()) {
            System.out.println("저장된 도형이 없습니다.");
            return;
        }
        for (Shape shape : shapeList) {
            shape.draw();
        }
    }

    // 특정 위치의 도형 삭제: Vector의 remove(index) 사용
    public boolean delete(int position) {
        int index = position - 1;
        // Vector 인덱스 범위 체크
        if (index >= 0 && index < shapeList.size()) {
            shapeList.remove(index);
            return true;
        }
        return false;
    }

    // 프로그램 실행
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");

        while (true) {
            try {
                System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Line(1), Rect(2), Circle(3) >> ");
                        int type = scanner.nextInt();
                        Shape shape = null;

                        if (type == 1) shape = new Line();
                        else if (type == 2) shape = new Rect();
                        else if (type == 3) shape = new Circle();

                        if (shape != null) {
                            insert(shape);
                        } else {
                            System.out.println("잘못된 도형 타입입니다.");
                        }
                        break;

                    case 2:
                        System.out.print("삭제할 도형의 위치 >> ");
                        int position = scanner.nextInt();
                        if (!delete(position)) {
                            System.out.println("삭제할 수 없습니다.");
                        }
                        break;

                    case 3:
                        printAll();
                        break;

                    case 4:
                        System.out.println("Beauty Graphic Editor를 종료합니다.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("잘못된 입력입니다.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력 형식입니다. 숫자를 입력해 주세요.");
                scanner.nextLine(); // 잘못된 입력을 버퍼에서 제거
            }
        }
    }
}


// --- 3. 메인 실행 클래스 ---

public class GraphicEditor { // 파일명과 일치하는 public 클래스
    public static void main(String[] args){
        // ⭐ 오류 수정: Editor 클래스의 객체를 생성하고 run() 메서드를 호출해야 함
        Editor editor = new Editor();
        editor.run();
    }
}