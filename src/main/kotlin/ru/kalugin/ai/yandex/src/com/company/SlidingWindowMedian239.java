package ru.kalugin.ai.yandex.src.com.company;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMedian239 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -3, -1, -4, 3, 6, 7}, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k || nums.length == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - k >= 0 && !deque.isEmpty() && deque.peek() == i - k) deque.pollFirst();
            int add = nums[i];
            while (!deque.isEmpty() && add >= nums[deque.getLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i - k + 1 >= 0) result[index++] = nums[deque.getFirst()];
        }
        return result;
    }


}
