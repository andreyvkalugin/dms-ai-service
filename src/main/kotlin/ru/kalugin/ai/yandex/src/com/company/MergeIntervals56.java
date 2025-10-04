package ru.kalugin.ai.yandex.src.com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MergeIntervals56 {
    public static void main(String[] args) {
        var a = merge(new int[][]{{1, 4}, {0, 2}, {3, 5}});
        System.out.println(Arrays.deepToString(a));
    }

    private static int[][] merge(int[][] ints) {
        Arrays.sort(ints, Comparator.comparing(el -> el[0]));
        List<int[]> list = new CopyOnWriteArrayList<>(List.of(ints));
        getLists(list);
        return list.toArray(new int[0][0]);
    }

    private static void getLists(List<int[]> list) {
        for (var i = 0; i < (list.size() - 1); i++) {
            if (list.get(i)[1] >= list.get(i + 1)[0]) {
                if (list.get(i)[1] > list.get(i + 1)[1]) {
                    list.remove(i + 1);
                    getLists(list);
                } else {
                    var from = list.get(i)[0];
                    var to = list.get(i + 1)[1];

                    list.get(i)[0] = from;
                    list.get(i)[1] = to;
                    list.remove(i + 1);
                    getLists(list);
                }
            }
        }
    }
}
