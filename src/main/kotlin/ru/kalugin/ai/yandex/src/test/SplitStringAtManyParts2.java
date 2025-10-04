package ru.kalugin.ai.yandex.src.test;

import java.util.*;

public class SplitStringAtManyParts2 {
    public static void main(String[] args) {
        var str = "ababcbacadefegdehijhklij";

        var list = getPartitions(str);
        System.out.println(list);
    }

    private static List<Integer> getPartitions(String str) {

        List<List<String>> list = new LinkedList<>();
        List<List<String>> tmpList = new LinkedList<>();
        var mas = str.split("");
        var flag = false;

        for (var i = 0; i < mas.length; i++) {
            tmpList.clear();
            flag = false;
            for (var r : list) {
                if (r.contains(mas[i])) {
                    flag = true;
                    break;
                }
                tmpList.add(r);
            }

            if (flag) {
                list.removeAll(tmpList);
                var a = list.stream().flatMap(Collection::stream).toList();
                list.clear();
                list.addAll(tmpList);

                var t = new ArrayList<>(a);
                t.add(mas[i]);

                list.add(t);
            } else {
                list.add(new ArrayList<>(List.of(mas[i])));
            }
        }

        System.out.println(list);

        return list.stream().map(List::size).toList();
    }

}
