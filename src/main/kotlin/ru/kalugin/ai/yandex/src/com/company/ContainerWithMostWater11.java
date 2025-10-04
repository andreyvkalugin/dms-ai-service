package ru.kalugin.ai.yandex.src.com.company;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 99, 99}));
    }

    static public int maxArea(int[] A) {
        var len = A.length;
        int l = 0;
        int r = len - 1;
        int area = 0;

        while (l < r) {
            // Calculating the max area
            area = Math.max(area,
                    Math.min(A[l], A[r]) * (r - l));

            if (A[l] < A[r])
                l += 1;

            else
                r -= 1;
        }
        return area;
    }
}
