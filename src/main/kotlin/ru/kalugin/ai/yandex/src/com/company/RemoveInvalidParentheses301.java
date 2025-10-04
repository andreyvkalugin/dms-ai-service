package ru.kalugin.ai.yandex.src.com.company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveInvalidParentheses301 {
    public static void main(String[] args) {
        //String expression = "(()()()";
        //removeInvalidParenthesis(expression);

        var expression = "()v)";
        removeInvalidParenthesis(expression);
    }

    // method checks if character is parenthesis(open
// or closed)
    static boolean isParenthesis(char c) {
        return ((c == '(') || (c == ')'));
    }

    // method returns true if string contains valid
// parenthesis
    static boolean isValidString(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                cnt++;
            else if (str.charAt(i) == ')')
                cnt--;
            if (cnt < 0)
                return false;
        }
        return (cnt == 0);
    }

    // method to remove invalid parenthesis
    static List<String> removeInvalidParenthesis(String str) {
        var arrLRes = new LinkedList<String>();
        if (str.isEmpty())
            return List.of();

        // visit set to ignore already visited string
        HashSet<String> visit = new HashSet<String>();

        // queue to maintain BFS
        Queue<String> q = new LinkedList<>();
        String temp;
        boolean level = false;

        // pushing given string as
        // starting node into queue
        q.add(str);
        visit.add(str);
        while (!q.isEmpty()) {
            str = q.peek();
            q.remove();
            if (isValidString(str)) {
                arrLRes.add(str);

                // If answer is found, make level true
                // so that valid string of only that level
                // are processed.
                level = true;
            }
            if (level)
                continue;
            for (int i = 0; i < str.length(); i++) {
                if (!isParenthesis(str.charAt(i)))
                    continue;

                // Removing parenthesis from str and
                // pushing into queue,if not visited already
                temp = str.substring(0, i) + str.substring(i + 1);
                if (!visit.contains(temp)) {
                    q.add(temp);
                    visit.add(temp);
                }
            }
        }
        return arrLRes;
    }
}
