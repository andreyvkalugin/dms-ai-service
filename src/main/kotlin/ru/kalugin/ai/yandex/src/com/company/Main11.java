package ru.kalugin.ai.yandex.src.com.company;

import java.io.IOException;

public class Main11 {
    public static void main(String[] args) throws IOException {
        System.out.println(binarySearcha(new int[][]{{4, 5, 6, 6, 7, 0, 1, 2, 4, 4}}, 1));
        // System.out.println(binarySearch(new int[]{-1,0,3,5,9,12},9));
    }

    static int md = 0;
    static int nd = 0;

    private static boolean binarySearcha(int[][] matrix, int target) {
        md = matrix.length;
        nd = matrix[0].length;

        var l = 0;
        var r = md * nd - 1;
        if (l == r) {
            if (getNums(l, matrix) == target) {
                return true;
            }
        }
        while ((l + 1) < r) {
            var m = Math.round((l + r) / 2);
            if (getNums(m, matrix) == target) return true;//m > 0;
            if (getNums(m, matrix) < target) {
                l = m;
            } else {
                r = m;
            }
        }
        if (getNums(r, matrix) == target) return true;//r > 0;
        if (getNums(l, matrix) == target) return true;//l > 0;
        return false;
    }

    private static int getNums(int index, int[][] matrix) {
        var row = (int) Math.floor(index / nd);
        var inRow = index % nd;
        return matrix[row][inRow];
    }

}