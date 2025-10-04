package ru.kalugin.ai.yandex.src.com.company;

import java.util.*;

public class TopKFrequentElements347 {
    public static void main(String[] args) {

    }

    public static int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        while (res.size() < k) res.add(maxHeap.poll().getKey());
        return res.stream().mapToInt(i -> i).toArray();
    }
}
