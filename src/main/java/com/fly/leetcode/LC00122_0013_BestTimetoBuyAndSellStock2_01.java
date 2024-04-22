package com.fly.leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 *
 * @author fly
 * @create 2024-04-21-10:18
 **/
public class LC00122_0013_BestTimetoBuyAndSellStock2_01 {
    public static void main(String[] args) {
        //System.out.println(new LC00121_BestTimetoBuyAndSellStock_01().maxProfit(new int[]{7, 6, 4, 3, 1}));
        //System.out.println(new LC00121_BestTimetoBuyAndSellStock_01().maxProfit(new int[]{7,1,5,3,6,3,4,6,7}));
        System.out.println(new LC00122_0013_BestTimetoBuyAndSellStock2_01().maxProfit(new int[]{1, 9, 6, 9, 1, 7, 1, 1, 5, 9, 9, 9}));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int lastLowPrice = -1;
        int lastMaxPrice = -1;
        for (int i = 0; i < prices.length; i++) {
            if (lastLowPrice == -1) {
                //开始入场
                lastLowPrice = prices[i];
            } else {
                //没有确认入场
                if (lastMaxPrice == -1) {
                    if (prices[i] <= lastLowPrice) {
                        //更新入场价格
                        lastLowPrice = prices[i];
                    } else {
                        //确认入场
                        lastMaxPrice = prices[i];
                        //    最后一个直接出场
                        if (i == prices.length - 1) {
                            maxProfit += lastMaxPrice - lastLowPrice;
                        }
                    }

                } else {
                    //    更新最高价格
                    if (prices[i] >= lastMaxPrice) {
                        lastMaxPrice = prices[i];
                        //    最后一个直接出场
                        if (i == prices.length - 1) {
                            maxProfit += lastMaxPrice - lastLowPrice;
                        }
                    } else if (prices[i] < lastMaxPrice) {
                        //    确认出场
                        maxProfit += lastMaxPrice - lastLowPrice;
                        //重新初始化
                        lastLowPrice = prices[i];
                        lastMaxPrice = -1;
                    }

                }
            }

        }

        return maxProfit;
    }
}
