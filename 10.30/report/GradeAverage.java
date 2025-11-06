package report;

/*
 실행 사례와 같이 개수가 정해지지 않은 여러과목의 학점을 빈 칸으로 분리하여 입력받고,
 A는 100점 B는 90점 C는 80점 D는 70점 F는 0점으로 계산하여 평균을 출력하는 프로그램을 작성하라.
 대소문자는 구분하지 않는다.
*/

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Scanner;

public class GradeAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("여러 과목의 학점을 빈 칸으로 분리 입력>>");
            String line = sc.nextLine();

            // 종료 조건
            if (line.equals("그만")) {
                break;
            }

            // 공백으로 분리 (연속된 공백도 정상 처리)
            String[] tokens = line.split("\\s+");
            double sum = 0.0;
            int count = 0;
            boolean hadError = false;

            for (String t : tokens) {
                if (t.trim().isEmpty()) continue;
                String grade = t.trim().toUpperCase();

                switch (grade) {
                    case "A":
                        sum += 100;
                        count++;
                        break;
                    case "B":
                        sum += 90;
                        count++;
                        break;
                    case "C":
                        sum += 80;
                        count++;
                        break;
                    case "D":
                        sum += 70;
                        count++;
                        break;
                    case "F":
                        sum += 0;
                        count++;
                        break;
                    default:
                        // 잘못된 입력 만나면 오류 출력하고, 그 줄은 처리하지 않음
                        System.out.println("입력 오류:" + t);
                        hadError = true;
                        break;
                }
                if (hadError) break; // 하나라도 틀리면 그 라인 처리를 중단
            }

            if (!hadError) {
                if (count == 0) {
                    System.out.println("평균은 0.0");
                } else {
                    double avg = sum / count;
                    System.out.println("평균은 " + avg);
                }
            }
            // 오류가 있었으면 이미 "입력 오류:..."를 출력했고, 다음 루프에서 다시 입력받음
        }

        sc.close();
        System.out.println("프로그램을 종료합니다.");
    }
}