package ru.kalugin.ai.yandex.src.com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Main14 {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {

        int i = 0, j = numbers.length - 1;
        int[] x = new int[2];

        HashMap<Integer, Integer> indexes = new HashMap<>();

        for (int k = 0; k < numbers.length; k++) {
            if (!indexes.containsKey(numbers[k])) {
                indexes.put(numbers[k], k);
            }
            //duplicates cannot be solutions unless they sum up to target
            else if (numbers[k] * 2 == target) {
                x[0] = indexes.get(numbers[k]);
                x[1] = k;
                return x;
            }
        }

        Arrays.sort(numbers);
        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                x[0] = indexes.get(numbers[i]);
                x[1] = indexes.get(numbers[j]);
                if (x[0] > x[1]) {
                    int temp = x[1];
                    x[1] = x[0];
                    x[0] = temp;
                }
                return x;
            }
        }

        return x;
    }


}