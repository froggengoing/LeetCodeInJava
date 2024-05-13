package com.fly.leetcode;

/**
 * @author fly
 * @create 2024-05-13-14:31
 **/
public class LC00322_0039_CoinChange_01 {
    /**
     * 322. 零钱兑换
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * <p>
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     */
    int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(new LC00322_0039_CoinChange_01().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new LC00322_0039_CoinChange_01().coinChange(new int[]{2}, 3));
        System.out.println(new LC00322_0039_CoinChange_01().coinChange(new int[]{1}, 0));
    }

    public int coinChange(int[] coins, int amount) {

        int count = 0;
        findWay(coins, amount, count);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    private void findWay(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(res, count);
        }
        for (int i = 0; i < coins.length; i++) {
            findWay(coins, amount - coins[i], count + 1);
        }
    }
}
