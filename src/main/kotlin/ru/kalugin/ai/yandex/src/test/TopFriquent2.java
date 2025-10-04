package ru.kalugin.ai.yandex.src.test;

import java.util.*;
import java.util.stream.IntStream;

public class TopFriquent2 {
    public static void main(String[] args) {
        int[] s = {1, 1, 1, 2, 2, 3};
        int[] arr = getArrayFrEl(s, 2);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] getArrayFrEl(int[] nums, int k) {
        var hm = new HashMap<Integer, Integer>();
        for (var el : nums) {
            hm.merge(el, 1, Integer::sum);
        }

        Comparator<Map.Entry<Integer, Integer>> comp = Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder());

        Queue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(comp);

        for (var em : hm.entrySet()) {
            priorityQueue.offer(em);
        }

        return IntStream.rangeClosed(1, k).limit(Math.min(k, priorityQueue.size())).map(i -> priorityQueue.poll().getKey()).toArray();
    }
}
