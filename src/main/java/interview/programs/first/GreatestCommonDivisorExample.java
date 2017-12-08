package interview.programs.first;

public class GreatestCommonDivisorExample {


    public static void main(String[] args) {

        System.out.println("gcd(18, 9) == " + gcd(18, 9));
        System.out.println("gcd(37, 11) == " + gcd(37, 11));
        System.out.println("gcd(1137, 1341) == " + gcd(1137, 1341));

    }


    // O(n^3)
    private static int gcd(int a, int b) {

        if (b == 0) return a;

        return gcd(b, a % b);
    }

}
