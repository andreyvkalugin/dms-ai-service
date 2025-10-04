package ru.kalugin.ai.yandex.src.com.company;


import java.util.*;

public class TopFrickuentlyWords692 {

    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 2));
    }

    static public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new LinkedList<>(); // add front from min heap
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        // max heap
        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) pq.poll();
        }

        while (!pq.isEmpty()) {
            res.add(0, pq.poll().getKey()); // only record the name
        }

        return res;
    }
}
