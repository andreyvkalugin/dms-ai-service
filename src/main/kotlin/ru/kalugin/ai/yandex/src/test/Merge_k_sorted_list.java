package ru.kalugin.ai.yandex.src.test;

import java.util.Arrays;
import java.util.Objects;

public class Merge_k_sorted_list {
    //lists = [[1,4,5],[1,3,4],[2,6]]

    public static void main(String[] args) {
        var a5 = new ListNode(5, null);
        var a4 = new ListNode(4, a5);
        var a1 = new ListNode(1, a4);

        var b4 = new ListNode(4, null);
        var b3 = new ListNode(3, b4);
        var b1 = new ListNode(1, b3);

        var c6 = new ListNode(6, null);
        var c2 = new ListNode(2, c6);

        ListNode[] lists = {a1, b1, c2};

        ListNode min = null;
        ListNode result = null;
        var minIndex = -1;
        var isFirstIteration = true;
        var isArrayNotEmpty = lists.length != 0;

        while (isArrayNotEmpty) {
            ListNode minLocal = null;
            var count = 0;
            for (var i = 0; i < lists.length; i++) {

                var listNode = lists[i];
                if (Objects.nonNull(lists[i])) {

                    if (minLocal == null || (listNode.val < minLocal.val)) {
                        minLocal = listNode;
                        minIndex = i;
                    }
                    count++;
                }
            }

            if (count == 0) {
                break;
            }

            if (isFirstIteration) {
                min = minLocal;
                result = min;
                isFirstIteration = false;
            } else {
                min.next = minLocal;
                min = minLocal;
            }

            lists[minIndex] = lists[minIndex].next;
        }

        printListNodes(result);
    }

    private static boolean listsNotEmpty(ListNode[] lists) {
        return Arrays.stream(lists).anyMatch(Objects::nonNull);
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
}

class ListNode {
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