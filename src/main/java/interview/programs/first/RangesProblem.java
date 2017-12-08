package interview.programs.first;

import io.vavr.Tuple;
import io.vavr.Tuple2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RangesProblem {


    public static void main(String[] args) {

        // [a, b) --> a is inclusive, b is exclusive.
        List<Tuple2<Integer, Integer>> ranges = Arrays.asList(

                Tuple.of(1, 4),
                Tuple.of(2, 3),
                Tuple.of(3, 7),
                Tuple.of(7, 10),
                Tuple.of(4, 5),
                Tuple.of(1, 6),
                Tuple.of(5, 7),
                Tuple.of(10, 11)

        ); // the solution should be the following: [ [1,4), [4, 5), [5, 7), [7, 10), [10, 11) ]


        // first solution...
        List<Tuple2<Integer, Integer>> mergedRanges = new LinkedList<>();

        mergedRanges.add(ranges.get(new Random().nextInt(ranges.size())));

        for (Tuple2<Integer, Integer> range : ranges) {


            for (Tuple2<Integer, Integer> storedRange : mergedRanges) {


            }


        }

    }

    private static boolean doComparison(Tuple2<Integer, Integer> existing, Tuple2<Integer, Integer> candidate) {

        List<Integer> alreadyStored = IntStream.range(existing._1, existing._2)
                .boxed()
                .collect(Collectors.toList());

return false;

    }

}
