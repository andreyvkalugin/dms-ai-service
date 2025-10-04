package ru.kalugin.ai.yandex.src.com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main6 {
    static int count = 0;
    static int i = -1;

    public static void main(String[] args) throws Exception {
        //save massive and value + refresh after delete element
        var mapOfLowestValue = new HashMap<Integer, Integer>();
        Integer[][] inArr = {{1, 4, 5}, {1, 3, 4}, {2, 6}};

        var res = new ArrayList<Integer>();
        CopyOnWriteArrayList<Integer>[] al = new CopyOnWriteArrayList[inArr.length];

        for (var i = 0; i < inArr.length; i++) {
            al[i] = new CopyOnWriteArrayList<>(List.of(inArr[i]));
        }

        System.out.println(Arrays.toString(al));
        while (true) {
            i++;
            if (i >= al.length) {
                i = 0;
            }
            System.out.println("i: " + i);
            if (al[i].size() == 0) {
                if (i == 0) {
                    count = 0;
                }
                mapOfLowestValue.put(i, Integer.MAX_VALUE);
                ++count;
                if (count == al.length) break;
                continue;
            }
            System.out.println("al[i].get(0): " + al[i].get(0));
            System.out.println("al: " + Arrays.toString(al));
            mapOfLowestValue.put(i, al[i].get(0));
            System.out.println(mapOfLowestValue);
            if ((al.length - 1) == i) {
                var minV = mapOfLowestValue.values().stream().mapToInt(h -> h).min();
                mapOfLowestValue.forEach((k, v) -> {
                    if (v == minV.getAsInt()) {
                        System.out.println("K: " + k + " V:" + v);
                        System.out.println("al[k]: ");
                        System.out.println(al[k]);
                        System.out.println("mapOfLowestValue");
                        System.out.println(mapOfLowestValue);
                        System.out.println("al[k].get(0): ");
                        System.out.println(al[k].get(0));

                        res.add(al[k].get(0));
                        al[k].remove(0);
                    }
                });
            }
        }
        System.out.println(res);
    }

}