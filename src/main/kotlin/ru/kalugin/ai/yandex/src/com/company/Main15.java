package ru.kalugin.ai.yandex.src.com.company;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Main15 {
    static List<List<Integer>> resO = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // System.out.println(Arrays.toString(twoSum(new int[]{1,0,-1,0,-2,2}, 0)));
        System.out.println(f(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
    }

    public static List<List<Integer>> f(int[] nums, int target) {

//        HashMap<Integer, List<Integer>> indexes = new HashMap<>();
//
//        for (int k = 0; k < numbers.length; k++) {
//            if (!indexes.containsKey(numbers[k])) {
//                indexes.put(numbers[k], new ArrayList<>());
//            }
//            indexes.get(numbers[k]).add(k);
//        }
        resO.clear();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    for (int l = 0; l < nums.length; l++) {
                        if ((nums[i] + nums[j] + nums[k] + nums[l]) == target && notEqual(i, j, k, l)) {
                            if (!checkArray(nums[i], nums[k], nums[j], nums[l])) {
                                List<Integer> res = new ArrayList<>();
                                res.add(nums[i]);
                                res.add(nums[k]);
                                res.add(nums[j]);
                                res.add(nums[l]);
                                resO.add(res);
                            }
                        }
                    }
                }
            }
        }
        return resO;
    }

    private static boolean checkArray(int number, int number1, int number2, int number3) {
        var finRes = 0;
        for (var list : resO) {
            var arr = list.toArray(list.toArray(new Integer[0]));
            for (var i = 0; i < arr.length; i++) {
                if (arr[i].equals(number)) {
                    arr[i] = Integer.MAX_VALUE;
                    break;
                }
            }
            for (var i = 0; i < arr.length; i++) {
                if (arr[i].equals(number1)) {
                    arr[i] = Integer.MAX_VALUE;
                    break;
                }
            }
            for (var i = 0; i < arr.length; i++) {
                if (arr[i].equals(number2)) {
                    arr[i] = Integer.MAX_VALUE;
                    break;
                }
            }
            for (var i = 0; i < arr.length; i++) {
                if (arr[i].equals(number3)) {
                    arr[i] = Integer.MAX_VALUE;
                    break;
                }
            }
            finRes = Stream.of(arr).allMatch(integer -> integer == Integer.MAX_VALUE) ? ++finRes : finRes;
        }
        return finRes > 0;
    }

    private static boolean notEqual(int i, int j, int k, int l) {
        var check = new HashSet<Integer>();
        check.add(i);
        check.add(j);
        check.add(k);
        check.add(l);
        return check.size() == 4;
    }


}