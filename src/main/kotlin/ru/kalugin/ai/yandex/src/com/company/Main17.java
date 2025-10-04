package ru.kalugin.ai.yandex.src.com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main17 {


    public static void main(String[] args) throws IOException {
        System.out.println(getArray(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> getArray(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        var elForCheck = IntStream.range(0, strings.length).boxed().collect(Collectors.toSet());

        for (var j = 0; j < strings.length; j++) {
            if (!elForCheck.contains(j)) {
                continue;
            }
            var innerL = new ArrayList<String>();
            innerL.add(strings[j]);
            for (var i = j + 1; i < strings.length; i++) {
                if (!elForCheck.contains(i)) {
                    continue;
                }
                if (!equalLex(new String[]{strings[i], strings[j]})) {
                    elForCheck.remove(i);
                    innerL.add(strings[i]);
                }
            }
            res.add(innerL);
            elForCheck.remove(j);
        }
        return res;
    }

    public static boolean equalLex(String[] strings) {
        AtomicBoolean noEqualFlag = new AtomicBoolean(false);
        HashMap<Character, Integer> indexesStr2 = new HashMap<>();

        char[] arrCh1 = strings[0].toCharArray();
        char[] arrCh2 = strings[1].toCharArray();
        if (arrCh1.length != arrCh2.length) {
            return true;
        }

        for (int k = 0; k < arrCh2.length; k++) {
            indexesStr2.put(arrCh2[k], indexesStr2.getOrDefault(arrCh2[k], 0) + 1);
        }

        for (var i = 0; i < arrCh1.length; i++) {
            if (indexesStr2.containsKey(arrCh1[i])) {
                var charNum = indexesStr2.get(arrCh1[i]);
                if (charNum > 1) {
                    indexesStr2.put(arrCh1[i], charNum - 1);
                } else {
                    indexesStr2.remove(arrCh1[i]);
                }
            } else {
                noEqualFlag.set(true);
            }
        }

        if (!indexesStr2.isEmpty()) {
            return true;
        }

        return noEqualFlag.get();
    }


}