package interview.programs.first;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumbers {


    public static void main(String[] args) {

        System.out.println("isPrime(149) = " + isPrimeRookie(149L));

        System.out.println("some primes are: " + collectAllPrimesTo(500L, PrimeNumbers::isPrimeRookie));

        System.out.println("isPrimeBetter(2) == " + isPrimeBetter(149L));

        System.out.println("some primes are: " + collectAllPrimesTo(500L, PrimeNumbers::isPrimeBetter));

        System.out.println("some primes are (sieveOfEratosthenes): " + sieveOfEratosthenes(500));

    }

    // O(n)
    private static boolean isPrimeRookie(long n) {

        for (int i = 2; i < n; i++) {

            if (n % i == 0) {
                return false;
            }

        }
        return true;
    }

    // O(n)
    private static boolean isPrimeBetter(long n) {

        if (n == 2) return true;

        //check if n is a multiple of 2
        if (n % 2 == 0) return false;

        //if not, then just check the odds
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // O(n(\log n)(\log \log n))
    private static List<Integer> sieveOfEratosthenes(int n) {

        boolean[] primes = new boolean[n];

        Arrays.fill(primes, true);

        primes[0] = primes[1] = false;

        for (int i = 2; i < primes.length; i++) {

            if (primes[i]) {

                for (int j = 2; i * j < n; j++) {
                    primes[i * j] = false;
                }

            }

        }

        return IntStream.range(0, primes.length).boxed().filter(idx -> primes[idx]).collect(Collectors.toList());
    }


    private static List<Long> collectAllPrimesTo(long to, Function<Long, Boolean> isPrime) {

        final List<Long> result = new LinkedList<>();

        for (long i = 2; i <= to; i++) {

            if (isPrime.apply(i)) {
                result.add(i);
            }
        }

        return result;
    }

}
