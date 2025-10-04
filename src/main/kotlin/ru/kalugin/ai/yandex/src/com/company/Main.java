package ru.kalugin.ai.yandex.src.com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        var n = new NumberStream();

        int[] str = {1, 1, 1, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3};
        for (var a : str) {
            n.put(a);
        }
        n.show();
    }

    private static class NumberStream {
        private int[] arr = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        public void put(Integer in) {
            var len = arr.length - 1;
            Arrays.sort(arr);
            for (var i = arr.length - 1; i >= 0; i--) {
                if (notSkip(in)) {
                    if (arr[i] < in) {
                        freespace(i);
                        arr[i] = in;
                    }
                }
            }
        }

        private void freespace(int finish) {
            for (var i = 0; i < finish; i++) {
                arr[i] = arr[i + 1];
            }

            "sd".toLowerCase(Locale.ROOT);
        }

        private boolean notSkip(Integer in) {
            return Arrays.stream(arr).filter(el -> el == in).count() == 0;
        }

        public void show() {
            for (var a : arr) {
                System.out.println(a);
            }
        }
    }


}
