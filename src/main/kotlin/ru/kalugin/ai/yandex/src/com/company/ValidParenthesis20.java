package ru.kalugin.ai.yandex.src.com.company;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ValidParenthesis20 {
    public static void main(String[] args) {
        System.out.println(isValid("()]{}"));
    }

    static public boolean isValid(String s) {
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
