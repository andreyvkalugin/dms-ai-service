package ru.kalugin.ai.yandex.src.com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main7 {

    static int count = -1;

    static List<Map<Integer, ListNode>> listNodeList = new CopyOnWriteArrayList<>();
    static Set<ListNode> set = new HashSet<>();

    public static void main(String[] args) {

        checks(generate());
    }

    private static boolean checks(ListNode listNode) {
        var coolListNode = adapter(listNode);
        System.out.println("cicle: " + coolListNode);
        return coolListNode >= 0;
    }

    private static int adapter(ListNode listNode) {
        if (listNode == null) {
            return -1;
        }
        var findCicle = listNodeList.stream().filter(listNode1 -> listNode1.values().stream().findFirst().get() == listNode.next).findFirst();
        listNodeList.add(Map.of(++count, listNode));
        if (findCicle.isPresent()) {
            return findCicle.get().keySet().stream().findFirst().get();
        }
        return adapter(listNode.next);
    }

    private static int adapter1(ListNode listNode) {
        if (listNode == null) return -1;
        set.add(listNode);
        if (set.contains(listNode.next)) {
            return 1;
        }
        return adapter1(listNode.next);
    }

//    private static CoolListNode adapter(ListNode listNode) {
//        var coolListNode = new CoolListNode(listNode.val);
//        coolListNodeList.add(coolListNode);
//        var findCicle = coolListNodeList.stream().filter(coolListNode1 -> coolListNode1.next==listNode.next).findFirst();
//        if(findCicle.isPresent()){
//            return findCicle.get();
//        }
//        coolListNode.next = adapter(listNode.next);
//
//        return coolListNode;
//    }

    public static ListNode generate() {
        //3,2,0,-4
        var l1 = new ListNode(3);
        var l2 = new ListNode(2);
        var l3 = new ListNode(0);
        var l4 = new ListNode(-4);
        var l5 = new ListNode(9);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l1;

        return l1;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
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

class CoolListNode extends ListNode {
    static int count = 0;
    int index = ++count;

    public CoolListNode(int x) {
        super(x);
    }
}







