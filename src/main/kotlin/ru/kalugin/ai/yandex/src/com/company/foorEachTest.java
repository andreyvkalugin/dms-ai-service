package ru.kalugin.ai.yandex.src.com.company;

import java.util.ArrayList;

public class foorEachTest {
    public static void main(String[] args) {
        var as = new ArrayList<>();
        as.add(null);
        as.add(null);
        as.add(null);
        as.forEach(System.out::println);
    }
}
