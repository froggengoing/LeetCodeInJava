package com.fly.leetcode;

/**
 * [416]分割等和子集	52.4%	Medium	0.0%
 * https://leetcode.cn/problems/partition-equal-subset-sum/
 * <p>
 * Runtime 43 ms Beats 51.36% of users
 * with Java Memory 47.08 MB Beats 44.04% of users with Java
 *
 * @author fly
 * @create 2024-04-23-17:05
 **/
public class LC00416_0022_ArrayPartition_01 {
    public static void main(String[] args) {
        System.out.println(new LC00416_0022_ArrayPartition_01().canPartition(new int[]{1, 5, 5, 11}));
        System.out.println(new LC00416_0022_ArrayPartition_01().canPartition(new int[]{1, 1, 5, 5, 11}));
        System.out.println(new LC00416_0022_ArrayPartition_01().canPartition(new int[]{1, 5}));
        System.out.println(new LC00416_0022_ArrayPartition_01().canPartition(new int[]{1}));
        System.out.println(new LC00416_0022_ArrayPartition_01().canPartition(new int[]{5}));
        System.out.println(new LC00416_0022_ArrayPartition_01().canPartition(new int[]{5, 6, 7, 8}));

        System.out.println(new LC00416_0022_ArrayPartition_01().canPartition(new int[]{3, 3, 3, 4, 5}));
    }

    /**
     * 01背包问题
     * 将数组元素尝试放入 sum()/2的背包中
     *
     * @param nums
     * @return
     */

    public boolean canPartition(int[] nums) {
        if (nums.length < 2) return false;
        if (nums.length <= 2) return nums[0] == nums[1];

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        //总和奇数直接返回false
        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        // i 表示第几个元素，j表示在j容量下，
        //dp[i][j]表示在[0-i]中是否可以找到元素之和为j
        //情况1：不放nums[i]时，dp[i-1][j]
        //情况2：要放nums[i]时，dp[i-1][j-nums[i]]
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][target];
    }
}
