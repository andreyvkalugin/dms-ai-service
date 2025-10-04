package ru.kalugin.ai.yandex.src.com.company;

import java.util.*;

public class BestTimetoBuyandSellStock121 {
    public static void main(String[] args) {
        System.out.println(maxProfitF(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    public static int maxProfitF(int[] prices) {
        var max = 0;
        var min = Integer.MAX_VALUE;
        for (var i = 0; i < prices.length; i++) {
            var current = prices[i];
            min = Math.min(min, current);
            max = Math.max(max, (current - min));
        }

        return max;
    }

    public static int maxProfit(int[] prices) {
        //buy
        var previousI = Integer.MAX_VALUE;
        //sell
        var previousJ = Integer.MIN_VALUE;
        List<Integer> sum = new LinkedList<>();
        for (var i = 0; i < prices.length; i++) {
            for (var j = prices.length - 1; j > i; j--) {
                previousI = prices[i];
                previousJ = prices[j];
                sum.add(previousJ - previousI);
            }
        }
        var max = sum.stream().mapToInt(i -> i).max();
        if (max.isPresent()) {
            var k = max.getAsInt();
            if (k > 0) {
                return k;
            }
        }
        return 0;
    }

    /**
     * Container to ease passing around a tuple of two objects. This object provides a sensible
     * implementation of equals(), returning true if equals() is true on each of the contained
     * objects.
     */
    private static class Pair {
        public final Integer first;
        public final Integer second;

        public Integer getFirst() {
            return first;
        }

        public Integer getSecond() {
            return second;
        }

        /**
         * Constructor for a Pair.
         *
         * @param first  the first object in the Pair
         * @param second the second object in the pair
         */
        public Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        /**
         * Checks the two objects for equality by delegating to their respective
         * {@link Object#equals(Object)} methods.
         *
         * @param o the {@link Pair} to which this one is to be checked for equality
         * @return true if the underlying objects of the Pair are both considered
         * equal
         */
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair p = (Pair) o;
            return Objects.equals(p.first, first) && Objects.equals(p.second, second);
        }

        /**
         * Compute a hash code using the hash codes of the underlying objects
         *
         * @return a hashcode of the Pair
         */
        @Override
        public int hashCode() {
            return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
        }

        @Override
        public String toString() {
            return "{" +
                    "index=" + first +
                    ", value=" + second +
                    '}';
        }

        /**
         * Convenience method for creating an appropriately typed pair.
         *
         * @param a the first object in the Pair
         * @param b the second object in the pair
         * @return a Pair that is templatized with the types of a and b
         */
        public static Pair create(Integer a, Integer b) {
            return new Pair(a, b);
        }
    }

}
