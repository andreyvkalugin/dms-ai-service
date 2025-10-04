package ru.kalugin.ai.yandex.src.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Group_Anagrams {
    public static void main(String[] args) {
        var strs = Set.of("eat", "tea", "tan", "ate", "nat", "bat");
        var anagram = returnAnagram(strs);
        System.out.println(anagram);
    }

    private static Collection<Set<String>> returnAnagram(Set<String> strs) {
        var hs = new HashMap<Set<String>, Set<String>>();
        for (var str : strs) {
            var splStr = Set.of(str.split(""));

            var key = hs.keySet()
                    .stream()
                    .filter(k -> k.equals(splStr))
                    .findAny();

            key.ifPresentOrElse(k -> {
                var set = hs.get(k);
                set.add(str);
                hs.put(k, set);
            }, () -> {
                hs.put(splStr, new HashSet<String>(Set.of(str)));
            });
        }
        return hs.values();
    }
}
