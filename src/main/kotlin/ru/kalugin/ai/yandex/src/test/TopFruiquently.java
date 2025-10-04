package ru.kalugin.ai.yandex.src.test;

import java.util.*;
import java.util.stream.Collectors;

public class TopFruiquently {


    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is", "a"}, 2));
    }

    static public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new LinkedList<>(); // add front from min heap
        Map<String, Map.Entry<String, Integer>> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, Map.entry(word, map.get(word).getValue() + 1));
            } else {
                map.put(word, Map.entry(word, 1));
            }
        }

        Comparator<Map.Entry<String, Integer>> comp = Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder());

        return map.values()
                .stream()
                .sorted(comp.thenComparing(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .limit(k)
                .toList();
    }
}
