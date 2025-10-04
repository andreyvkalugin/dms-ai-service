package ru.kalugin.ai.yandex.src.test;

public class ReverseArrayLinked {
    public static void main(String[] args) {
        var a5 = new ListNode(5, null);
        var a4 = new ListNode(4, a5);
        var a1 = new ListNode(1, a4);

        printListNodes(reverseListNode(null, a1, a1.next));
    }

    private static ListNode reverseListNode(ListNode past, ListNode current, ListNode next) {
        current.next = past;
        past = current;
        current = next;
        next = current.next;
        if (next == null) {
            current.next = past;
            return current;
        }
        return reverseListNode(past, current, next);
    }

    private static void printListNodes(ListNode listNode) {
        var sb = new StringBuilder();
        var temp = listNode;
        while (temp.next != null) {
            sb.append(temp.val).append(" -> ");
            temp = temp.next;
        }
        System.out.println(sb.append(temp.val));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}


