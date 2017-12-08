package interview.programs.first;

public class ReverseString {

    public static void main(String[] args) {

        String name = "chriniko";

        System.out.println(reverse(name));
        System.out.println(reverseOptimized(name));

    }

    private static String reverse(String input) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            stringBuilder.append(input.charAt(i));
        }


        return stringBuilder.toString();
    }

    public static String reverseOptimized(String input) {

        StringBuilder stringBuilder = new StringBuilder(input);

        for (int i = 0; i <= input.length() / 2; i++) {

            char first = stringBuilder.charAt(i);
            char second = stringBuilder.charAt(input.length() - 1 - i);
            stringBuilder.setCharAt(i, second);

            stringBuilder.setCharAt(input.length() - 1 - i, first);

        }


        return stringBuilder.toString();
    }
}
