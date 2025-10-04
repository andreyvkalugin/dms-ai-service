package ru.kalugin.ai.yandex.src.test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        var av = List.of("A", "B", "C");
        av.forEach(System.out::println);
        var pq = new PriorityQueue<Integer>((a, b) -> b - a);
        pq.offer(1);
        pq.offer(3);
        pq.offer(5);
        pq.offer(10);
        System.out.println(pq.poll());
    }
}
