package ru.kalugin.ai.yandex.src.test;

import java.util.*;

public class SplitStringAtManyParts {
    public static void main(String[] args) {
        var str = "ababcbacadefegdehijhklij";

        var list = getPartitions(str);
        System.out.println(list);
    }

    private static List<Integer> getPartitions(String str) {

        Map<String, Integer> map = new HashMap<>();
        var mas = str.split("");
        var res = new ArrayList<Integer>();

        for (var i = 0; i < mas.length; i++) {
            map.merge(mas[i], i, Math::max);
        }

        var max = -1;
        var count = 1;
        for (var i = 0; i < mas.length; i++) {

            max = Math.max(map.get(mas[i]), max);
            if (max <= i) {
                res.add(count);
                count = 0;
                max = -1;
            }
            count++;
        }
        System.out.println(map);

        return res;
    }

}
