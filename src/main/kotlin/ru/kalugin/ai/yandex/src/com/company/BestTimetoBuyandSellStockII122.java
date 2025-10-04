package ru.kalugin.ai.yandex.src.com.company;

public class BestTimetoBuyandSellStockII122 {
    public static void main(String[] args) {
        System.out.println(maxProfitF(new int[]{7, 1, 5, 101, 102, 1}));
    }

    static int maxProfitF(int[] prices) {
        int maximumProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                var current = prices[i];
                var previous = prices[i - 1];
                maximumProfit += current - previous;
            }
        }
        return maximumProfit;
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int ans = 0;
        int start = prices[0];
        int end = prices[0];

        for (int price : prices) {
            if (price > end) {
                //still in the old session
                //update old end
                end = price;
            } else {
                //sell
                ans += (end - start);
                //restart a session
                start = price;
                end = price;
            }
        }

        if (end > start) ans += (end - start);

        return ans;
    }
}
