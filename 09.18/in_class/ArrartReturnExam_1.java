public class ArrartReturnExam_1 {
    public static int[] addOne(int intArr[]) {
        for (int i = 0; i < intArr.length; i++) {
            intArr[i]++;
        }
        return intArr;
    }

    public static void main(String[] args) {
        int intArrary[] = {1, 2, 3, 4};

        int intArrary2[] = addOne(intArrary);
        for (int i : intArrary2) {
            System.out.println(i + "");
        }
    }
}