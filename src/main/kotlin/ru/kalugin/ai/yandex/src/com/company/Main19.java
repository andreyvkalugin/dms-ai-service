package ru.kalugin.ai.yandex.src.com.company;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main19 {


    public static void main(String[] args) throws IOException {
        System.out.println(getArray(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> getArray(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strings) {

            char[] c = word.toCharArray();
            Arrays.sort(c);
            String hash = new String(c);
            if (map.containsKey(hash)) {
                map.get(hash).add(word);
            } else {
                List<String> l = new ArrayList<>();
                l.add(word);
                map.put(hash, l);
            }
        }

        return new ArrayList<List<String>>(map.values());
    }

}