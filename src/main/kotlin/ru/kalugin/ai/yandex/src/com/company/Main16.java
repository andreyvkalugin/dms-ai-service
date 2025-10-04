package ru.kalugin.ai.yandex.src.com.company;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Main16 {
    static List<List<Integer>> resO = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // System.out.println(Arrays.toString(twoSum(new int[]{1,0,-1,0,-2,2}, 0)));
        System.out.println(f(new int[]{-4, -3, -2, -1, 0, 0, 1, 2, 3, 4}, 0));
    }

    public static List<List<Integer>> f(int[] nums, int target) {

        resO.clear();
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                var listind = twoSum(nums,(target-nums[i]-nums[j]));
//                for (var ind: listind){
//                    if (notEqual(i, j, ind[0], ind[1]) && !checkArray(nums[i], nums[ind[0]], nums[j], nums[ind[1]])) {
//                        List<Integer> res = new ArrayList<>();
//                        res.add(nums[i]);
//                        res.add(nums[ind[0]]);
//                        res.add(nums[j]);
//                        res.add(nums[ind[1]]);
//                        resO.add(res);
//                    }
//                }
//            }
//        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            var listind = threeSum(nums, (target - nums[i]));
            for (var ind : listind) {
                if (notEqual(i, ind[2], ind[0], ind[1]) && !checkArray(nums[i], nums[ind[0]], nums[ind[2]], nums[ind[1]])) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[ind[0]]);
                    res.add(nums[ind[2]]);
                    res.add(nums[ind[1]]);
                    resO.add(res);
                }
            }

        }

        return resO;
    }

    public static List<Integer[]> threeSum(int[] numbers, int target) {

        int i = 0, j = numbers.length - 1;
        int g = 1;


        var resi = new ArrayList<Integer[]>();
        HashMap<Integer, List<Integer>> indexes = new HashMap<>();

        for (int k = 0; k < numbers.length; k++) {
            if (!indexes.containsKey(numbers[k])) {
                indexes.put(numbers[k], new ArrayList<>());
            }
            indexes.get(numbers[k]).add(k);
        }

        //Arrays.sort(numbers);
        while (i < j) {
            if (numbers[i] + numbers[j] + numbers[g] > target) {
//                g++;
//                if(g >= j){
//                    if (numbers[i]<0){
//                      i++; g=i+1;
//                      continue;
//                    }
//                    j--; g=i+1;
//                }
                j--;
            } else if (numbers[i] + numbers[j] + numbers[g] < target) {
                g++;
                if (g >= j) {
                    i++;
                    g = i + 1;
                }
            } else {
                var listI1 = indexes.get(numbers[i]);
                var listI2 = indexes.get(numbers[j]);
                var listI3 = indexes.get(numbers[g]);
                for (var i1 : listI1) {
                    for (var i2 : listI2) {
                        for (var i3 : listI3) {
                            Integer[] x = new Integer[3];
                            x[0] = i1;
                            x[1] = i2;
                            x[2] = i3;
                            resi.add(x);
                        }
                    }
                }
                if (target < 0) {
                    j--;
                } else {
                    i++;
                }
                g = i + 1;
            }
        }

        return resi;
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

    private static boolean notEqual(int i, Integer j, Integer k, Integer l) {
        var check = new HashSet<Integer>();
        check.add(i);
        check.add(j);
        check.add(k);
        check.add(l);
        return check.size() == 4;
    }


}