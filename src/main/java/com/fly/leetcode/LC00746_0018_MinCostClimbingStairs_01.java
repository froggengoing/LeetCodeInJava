package com.fly.leetcode;

/**
 * [746]使用最小花费爬楼梯	66.5%	Easy	0.0%
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 *
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 *
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *
 * 请你计算并返回达到楼梯顶部的最低花费。
 * 动态规划
 * @author fly
 * @create 2024-04-21-9:25
 **/
public class LC00746_0018_MinCostClimbingStairs_01 {

    /**
     * dp[n] = min(dp[n-1]+s[n-1],dp[n-2]+s[n-2])
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int minCost = 0;
        int n = cost.length;

        int[] minCostArr = new int[cost.length + 1];
        if (cost.length <= 1) return 0;
        if (cost.length == 2) return Math.min(cost[0], cost[1]);
        //一级阶梯
        minCostArr[0] = 0;
        //二级阶梯
        minCostArr[1] = 0;
        for (int i = 2; i < minCostArr.length; i++) {
            int cost_i_2 = minCostArr[i - 2] + cost[i - 2];
            int cost_i_1 = minCostArr[i - 1] + cost[i - 1];
            minCostArr[i] = Math.min(cost_i_2, cost_i_1);
        }
        return minCostArr[n];
    }
}
