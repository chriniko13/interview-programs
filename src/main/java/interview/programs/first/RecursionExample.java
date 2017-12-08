package interview.programs.first;

public class RecursionExample {


    public static void main(String[] args) {


        System.out.println("factorialRecursion(10) == " + factorialRecursion(6));

        System.out.println("factorialTailRecursion(10) == " + factorialTailRecursion(6, 1));

        System.out.println("factorialIteration(10) == " + factorialIteration(6));


    }


    private static long factorialRecursion(long n) {

        if (n == 1)
            return 1;
        else
            return n * factorialRecursion(n - 1);

    }


    private static long factorialTailRecursion(long n, long acc) {

        if (n == 1)
            return acc;
        else
            return factorialTailRecursion(n - 1, acc * n);

    }

    private static long factorialIteration(long n) {
        int acc = 1;
        for (int i = 2; i <= n; i++) {
            acc *= i;
        }
        return acc;
    }
}
