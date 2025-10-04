package ru.kalugin.ai.yandex.src.com.company;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main20 {


    public static void main(String[] args) throws IOException {
        System.out.println(getArray("eat", "tea"));
    }

    public static boolean getArray(String s, String t) {
        var a = s.toCharArray();
        var b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        // Stream.of(a).collect(Collectors.joining());
        return Arrays.equals(a, b);
    }

}