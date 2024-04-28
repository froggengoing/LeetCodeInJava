package com.fly.leetcode;

/**
 * [416]分割等和子集	52.4%	Medium	0.0%
 * https://leetcode.cn/problems/partition-equal-subset-sum/
 * 背包问题
 *
 * <p>
 * Runtime 43 ms Beats 51.36% of users
 * with Java Memory 47.08 MB Beats 44.04% of users with Java
 *
 * @author fly
 * @create 2024-04-23-17:05
 **/
public class LC00416_0022_ArrayPartition_01_01 {
    public static void main(String[] args) {
        //System.out.println(new LC00416_0022_ArrayPartition_01().canPartition(new int[]{1, 5, 5, 11}));
        //System.out.println(new LC00416_0022_ArrayPartition_01().canPartition(new int[]{1, 1, 5, 5, 11}));
        //System.out.println(new LC00416_0022_ArrayPartition_01().canPartition(new int[]{1, 5}));
        //System.out.println(new LC00416_0022_ArrayPartition_01().canPartition(new int[]{1}));
        //System.out.println(new LC00416_0022_ArrayPartition_01().canPartition(new int[]{5}));
        //System.out.println(new LC00416_0022_ArrayPartition_01().canPartition(new int[]{5, 6, 7, 8}));
        //
        //System.out.println(new LC00416_0022_ArrayPartition_01().canPartition(new int[]{3, 3, 3, 4, 5}));
        System.out.println(new LC00416_0022_ArrayPartition_01_01().canPartition(new int[]{1, 2, 3, 6}));
    }

    /**
     * 01背包问题
     * 将数组元素尝试放入 sum()/2的背包中
     *
     * @param nums
     * @return
     */

    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) return false;
        if (nums.length <= 2) return nums[0] == nums[1];
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if (total % 2 != 0) {
            return false;
        }
        int target = total / 2;
        int[][] dp = new int[nums.length + 1][target + 1];

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - nums[i - 1]] + nums[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[nums.length][target] >= target;
    }
}
