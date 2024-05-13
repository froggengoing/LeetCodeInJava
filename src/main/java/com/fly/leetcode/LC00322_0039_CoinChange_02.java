package com.fly.leetcode;

/**
 * Runtime 31 ms Beats 23.49% of users
 * with Java Memory 44.34 MB Beats 54.35% of users with Java
 *
 * @author fly
 * @create 2024-05-13-14:31
 **/
public class LC00322_0039_CoinChange_02 {
    /**
     * 322. 零钱兑换
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * <p>
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     */

    int[] dp;

    public static void main(String[] args) {
        System.out.println(new LC00322_0039_CoinChange_02().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new LC00322_0039_CoinChange_02().coinChange(new int[]{2}, 3));
        System.out.println(new LC00322_0039_CoinChange_02().coinChange(new int[]{1}, 0));
        System.out.println(new LC00322_0039_CoinChange_02().coinChange(new int[]{1}, 0));
        System.out.println(new LC00322_0039_CoinChange_02().coinChange(new int[]{1,2}, 2));
    }

    public int coinChange(int[] coins, int amount) {

        dp = new int[amount + 1];
        findWay(coins, amount);

        return dp[amount];
    }

    private int findWay(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int temp = findWay(coins, amount - coins[i]);
            if (temp != -1 && temp < min) {
                min = temp + 1;
            }
        }
        dp[amount]= min == Integer.MAX_VALUE ? -1 : min;
        return dp[amount];
    }
}
