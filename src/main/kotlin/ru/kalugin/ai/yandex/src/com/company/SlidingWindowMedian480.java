package ru.kalugin.ai.yandex.src.com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMedian480 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        if (k > nums.length) {
            return new double[0];
        }

        var r = 0;
        var lowerIndxValue = 0L;
        var higherIndxValue = 0L;
        var lowerIndx = 0;
        var higherIndx = 0;
        double previousVal = 0;
        var result = new LinkedList<Double>();
        var queue = new ArrayDeque<Integer>();
        while (r < nums.length) {
            queue.offer(nums[r]);
            if (queue.size() > k) {
                queue.poll();
                if ((nums[r] > higherIndxValue || nums[r] < lowerIndxValue) && r < lowerIndx && r < higherIndx) {
                    result.add(previousVal);
                    continue;
                }
                var queueP = new PriorityQueue<>(queue);
                for (var l = 0; l < lowerIndx; l++) {
                    queueP.poll();
                }
                var midArr = queue.toArray(new Integer[0]);
                Arrays.sort(midArr);
                if (k % 2 == 0) {
                    lowerIndx = k / 2 - 1;
                    higherIndx = lowerIndx + 1;
                    lowerIndxValue = (long) midArr[lowerIndx];
                    higherIndxValue = (long) midArr[higherIndx];
                    previousVal = getDouble(lowerIndxValue, higherIndxValue);
                } else {
                    lowerIndx = (k - 1) / 2;
                    lowerIndxValue = midArr[lowerIndx];
                    higherIndx = lowerIndx;
                    higherIndxValue = lowerIndxValue;
                    previousVal = (double) lowerIndxValue;
                }
                result.add(previousVal);
            }
            if (r == (k - 1)) {
                var midArr = queue.toArray(new Integer[0]);
                Arrays.sort(midArr);
                if (k % 2 == 0) {
                    lowerIndx = k / 2 - 1;
                    higherIndx = lowerIndx + 1;
                    lowerIndxValue = (long) midArr[lowerIndx];
                    higherIndxValue = (long) midArr[higherIndx];
                    previousVal = getDouble(lowerIndxValue, higherIndxValue);
                } else {
                    lowerIndx = (k - 1) / 2;
                    lowerIndxValue = midArr[lowerIndx];
                    higherIndx = lowerIndx;
                    higherIndxValue = lowerIndxValue;
                    previousVal = (double) lowerIndxValue;
                }
                result.add(previousVal);
            }
            r++;
        }
        return result.stream().mapToDouble(i -> i).toArray();
    }

    private static Double getDouble(long l, long h) {
        long res = l + h;
        return (double) res / 2;
    }
}
