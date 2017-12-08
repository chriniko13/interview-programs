package interview.programs.first;

public class PowerOf {

    public static void main(String[] args) {

        System.out.println("isPowerOfTwoAsc(7) == " + isPowerOfTwoAsc(7));
        System.out.println("isPowerOfTwoAsc(8) == " + isPowerOfTwoAsc(8));

        System.out.println("isPowerOfTwo(7) == " + isPowerOfTwo(7));
        System.out.println("isPowerOfTwo(8) == " + isPowerOfTwo(8));

    }

    private static boolean isPowerOfTwoAsc(int num) {
        for (int i = 2; i <= num; i *= 2) {

            if (num == i) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPowerOfTwo(int num) {
        return (num & -num) == num;
    }

}
