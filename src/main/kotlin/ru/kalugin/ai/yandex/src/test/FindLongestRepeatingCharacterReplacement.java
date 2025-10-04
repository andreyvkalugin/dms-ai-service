package ru.kalugin.ai.yandex.src.test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindLongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        var instance = new FindLongestRepeatingCharacterReplacement();
        System.out.println(instance.characterReplacement("AABABBBA", 1));
    }

    public int characterReplacement(String s, int k) {
        String[] array = s.split("");
        var max = Integer.MIN_VALUE;
        var pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < array.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (int j = i; j < array.length; j++) {
                map.merge(array[j], 1, (oldVal, newVal) -> oldVal + 1);
                if (evalDrain(map, k, pq, array[j]) || j == (array.length - 1)) {
                    max = Math.max(max, map.values().stream().mapToInt(y -> y).sum());
                    map.clear();
                    break;
                }
            }
        }

        return max;
    }

    private boolean evalDrain(Map<String, Integer> map, int k, PriorityQueue<Integer> pq, String value) {
        if (map.keySet().size() == 1) return false;
        pq.clear();
        pq.addAll(map.values());
        pq.poll();
        if (pq.stream().mapToInt(y -> y).sum() > k) {
            map.put(value, map.get(value) - 1);
            return true;
        }
        return false;
    }
}
