package interview.programs.first;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationExceptionExample {


    public static void main(String[] args) {

        firstExample();

        System.out.println();

        secondExample();

    }

    private static void firstExample() {

        //1st example...
        List<String> firstList = new ArrayList<>();
        firstList.add("a");
        firstList.add("b");
        firstList.add("c");
        firstList.add("d");
        firstList.add("e");

        try {

            for (String value : firstList) {

                System.out.println("value = " + value);

                if (value.equals("c")) {
                    firstList.remove("c");
                }

            }

        } catch (ConcurrentModificationException error) {
            System.out.println("Error occurred = " + error);
        }
    }

    private static void secondExample() {
        //2nd example...
        List<String> secondList = new ArrayList<>();
        secondList.add("a");
        secondList.add("b");
        secondList.add("c");
        secondList.add("d");
        secondList.add("e");

        try {

            Iterator<String> iterator = secondList.iterator();

            while (iterator.hasNext()) {

                String next = iterator.next();

                System.out.println("value = " + next);

                if (next.equals("c")) {
                    iterator.remove();
                }

            }

            System.out.println();

            iterator = secondList.iterator();
            while (iterator.hasNext()) {

                String next = iterator.next();
                System.out.println("value = " + next);
            }


        } catch (ConcurrentModificationException error) {
            System.out.println("Error occurred = " + error);
        }
    }

}
