package report;

import report.Student;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class StudentA {
    public static void main(String[ ] args) {

        HashMap<String, Student> stu = new HashMap<>();
        Scanner scn = new Scanner(System.in);

        System.out.println("4명의 이름, 전공, 학번, 학점 입력");
        while (stu.size() < 4) {
            System.out.print(">> ");
            String input = scn.nextLine().trim();
            String[] parts = input.split(",\\s*|\\s+");
            String name = parts[0];
            String major = parts[1];
            int id = Integer.parseInt(parts[2]);
            double unitA = Double.parseDouble(parts[3]);

            Student s = new Student(name, major, id, unitA);
            stu.put(name, s);

        }

        System.out.println("-------------------------------------");

        if (!stu.isEmpty()) {
            for (String nameKey : stu.keySet()) {
                Student s = stu.get(nameKey);
                System.out.printf("이름: %s\t전공: %s\t학번: %d\t학점: %.2f\n",
                        s.getName(), s.getMajor(), s.getId(), s.getUnitA());
            }
        }
        System.out.println("-------------------------------------");

        Vector<Student> studentListForSort = new Vector<>(stu.values());
        if (!studentListForSort.isEmpty()) {
            int top = 2;

            Collections.sort(studentListForSort); // Vector를 정렬 (Student에 Comparable 구현 필수)

            System.out.print("장학생 :");
            for (int i = 0; i < Math.min(top, studentListForSort.size()); i++) {
                Student s = studentListForSort.get(i);
                System.out.print(" " + s.getName());

            }
            System.out.println();
            System.out.println("-------------------------------------");
        }

        while (true) {
            System.out.print("학생이름>>");
            String searchName = scn.nextLine().trim();

            if (searchName.equalsIgnoreCase("그만")) {
                break;
            }

            // ⭐ HashMap의 get(Key) 메서드를 사용하여 O(1) 시간 복잡도로 즉시 검색
            Student s = stu.get(searchName);

            if (s != null) { // 이름이 키로 존재하는 경우
                System.out.print(s.getName() +"," + s.getMajor() +","+ s.getId()+"," + s.getUnitA());
                System.out.println();
            }

        }
        scn.close();
    }
}
