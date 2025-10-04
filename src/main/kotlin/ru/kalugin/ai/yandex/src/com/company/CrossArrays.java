package ru.kalugin.ai.yandex.src.com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class CrossArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 0};
        int[] arr2 = {5, 1, 2, 7, 3, 2};
        String str = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";

        System.out.println(getAllInHotel(new Integer[][]{{1, 2}, {1, 3}, {2, 4}, {2, 3}}));


    }

    private static int getAllInHotel(Integer[][] ints) {
        var lastDayInHotel = new AtomicInteger(Integer.MIN_VALUE);
        Arrays.stream(ints).forEach(arr -> {
            lastDayInHotel.set(Math.max(arr[1], lastDayInHotel.get()));
        });
        var maxUsers = Integer.MIN_VALUE;
        //days to user count
        var map = new HashMap<Integer, Integer>();
        for (var i = 1; i <= lastDayInHotel.get(); i++) {
            var cnt = 0;
            for (var userRange : ints) {
                if (userInHotelForThatDay(userRange, i)) {
                    map.put(i, ++cnt);
                }
            }
        }
        return map.values().stream().mapToInt(i -> i).max().orElse(Integer.MIN_VALUE);
    }

    private static boolean userInHotelForThatDay(Integer[] anInt, int i) {
        return anInt[0] <= i && anInt[1] >= i;
    }


    private static Integer getArrayRepeatingElem(int[] ints) {
        var max = Integer.MIN_VALUE;
        var cnt = 0;
        var indentUsed = false;
        for (var i = 0; i < ints.length; i++) {
            if (ints[i] > 0) {
                cnt++;
                max = Math.max(max, cnt);
            } else {
                if (!indentUsed) {
                    indentUsed = true;
                    continue;
                }
                cnt = 0;
                indentUsed = false;
            }
        }
        return max;
    }


    private static String getArraysSubArray(int[] ints) {
        Arrays.sort(ints);
        var res = new StringBuilder();
        var start = ints[0];
        var finish = Integer.MIN_VALUE;
        for (var i = 1; i < ints.length; i++) {
            if (ints[i] - ints[i - 1] > 1) {
                finish = ints[i - 1];
                res.append(start).append("-").append(finish != Integer.MIN_VALUE && finish != start ? finish : "").append(", ");
                start = ints[i];
                finish = Integer.MIN_VALUE;
            }
        }
        res.append(start).append("-").append(finish != Integer.MIN_VALUE ? finish : "").append(", ");
        return res.toString();
    }


    private static String getRLE(String str) {
        var sb = new StringBuilder();
        var cnt = 1;
        var previous = str.charAt(0);
        var chArr = str.toCharArray();
        for (var i = 1; i < chArr.length; i++) {
            if (chArr[i] == previous) {
                cnt++;
                continue;
            }
            sb.append(previous);
            if (cnt > 1) sb.append(cnt);
            previous = chArr[i];
            cnt = 1;
        }
        sb.append(previous);
        if (cnt > 1) sb.append(cnt);
        return sb.toString();
    }

    private static void intersectionSet1(int[] arr1, int[] arr2) {
        for (var el2 : arr2) {
            for (var el1 : arr1) {
                if (el2 == el1) {
                    System.out.println(el2);
                    break;
                }
            }
        }
    }

    public static Integer[] intersectionSet(int[] a, int[] b) {
        var aI = Arrays.stream(a).boxed().toArray(Integer[]::new);
        var bI = Arrays.stream(b).boxed().toArray(Integer[]::new);
        return Stream.of(aI)
                .filter(Arrays.asList(bI)::contains)
                .distinct()
                .toArray(Integer[]::new);
    }
}
