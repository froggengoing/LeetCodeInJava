package com.fly.leetcode;

/**
 * [494]目标和	48.3%	Medium	0.0%
 * https://leetcode.com/problems/target-sum
 * <p>
 * Runtime 9 ms Beats 67.54% of users
 * with Java Memory 43.09 MB Beats 49.24% of users with Java
 *
 * @author fly
 * @create 2024-04-23-21:18
 **/
public class LC00494_FindTargetSumWays_01 {
    public static void main(String[] args) {
        System.out.println(new LC00494_FindTargetSumWays_01().findTargetSumWays(new int[]{1, 0, 1, 1, 1,1}, 3));
        System.out.println(new LC00494_FindTargetSumWays_01().findTargetSumWays(new int[]{0, 1, 1, 1, 1, 1}, 3));
        System.out.println(new LC00494_FindTargetSumWays_01().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(new LC00494_FindTargetSumWays_01().findTargetSumWays(new int[]{1, 5, 1, 1, 1}, 5));
        System.out.println(new LC00494_FindTargetSumWays_01().findTargetSumWays(new int[]{1000}, -1000));
        System.out.println(new LC00494_FindTargetSumWays_01().findTargetSumWays(new int[]{1000}, 1000));
        System.out.println(new LC00494_FindTargetSumWays_01().findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1));
    }

    /**
     * 背包问题
     * sum(p) - sum(n) = target
     * sum(p) - sum(n) + sum(p) + sum(n) = target + sum(p) + sum(n)
     * 2 * sum(p) = target + sum(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        // bug: 负数要纠正为正数，因为是等价的
        target = Math.abs(target);
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        int realTarget = (target + sum) / 2;

        int[][] dp = new int[nums.length][realTarget + 1];

        // bug 第0行的初始化问题
        if (nums[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
            dp[0][nums[0]] = 1;
        }
        // bug 第0列初始化问题
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                dp[i][0] = 2 * dp[i - 1][0];
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= realTarget; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length - 1][realTarget];
    }
}
