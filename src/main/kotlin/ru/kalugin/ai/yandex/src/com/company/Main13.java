package ru.kalugin.ai.yandex.src.com.company;

import java.io.IOException;

public class Main13 {
    public static void main(String[] args) throws IOException {
        System.out.println(binarySearcha(new int[]{1, 2, 2, 4, 4, 6, 6, 7, 7, 8, 8}));
    }

    private static int binarySearcha(int[] nums) {
        final int lastElInx = nums.length - 1;
        for (var j = 0; j < nums.length; j++) {
            var el = nums[j];
            for (var i = 0; i < nums.length; i++) {
                if (i == j && j != lastElInx) {
                    continue;
                }
                if (el == nums[i]) {
                    if (j == lastElInx && i == lastElInx) {
                        return nums[j];
                    }
                    break;
                }
                if (i == (nums.length - 1)) {
                    return el;
                }
            }
        }
        return -1;
    }

}