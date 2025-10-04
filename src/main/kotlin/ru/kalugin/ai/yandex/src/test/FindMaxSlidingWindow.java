package ru.kalugin.ai.yandex.src.test;

import java.util.Arrays;

public class FindMaxSlidingWindow {
    public static void main(String[] args) {
        var res = new FindMaxSlidingWindow().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(res));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] window = new int[k];
        int[] ans = new int[nums.length - k + 1];

        if (k == 1) {
            return nums;
        }

        for (var i = 0; i < k; i++) {
            window[i] = nums[i];
        }

        Arrays.sort(window);
        for (var i = k; i <= nums.length; i++) {
            ans[i - k] = window[k - 1];
            removeElem(nums[i - k], window);
            if (i < nums.length) {
                insertElem(nums[i], window);
            }
        }

        return ans;
    }

    private void insertElem(int num, int[] window) {
        window[window.length - 1] = num;
        for (var i = window.length - 1; i > 0; i--) {
            if (window[i] < window[i - 1]) {
                var temp = window[i];
                window[i] = window[i - 1];
                window[i - 1] = temp;
                continue;
            }
            break;
        }
    }

    private void removeElem(int num, int[] window) {
        var fi = -1;
        for (var i = 0; i < window.length; i++) {
            if (window[i] == num) {
                fi = i;
            }
        }

        for (var i = fi; i < window.length - 1; ) {
            window[i] = window[++i];
        }
    }
}
