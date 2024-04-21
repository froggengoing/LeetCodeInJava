package com.fly.leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 *
 * @author fly
 * @create 2024-04-21-10:18
 **/
public class LC00122_BestTimetoBuyAndSellStock2_02 {
    public static void main(String[] args) {
        System.out.println(new LC00122_BestTimetoBuyAndSellStock2_02().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new LC00122_BestTimetoBuyAndSellStock2_02().maxProfit(new int[]{7, 1, 5, 3, 6, 3, 4, 6, 7}));
        System.out.println(new LC00122_BestTimetoBuyAndSellStock2_02().maxProfit(new int[]{1, 9, 6, 9, 1, 7, 1, 1, 5, 9, 9, 9}));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length <= 1) {
            return 0;
        }
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
