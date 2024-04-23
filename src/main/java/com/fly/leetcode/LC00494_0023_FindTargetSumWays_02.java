package com.fly.leetcode;

/**
 * [494]目标和	48.3%	Medium	0.0%
 * https://leetcode.com/problems/target-sum
 * <p>
 *
 * @author fly
 * @create 2024-04-23-21:18
 **/
public class LC00494_0023_FindTargetSumWays_02 {
    public static void main(String[] args) {
        //System.out.println(new LC00494_FindTargetSumWays_02().findTargetSumWays(new int[]{1, 0, 1, 1, 1, 1}, 3));
        //System.out.println(new LC00494_FindTargetSumWays_02().findTargetSumWays(new int[]{0, 1, 1, 1, 1, 1}, 3));
        //System.out.println(new LC00494_FindTargetSumWays_02().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        //System.out.println(new LC00494_FindTargetSumWays_02().findTargetSumWays(new int[]{1, 5, 1, 1, 1}, 5));
        //System.out.println(new LC00494_FindTargetSumWays_02().findTargetSumWays(new int[]{1000}, -1000));
        //System.out.println(new LC00494_FindTargetSumWays_02().findTargetSumWays(new int[]{1000}, 1000));
        System.out.println(new LC00494_0023_FindTargetSumWays_02().findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1));
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
        // 注意这里的数组长度，相比解法1，优化了初始化的问题
        int[][] dp = new int[nums.length + 1][realTarget + 1];
        dp[0][0] = 1;


        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= realTarget; j++) {
                if (j >= nums[i - 1]) {
                    //如果nums[i-1]==0 相当于 在上一个的基础上*2
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][realTarget];
    }
}
