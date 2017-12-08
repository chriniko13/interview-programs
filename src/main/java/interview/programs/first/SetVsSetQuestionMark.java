package interview.programs.first;

import java.util.HashSet;
import java.util.Set;

public class SetVsSetQuestionMark {

    public static void main(String[] args) {
        Set set1 = new HashSet();

        set1.add("a");
        set1.add("b");
        set1.add(1);

        process1(set1);

        System.out.println();

        process2(set1);
    }


    private static void process1(Set set) {
        set.add("d");
        set.forEach(o -> System.out.println(o));
    }

    private static void process2(Set<?> set) { /* Note: it is a consumer method with the usage of ? wildcard. */
//        set.add("d"); // Note: comment-uncomment
        set.forEach(System.out::println);
    }
}
