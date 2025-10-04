package ru.kalugin.ai.yandex.src.test;

import java.util.ArrayDeque;
import java.util.Set;

public class ValidBrackets {
    public static void main(String[] args) {
        System.out.println(isValid("((({]})))"));
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
}
