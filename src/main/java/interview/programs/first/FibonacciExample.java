package interview.programs.first;

import java.util.*;

public class FibonacciExample {

    public static void main(String[] args) {


        long startTime = System.nanoTime();
        System.out.println("fib(45) == " + fib(45));
        long endTime = System.nanoTime() - startTime;
        System.out.println("fib recursion total time: " + endTime);
        System.out.println();


        startTime = System.nanoTime();
        System.out.println("fib(45) == " + new CachedFib().fib(45));
        endTime = System.nanoTime() - startTime;
        System.out.println("fib recursion cached total time: " + endTime);
        System.out.println();


        startTime = System.nanoTime();
        System.out.println("fibonacci(45) == " + fibonacci(45));
        endTime = System.nanoTime() - startTime;
        System.out.println("fib iteration total time: " + endTime);
        System.out.println();

    }

    private static int fib(int n) {

        if (n == 0) return 0;

        if (n == 1) return 1;

        return fib(n - 1) + fib(n - 2);

    }

    private static List<Integer> fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(
                    "n must not be less than zero");
        }
        if (n == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            return Collections.singletonList(0);
        }
        if (n == 2) {
            return Arrays.asList(0, 1);
        }


        final List<Integer> seq = new ArrayList<>(n);
        seq.add(0);
        n = n - 1;
        seq.add(1);
        n = n - 1;

        while (n >= 0) {
            int a = seq.get(seq.size() - 1);
            int b = seq.get(seq.size() - 2);
            seq.add(a + b);
            n -= 1;
        }

        return seq;
    }

}


class CachedFib {

    private Map<Integer, Integer> cachedFibs = new HashMap<>();

    public int fib(int n) {
        cachedFibs.clear();

        cachedFibs.put(0, 0);
        cachedFibs.put(1, 1);

        return calcFib(n);
    }

    private int calcFib(int n) {
        Integer cachedFib = cachedFibs.get(n);
        if (cachedFib != null) {
            return cachedFib;
        }

        int calculatedFib = calcFib(n - 1) + calcFib(n - 2);
        cachedFibs.put(n, calculatedFib);
        return calculatedFib;
    }


}
