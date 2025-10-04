package ru.kalugin.ai.yandex.src.com.company;

import java.io.IOException;
import java.util.HashSet;

public class Main13_2 {
    public static void main(String[] args) throws IOException {
        System.out.println(binarySearcha(new int[]{8, 9}));
    }

    private static int binarySearcha(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++)
            res = res ^ nums[i];

        return res;
    }

}