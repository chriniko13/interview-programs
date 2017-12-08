package interview.programs.first;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FizzBuzzAlgorithm {

    public static void main(String[] args) {

        String toPrint = fizzBuzz(30).stream().collect(Collectors.joining(", "));
        System.out.println("toPrint == " + toPrint);

        toPrint = fizzBuzzImproved(30).stream().collect(Collectors.joining(", "));
        System.out.println("toPrint(improved) == " + toPrint);

    }


    private static List<String> fizzBuzz(int n) {
        final List<String> toReturn = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                toReturn.add("FizzBuzz");
            } else if (i % 3 == 0) {
                toReturn.add("Fizz");
            } else if (i % 5 == 0) {
                toReturn.add("Buzz");
            } else {
                toReturn.add(Integer.toString(i));
            }
        }
        return toReturn;

    }

    private static List<String> fizzBuzzImproved(int n) {
        final List<String> toReturn = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {

            String word = toWord(3, i, "Fizz") + toWord(5, i, "Buzz");

            if (word.isEmpty()) {
                toReturn.add(Integer.toString(i));
            } else {
                toReturn.add(word);
            }
        }

        return toReturn;
    }

    private static String toWord(int divisor, int value, String word) {
        return value % divisor == 0 ? word : "";
    }
}
