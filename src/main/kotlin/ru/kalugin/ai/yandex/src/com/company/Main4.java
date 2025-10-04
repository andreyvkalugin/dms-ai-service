package ru.kalugin.ai.yandex.src.com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main4 {
    public static void main(String[] args) throws Exception {

        var Jarr = new CopyOnWriteArrayList<Character>();
        var Sarr = new CopyOnWriteArrayList<Character>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // считаем сначала первую строку
        String lineJ = reader.readLine();
        Jarr.addAll(getChars(lineJ));
        String lineS = reader.readLine();
        Sarr.addAll(getChars(lineS));

        var size = Sarr.size();
        if (size != Jarr.size()) {
            System.out.println(0);
        }

        for (char s : Sarr) {
            for (var j = 0; j < Jarr.size(); j++) {
                if (Jarr.get(j) == s) {
                    Jarr.set(j, '#');
                }
            }
        }

        if (Jarr.stream().allMatch(el -> '#' == (char) el)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    private static Collection<Character> getChars(String line) {
        var res = new ArrayList<Character>();
        for (int i = 0; i < line.length(); i++) {
            var a = line.charAt(i);
            res.add(a);
        }
        return res;
    }

}