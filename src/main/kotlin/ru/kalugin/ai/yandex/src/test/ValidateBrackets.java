package ru.kalugin.ai.yandex.src.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ValidateBrackets {

    Map<Integer, Set<String>> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        var str = "e)k()(())";
        var d = new ValidateBrackets();
        System.out.println(d.recCheck(str, 0));
        var key = d.map.keySet().stream().mapToInt(e -> e).min();
        var arl = new ArrayList<>();
        key.ifPresent(e -> arl.addAll(d.map.get(e)));
        System.out.println(arl);

    }

    private boolean recCheck(String str, int count) {
        if (isValid(str)) {
            var st = map.getOrDefault(count, new HashSet<>());
            st.add(str);
            map.put(count, st);
        }
        if (str.length() == 1) return false;
        for (var i = 0; i < str.length(); i++) {
            String localStr;
            if ((i + 1) < str.length()) {
                localStr = str.substring(0, i) + str.substring(i + 1);
            } else {
                localStr = str.substring(0, i);
            }
            recCheck(localStr, count + 1);
        }
        return true;
    }

    public static boolean isValid(String s) {
        var setOfBrackets = Set.of("(", ")", "{", "}", "[", "]");
        var setOfOpenBrackets = Set.of("(", "{", "[");
        var setOfClosedBrackets = Set.of(")", "}", "]");
        ArrayDeque<String> stack = new ArrayDeque<String>();

        for (var ch : s.split("")) {
            if (setOfOpenBrackets.contains(ch)) {
                stack.offerLast(ch);
                continue;
            }

            if (setOfClosedBrackets.contains(ch)) {

                if (coorelate(stack.peekLast(), ch)) {
                    stack.pollLast();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean coorelate(String el, String ch) {
        if ("{".equals(el)) {
            return "}".equals(ch);
        }
        if ("[".equals(el)) {
            return "]".equals(ch);
        }
        if ("(".equals(el)) {
            return ")".equals(ch);
        }
        return false;
    }

    static public boolean isValid2(String s) {
        var queue = new ArrayDeque<>();

        for (var ch : s.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(') {
                queue.push(ch);
                continue;
            }
            try {
                if (ch == ']') {
                    if (queue.pop().equals('[')) {
                        continue;
                    } else {
                        return false;
                    }
                }
                if (ch == '}') {
                    if (queue.pop().equals('{')) {
                        continue;
                    } else {
                        return false;
                    }
                }
                if (ch == ')') {
                    if (queue.pop().equals('(')) {
                        continue;
                    } else {
                        return false;
                    }
                }
            } catch (NoSuchElementException e) {
                return false;
            }

        }
        return queue.isEmpty();
    }
}
