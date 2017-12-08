package interview.programs.first;

import java.util.*;

public class CounterExample {

    public static void main(String[] args) {

        String s = "one two three two three three";
        String[] sArr = s.split(" ");

        ArrayList<String> input = new ArrayList<>(Arrays.asList(sArr));

        Map<String, Integer> naiveCounterResult = new NaiveCounter().count(input);
        System.out.println("result from naive counter = " + naiveCounterResult);

        System.out.println();

        Map<String, BetterCounter.MutableInteger> betterCounterResult = new BetterCounter().count(input);
        System.out.println("result from better counter = " + betterCounterResult);

        System.out.println();

        Map<String, EfficientCounter.MutableInteger> efficientCounterResult = new EfficientCounter().count(input);
        System.out.println("result from efficient counter = " + efficientCounterResult);

    }

}

class NaiveCounter {

    public Map<String, Integer> count(List<String> input) {

        final Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : input) {

            if (wordCounts.containsKey(word)) {
                Integer oldValue = wordCounts.get(word);
                wordCounts.put(word, oldValue + 1);
            } else {
                wordCounts.put(word, 1);
            }

        }

        return wordCounts;
    }

}

class BetterCounter {

    public Map<String, MutableInteger> count(List<String> input) {

        final Map<String, MutableInteger> wordCounts = new HashMap<>();

        for (String word : input) {

            if (wordCounts.containsKey(word)) {
                MutableInteger oldValue = wordCounts.get(word);
                oldValue.setVal(oldValue.getVal() + 1);
            } else {
                wordCounts.put(word, new MutableInteger(1));
            }

        }

        return wordCounts;
    }

    static class MutableInteger {
        private int val;

        public MutableInteger(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

}

class EfficientCounter {

    public Map<String, MutableInteger> count(List<String> input) {

        final Map<String, MutableInteger> wordCounts = new HashMap<>();

        for (String word : input) {

            MutableInteger initValue = new MutableInteger(1);

            MutableInteger oldValue = wordCounts.put(word, initValue);

            if (oldValue != null) {

                initValue.setVal(oldValue.getVal() + 1);
            }

        }

        return wordCounts;
    }

    static class MutableInteger {
        private int val;

        public MutableInteger(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

}