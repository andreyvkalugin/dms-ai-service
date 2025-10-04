package ru.kalugin.ai.yandex.src.com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Main9 {

    static Deque<ListNode2> stack = new ArrayDeque<>();

    public static void main(String[] args) {
        addToStack(generate());
        ListNode2 firstEl = null;
        stack.forEach(el -> el.next = null);
        System.out.println("stack: " + stack);
        if (stack.peekLast() != null) {
            firstEl = stack.pollLast();
            reverseStack(firstEl);
        }
        printz(firstEl);
        //return firstEl;
    }

    private static void printz(ListNode2 fe) {
        System.out.print(fe + " -> ");
        if (!Objects.isNull(fe.next)) {
            printz(fe.next);
        }
    }

    private static void reverseStack(ListNode2 el) {
        if (stack.peekLast() == null) {
            return;
        }
        el.next = stack.pollLast();
        reverseStack(el.next);
    }

    private static void addToStack(ListNode2 generate) {
        stack.addLast(generate);
        if (Objects.isNull(generate.next)) {
            return;
        }
        addToStack(generate.next);
    }

    public static ListNode2 generate() {
        //1,2,3,4,5
        var l1 = new ListNode2(1);
        var l2 = new ListNode2(2);
        var l3 = new ListNode2(3);
        var l4 = new ListNode2(4);
        var l5 = new ListNode2(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        return l1;
    }

    public static ListNode2 generate2() {
        //4,6,5
        var l4 = new ListNode2(5);
        var l5 = new ListNode2(6);
        var l6 = new ListNode2(4);
        l4.next = l5;
        l5.next = l6;

        return l4;
    }

}

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                '}';
    }
}

class CoolListNode2 extends ListNode2 {
    static int count = 0;
    int index = ++count;

    public CoolListNode2(int x) {
        super(x);
    }
}







