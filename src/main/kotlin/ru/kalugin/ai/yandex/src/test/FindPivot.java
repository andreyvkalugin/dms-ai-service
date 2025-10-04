package ru.kalugin.ai.yandex.src.test;

class FindPivot {

    public static void main(String[] args) {

    }

    private static int reverseValue(int result, int pivot, int length) {
        if ((result + pivot) < length) {
            return result + pivot;
        } else {
            return (result + pivot) % length;
        }
    }

    public static int findIndex(int[] nums) {
        var l = 0;
        var r = nums.length - 1;
        while ((l + 1) < r) {
            var m = Math.round((l + r) / 2);
            if (nums[l] < nums[m]) {
                l = m;
            } else {
                r = m;
            }
        }
        if (nums[r] < nums[l]) {
            return r;
        }
        return -1;
    }

    public static int search(int[] nums, int target, int offset) {
        var l = 0;
        var r = nums.length - 1;
        while ((l + 1) < r) {
            var m = Math.round((l + r) / 2);
            if (getValue(nums, m, offset) == target) return m;
            if (getValue(nums, m, offset) < target) {
                l = m;
            } else {
                r = m;
            }
        }
        if (getValue(nums, r, offset) == target) return r;
        if (getValue(nums, l, offset) == target) return l;
        return -1;
    }

    static int getValue(int[] massive, int num, int offset) {
        if ((num + offset) < massive.length) {
            return massive[num + offset];
        } else {
            var n = (num + offset) % massive.length;
            return massive[n];
        }
    }
}
