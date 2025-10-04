package ru.kalugin.ai.yandex.src.com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main21 {


    public static void main(String[] args) throws IOException {
        System.out.println(getArray("eateat", "tea"));
    }

    public static List<Integer> getArray(String s, String p) {
        var count = 0;
        var a = s.toCharArray();
        var b = p.toCharArray();
        var list = new LinkedList<Integer>();
        Arrays.sort(b);
        for (var i = 0; (i + b.length - 1) < a.length; i++) {
            //var res = Arrays.copyOfRange(a, i, i + b.length);
            var res = new char[b.length];
            for (int j = i, k = 0; j < (i + b.length); j++, k++) {
                res[k] = a[j];
            }
            Arrays.sort(res);
            if (Arrays.equals(res, b)) {
                list.add(i);
            }
        }

        return list;
    }

}