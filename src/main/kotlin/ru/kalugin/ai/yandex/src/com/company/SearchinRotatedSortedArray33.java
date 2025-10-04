package ru.kalugin.ai.yandex.src.com.company;

import java.util.LinkedList;

public class SearchinRotatedSortedArray33 {
    static int lengthArr = 0;
    static int index = 0;

    public static void main(String[] args) {
        var arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(new SearchinRotatedSortedArray33().search(arr, 0));
    }

    public int search(int[] nums, int target) {
        lengthArr = nums.length;
        var ridArr = getRiddle(nums);
        index = binarySearchArrayReverse(ridArr);
        return getReverseIndex(binarySearcha(ridArr, target), index, lengthArr);
        //return binarySearcha(nums,target);
    }

    private static int[] getRiddle(int[] nums) {
        if (nums.length == 0) return nums;
        var rarr = new LinkedList<Integer>();
        var previous = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                previous = nums[0];
                rarr.add(previous);
            }
            if (nums[i] != previous) {
                rarr.add(nums[i]);
                previous = nums[i];
            }
        }
        return rarr.stream().mapToInt(i -> i).toArray();
    }

    private static int getReverseIndex(int i, int index, int length) {
        if (i == -1 || index == -1) {
            return i;
        }
        if ((i + index) >= length) {
            return i - (length - index);
        }
        return i + index;
    }

    private static int binarySearcha(int[] nums, int target) {
        var l = 0;
        var r = nums.length - 1;
        while ((l + 1) < r) {
            var m = Math.round((l + r) / 2);
            if (nums[getNextEl(m, index, lengthArr)] == target) return m;
            if (nums[getNextEl(m, index, lengthArr)] < target) {
                l = m;
            } else {
                r = m;
            }
        }
        if (nums[getNextEl(r, index, lengthArr)] == target) return r;
        if (nums[getNextEl(l, index, lengthArr)] == target) return l;
        return -1;
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

    private static int binarySearchArrayReverse(int[] nums) {
        var l = 0;
        var r = nums.length - 1;
        var count = 0;
        var target = 0;
        var forLeftPart = 0;
        while ((l + 1) < r) {
            var m = Math.round((l + r) / 2);
            if (count == 0) {
                forLeftPart = m;
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
