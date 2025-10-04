package ru.kalugin.ai.yandex.src.test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

public class FindAnagram {
    public static void main(String[] args) {
        var findAnagram = "ab";
        var findAnagramArr = findAnagram.split("");
        var text = "abab";
        var textArray = text.split("");
        Arrays.sort(findAnagramArr);
        Queue<String> queue = new ArrayDeque<>();
        var result = new HashSet<Integer>();

        for (var i = 0; i < textArray.length; i++) {
            var arr = queAddElements(queue, textArray[i], findAnagram);
            Arrays.sort(arr);
            if (Arrays.equals(arr, findAnagramArr)) {
                result.add(i - findAnagramArr.length + 1);
            }
        }

        System.out.println(result);
    }

    private static String[] queAddElements(Queue<String> queue, String txt, String findAnagram) {
        if (queue.size() >= findAnagram.length()) {
            queue.poll();
            queue.add(txt);

            return queue.toArray(new String[1]);
        }
        queue.add(txt);
        return queue.toArray(new String[1]);
    }
}
