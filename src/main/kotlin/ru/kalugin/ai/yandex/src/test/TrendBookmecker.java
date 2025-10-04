package ru.kalugin.ai.yandex.src.test;

public class TrendBookmecker {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        var t = new TrendBookmecker().maxProfit(prices);
        System.out.println(t);
    }

    public int maxProfit(int[] prices) {
        var max = 0;
        for (var i = 0; i < prices.length; i++) {
            for (var j = i + 1; j < prices.length; j++) {
                max = Math.max(prices[j] - prices[i], max);
            }
        }

        return max;
    }
}
