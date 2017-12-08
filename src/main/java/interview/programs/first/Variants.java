package interview.programs.first;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Variants {

    public static void main(String[] args) {


        List<Integer> myData = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        // foo(myData); // Note: Generics are not covariant, but invariant.

        foo(new String[]{"a", "b", "c", "d", "e"}); // Note: but arrays are covariant.

    }

    //  private static void foo(List<? extends Object> data) { // Note: comment-uncomment.
    private static void foo(List<Object> data) { // Note: comment-uncomment.
        data.forEach(System.out::println);
    }

    private static void foo(Object[] data) {
        Arrays.stream(data).forEach(System.out::println);
    }
}
