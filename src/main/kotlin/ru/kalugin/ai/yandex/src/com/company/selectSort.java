package ru.kalugin.ai.yandex.src.com.company;

import java.util.Arrays;

public class selectSort {
    public static void main(String[] args) {
        int[] array = {10, 2, 10, 3, 1, 2, 5};
        System.out.println(Arrays.toString(array));
        for (int left = 0; left < array.length; left++) {
            int minInd = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minInd]) {
                    minInd = i;
                }
            }
            swap(array, left, minInd);
        }
        System.out.println(Arrays.toString(array));
    }

    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

//    public static void main8(String[] args) {
//        int[] array = {10, 2, 10, 3, 1, 2, 5};
//       sort(array);
//        System.out.println(Arrays.toString(array));
//    }
//
//    static int[] sort(int arr[]) {
//        for (int i = 1; i < arr.length; ++i) {
//            int key = arr[i];
//            int j = i - 1;
//
//            /* Move elements of arr[0..i-1], that are
//               greater than key, to one position ahead
//               of their current position */
//            while (j >= 0 && arr[j] > key) {
//                arr[j + 1] = arr[j];
//                j = j - 1;
//            }
//            arr[j + 1] = key;
//        }
//        return arr;
//    }

}
