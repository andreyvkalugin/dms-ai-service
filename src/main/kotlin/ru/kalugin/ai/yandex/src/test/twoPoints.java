package ru.kalugin.ai.yandex.src.test;

public class twoPoints {

    public static void main(String[] args) {
        int[] asd = {1, 1};

        int depth = getMaxLength(asd);
        System.out.println(depth);
    }

    private static int getMaxLength(int[] massive) {
        var max = -1;
        for (var i = 0; i < massive.length; i++) {
            for (var j = i; j < massive.length; j++) {
                max = Math.max(max, (j - i) * Math.min(massive[i], massive[j]));
            }
        }

        return max;
    }
}
