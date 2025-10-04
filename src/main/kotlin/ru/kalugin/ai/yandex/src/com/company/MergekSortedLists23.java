package ru.kalugin.ai.yandex.src.com.company;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class MergekSortedLists23 {
    public static void main(String[] args) {
        printListNodes(getListsMergeK(generate()));
    }

    private static ListNode getListsMergeK(ListNode[] lists) {
        if (null == lists || lists.length == 0) return null;
        int len = lists.length;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(len, Comparator.comparingInt(v -> v.val));
        for (ListNode node : lists) {
            if (Objects.nonNull(node)) queue.offer(node);
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (Objects.nonNull(node)) {
                temp.next = node;
                temp = temp.next;
                if (node.next != null) queue.offer(node.next);
            }
        }
        return result.next;
    }

    private static void printListNodes(ListNode listNode) {
        var sb = new StringBuilder();
        var temp = listNode;
        while (temp.next != null) {
            sb.append(temp.val).append("->");
            temp = temp.next;
        }
        System.out.println(sb.append(temp.val));
    }

    public static ListNode[] generate() {
        //[1,4,5],[1,3,4],[2,6]
        var l1 = new ListNode(1);
        var l2 = new ListNode(4);
        var l3 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;

        var l21 = new ListNode(1);
        var l22 = new ListNode(3);
        var l23 = new ListNode(4);

        l21.next = l22;
        l22.next = l23;

        var l31 = new ListNode(2);
        var l32 = new ListNode(6);

        l31.next = l32;

        return new ListNode[]{l1, l21, l31};
    }
}
