package ru.kalugin.ai.yandex.src.test;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Add_Two_Numbers {

    static Deque<Integer> stack = new ArrayDeque<Integer>();

    public static void main(String[] args) {

        var result1 = getResultForLinkedList(generate1());
        System.out.println(result1);
        stack.clear();
        var result2 = getResultForLinkedList(generate2());
        System.out.println(result2);
        System.out.println("//////////////");
        System.out.println(result1.add(result2));
        //var str = reverseString(String.valueOf(result1+result2));
        //  var j = getLn(null, null,result1.add(result2).toString());
        var j = getLN(null, result1.add(result2).toString());
        printListNodes(j);
    }

    private static ListNode1 getLn(ListNode1 head, ListNode1 ln, String str) {
        if ("".equals(str)) return head;
        var nLn = new ListNode1(Integer.parseInt(str.substring(str.length() - 1)));
        if (ln != null) {
            ln.next = nLn;
        } else {
            head = nLn;
        }
        return getLn(head, nLn, str.substring(0, str.length() - 1));
    }

    private static ListNode1 getLN(ListNode1 ln, String str) {
        if ("".equals(str)) {
            return ln;
        }
        var l = new ListNode1(Integer.parseInt(str.substring(0, 1)));
        l.next = ln;
        return getLN(l, str.substring(1));
    }

    private static void printListNodes(ListNode1 listNode) {
        var sb = new StringBuilder();
        var temp = listNode;
        while (temp.next != null) {
            sb.append(temp.val).append("->");
            temp = temp.next;
        }
        System.out.println(sb.append(temp.val));
    }

    private static BigInteger getResultForLinkedList(ListNode1 listNode) {
        stack.addLast(listNode.val);
        if (Objects.isNull(listNode.next)) {
            var sb = new StringBuilder();
            while (stack.peekLast() != null) {
                sb.append(stack.pollLast());
            }
            return new BigInteger(sb.toString());
        }
        return getResultForLinkedList(listNode.next);
    }

    public static String reverseString(String str) {
        char ch[] = str.toCharArray();
        String rev = "";
        for (int i = ch.length - 1; i >= 0; i--) {
            rev += ch[i];
        }
        return rev;
    }

    public static ListNode1 generate1() {
        //3,4,2
        var l1 = new ListNode1(2);
        var l2 = new ListNode1(4);
        var l3 = new ListNode1(3);
        l1.next = l2;
        l2.next = l3;

        return l1;
    }

    public static ListNode1 generate2() {
        //4,6,5
        var l4 = new ListNode1(5);
        var l5 = new ListNode1(6);
        var l6 = new ListNode1(4);
        l4.next = l5;
        l5.next = l6;

        return l4;
    }

}

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "-> {" +
                "val=" + val +
                '}';
    }
}

class CoolListNode1 extends ListNode1 {
    static int count = 0;
    int index = ++count;

    public CoolListNode1(int x) {
        super(x);
    }
}







