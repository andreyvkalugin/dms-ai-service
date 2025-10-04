package ru.kalugin.ai.yandex.src.com.company;

import java.io.IOException;

public class Main12 {
    public static void main(String[] args) throws IOException {
        var arr = new int[]{4, 5, 6, 6, 7, 0, 1, 2, 4, 4};
        var lengthArr = arr.length;
        var index = binarySearchArrayReverse(arr);
        System.out.println("index:" + index);
        System.out.println("arr length:" + lengthArr);
        for (var i = 0; i < arr.length; i++) {
            System.out.print(arr[getNextEl(i, index, lengthArr)]);
        }
    }

    private static int getNextEl(int i, int index, int length) {
        if (index == -1) {
            return i;
        }
        if ((i + index) >= length) {
            return i - (length - index);
        }
        return i + index;
    }

    private static int getReverseIndex(int i, int index, int length) {
        if (index == -1) {
            return index;
        }
        if ((i + index) >= length) {
            return i - (length - index);
        }
        return i + index;
    }

    private static int binarySearchArrayReverse(int[] nums) {
        var l = 0;
        var r = nums.length - 1;
        var count = 0;
        var target = 0;
        var forLeftPart = 0;
        while ((l + 1) < r) {
            var m = Math.round((l + r) / 2);
            if (count == 0) {
                forLeftPart = nums[m];
            }
            //обходим right часть
            if (count == 0 || nums[m] > target) {
                l = m;
                target = nums[m];
            } else {
                r = m;
            }
            count++;
        }
        if (nums[l] > nums[r]) {
            return r;
        } else {
            //при необходимости left часть
            l = 0;
            r = forLeftPart;
            target = nums[r];
            while ((l + 1) < r) {
                var m = Math.round((l + r) / 2);
                //обходим right часть
                if (nums[m] < target) {
                    r = m;
                } else {
                    l = m;
                    target = nums[m];
                }
            }
            if (nums[l] > nums[r]) {
                return r;
            }
        }
        return -1;
    }

}