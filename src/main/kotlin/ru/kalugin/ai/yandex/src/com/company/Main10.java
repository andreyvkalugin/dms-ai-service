package ru.kalugin.ai.yandex.src.com.company;

import java.io.IOException;

import static java.util.Arrays.binarySearch;

public class Main10 {
    public static void main(String[] args) throws IOException {
        System.out.println(binarySearcha(new int[]{0, 1, 2, 4, 4, 5, 6, 6, 7}, 4));
        // System.out.println(binarySearch(new int[]{-1,0,3,5,9,12},9));
    }

    private static int binarySearcha(int[] nums, int target) {
        var l = 0;
        var r = nums.length - 1;
        while ((l + 1) < r) {
            var m = Math.round((l + r) / 2);
            if (nums[m] == target) return m;
            if (nums[m] < target) {
                l = m;
            } else {
                r = m;
            }
        }
        if (nums[r] == target) return r;
        if (nums[l] == target) return l;
        return -1;
    }

}