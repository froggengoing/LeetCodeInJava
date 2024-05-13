package com.fly.leetcode;

/**
 * Runtime 18 ms Beats 45.30% of users
 * with Java Memory 44.18 MB Beats 68.81% of users with Java
 *
 * @author fly
 * @create 2024-05-13-14:31
 **/
public class LC00322_0039_CoinChange_03 {
    /**
     * 322. 零钱兑换
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * <p>
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     */


    public static void main(String[] args) {
        System.out.println(new LC00322_0039_CoinChange_03().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new LC00322_0039_CoinChange_03().coinChange(new int[]{2}, 3));
        System.out.println(new LC00322_0039_CoinChange_03().coinChange(new int[]{1}, 0));
        System.out.println(new LC00322_0039_CoinChange_03().coinChange(new int[]{1}, 0));
        System.out.println(new LC00322_0039_CoinChange_03().coinChange(new int[]{1, 2}, 2));
    }

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    dp[i] = dp[i] == -1 ? dp[i - coins[j]] + 1 : Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount];
    }


}
