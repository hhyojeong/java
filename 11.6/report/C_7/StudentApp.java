package report;

import report.Student;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class StudentApp {
    public static void main(String[] args) {
        Vector<Student> studentIn = new Vector<>();
        Scanner scn = new Scanner(System.in);

        System.out.print("4명의 이름, 전공, 학번, 학점 입력\n");

        while (studentIn.size() < 4) {
            System.out.print(">>");
            String input = scn.nextLine();

            String[] parts = input.split(",\\s*|\\s+");

            String name = parts[0];
            String major = parts[1];
            int id = Integer.parseInt(parts[2].trim());
            double unitA = Double.parseDouble(parts[3].trim());

            Student s = new Student(name, major, id, unitA);
            studentIn.add(s);
        }

        System.out.println("-------------------------------------");

        if (!studentIn.isEmpty()) {
            for (Student s : studentIn) {
                System.out.printf("이름: %s\t전공: %s\t학번: %d\t학점평균: %.2f\n",
                        s.getName(), s.getMajor(), s.getId(), s.getUnitA());
            }
        }
        System.out.println("-------------------------------------");

            int top = 2;

            Collections.sort(studentIn);
            System.out.print("장학생 :");
            for (int i = 0; i < Math.min(top, studentIn.size()); i++) {
                Student s = studentIn.get(i);
                System.out.print(" "+s.getName());
            }

        System.out.println();
        System.out.println("-------------------------------------");

        while (true) {
            System.out.print("학생이름>>");
            String searchName = scn.nextLine().trim(); // nextLine() 사용

            if (searchName.equalsIgnoreCase("그만")) {
                break;
            }

            boolean found = false;
            // 리스트 전체를 순회하며 검색
            for (Student s : studentIn) {
                // ⭐ 문자열 비교는 반드시 .equals() 메서드를 사용해야 합니다.
                if (searchName.equals(s.getName())) {
                    System.out.println(s.getName()+", "+ s.getMajor()+ ", " + s.getId()+ ", " + s.getUnitA());
                    found = true;
                    break; // 찾았으니 루프 종료
                }
            }

            if (!found) {
                System.out.println(searchName + "학생은 없습니다.");
            }
        }

            scn.close();
    }
}