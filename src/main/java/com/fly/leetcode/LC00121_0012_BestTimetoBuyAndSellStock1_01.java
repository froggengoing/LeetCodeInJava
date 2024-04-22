package com.fly.leetcode;

/**
 * [121]买卖股票的最佳时机	57.7%	Easy	0.0%
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 *
 * @author fly
 * @create 2024-04-21-10:18
 **/
public class LC00121_0012_BestTimetoBuyAndSellStock1_01 {
    public static void main(String[] args) {
        System.out.println(new LC00121_0012_BestTimetoBuyAndSellStock1_01().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new LC00121_0012_BestTimetoBuyAndSellStock1_01().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new LC00121_0012_BestTimetoBuyAndSellStock1_01().maxProfit(new int[]{7,1,5,3,6,3,4,6,7}));
        System.out.println(new LC00121_0012_BestTimetoBuyAndSellStock1_01().maxProfit(new int[]{1, 9, 6, 9, 1, 7, 1, 1, 5, 9, 9, 9}));
    }

    //找出当前向右找到的最大值
    //则dp[n] = max(dp[n+1],s[n+1]
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length == 1) {
            return 0;
        }
        int[] maxPriceArr = new int[prices.length];
        maxPriceArr[prices.length - 1] = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            maxPriceArr[i] = Math.max(maxPriceArr[i + 1], prices[i + 1]);
            maxProfit = Math.max(maxPriceArr[i] - prices[i], maxProfit);
        }
        return maxProfit;
    }
}
