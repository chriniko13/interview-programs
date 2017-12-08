package interview.programs.first;

public class IsPalindrome {

    public static void main(String[] args) {

        System.out.println("isPalindrome(level) == " + isPalindrome("level"));

        System.out.println("isPalindrome(levelb) == " + isPalindrome("levelb"));

        System.out.println("isPalindrome(eve) == " + isPalindrome("eve"));

        System.out.println("isPalindrome(top spot) == " + isPalindrome("top spot"));

        System.out.println("isPalindrome(yokoy) == " + isPalindrome("yokoy"));

        System.out.println();

        System.out.println("isPalindromeAnotherApproach(levelb) == " + isPalindromeAnotherApproach("levelb"));

        System.out.println("isPalindromeAnotherApproach(eve) == " + isPalindromeAnotherApproach("eve"));

        System.out.println("isPalindromeAnotherApproach(top spot) == " + isPalindromeAnotherApproach("top spot"));

    }

    private static boolean isPalindrome(String input) {

        int left = 0;
        int right = input.length() - 1;

        while (left <= right) {

            while (left < input.length() &&
                    !Character.isLetter(input.charAt(left))) {
                left++;
            }

            while (right > 0 && !Character.isLetter(input.charAt(right))) {
                right--;
            }

            if (left > input.length() || right < 0) {
                return false;
            }

            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }

    private static boolean isPalindromeAnotherApproach(String input) {
        return input.equals(ReverseString.reverseOptimized(input));
    }
}
