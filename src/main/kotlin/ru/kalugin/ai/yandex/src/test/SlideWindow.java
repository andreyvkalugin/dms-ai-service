package ru.kalugin.ai.yandex.src.test;

import java.util.*;

public class SlideWindow {
    public static void main(String[] args) {
        int[] nums = {2147483647, 2147483647};
        System.out.println(getMiddle(nums, 2));
    }

    private static double[] getMiddle(int[] nums, int k) {
        ArrayDeque<Integer> queueD = new ArrayDeque<>(k);
        var res = new ArrayList<Double>();
        Queue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);

        if (k == 1) {
            return Arrays.stream(nums).mapToDouble(d -> d).toArray();
        }

        if (nums.length == 2) {
            var a = (Double.valueOf(nums[0]) + Double.valueOf(nums[1])) / 2d;
            return new double[]{a};
        }

        if (nums.length >= k) {
            for (var i = 0; i < nums.length; i++) {
                if (queueD.size() < k) {
                    queueD.offer(nums[i]);
                    continue;
                }
                res.add(evaluateMedian(queue, queueD, k));
                queueD.offer(nums[i]);
                queueD.poll();
            }
            res.add(evaluateMedian(queue, queueD, k));
        }

        return res.stream().mapToDouble(d -> d).toArray();
    }

    private static double evaluateMedian(Queue<Integer> queue, ArrayDeque<Integer> queueD, float k) {
        queue.addAll(queueD);
        double median = 0d;
        if (k % 2 == 0) {
            var md = Math.ceil(k / 2);
            double count = 0;
            while (queue.peek() != null) {
                var q = queue.poll();
                System.out.println("->" + q);
                if (++count == md) {
                    median = (Double.valueOf(q) + Double.valueOf(queue.peek())) / 2d;
                }
            }
            System.out.println("------------------------------");
            System.out.println("print median: " + median);
            System.out.println("------------------------------");
        } else {
            var md = Math.ceil(k / 2);
            double count = 0;
            while (queue.peek() != null) {
                var q = queue.poll();
                System.out.println("->" + q);
                if (++count == md) {
                    median = q;
                }
            }
            System.out.println("------------------------------");
            System.out.println("print median: " + median);
            System.out.println("------------------------------");
        }
        return median;
    }
}











































