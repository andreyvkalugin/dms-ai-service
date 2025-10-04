package ru.kalugin.ai.yandex.src.com.company;

import java.util.Objects;

public class ReverseList {

    public static void main(String[] args) {
        var a = reverseList(null);
        printz(a);
    }

    public static ListNode reverseList(ListNode head) {
        var current = generate();
        ListNode prev;
        ListNode next = current.next;
        var flag = true;
        while (next != null) {
            prev = current;
            current = next;
            next = current.next;
            current.next = prev;
            if (flag) {
                prev.next = null;
                flag = false;
            }
        }
        return current;
    }

    private static void printz(ListNode fe) {
        System.out.print(fe + " -> ");
        if (!Objects.isNull(fe.next)) {
            printz(fe.next);
        }
    }

    public static ListNode generate() {
        //[1,2,3,4,5]
        var l1 = new ListNode(1);
        var l2 = new ListNode(2);
        var l3 = new ListNode(3);
        var l4 = new ListNode(4);
        var l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        return l1;
    }
}
