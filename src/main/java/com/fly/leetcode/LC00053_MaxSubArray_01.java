package com.fly.leetcode;

/**
 * [53]最大子数组和	55.3%	Medium	0.0%
 * https://leetcode.cn/problems/maximum-subarray/description/
 *
 * Runtime 1 ms Beats 99.39% of users
 * with Java Memory 57.54 MB Beats 5.34% of users with Java
 *
 * @author fly
 * @create 2024-04-22-23:29
 **/
public class LC00053_MaxSubArray_01 {

    public static void main(String[] args) {
        System.out.println(new LC00053_MaxSubArray_01().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new LC00053_MaxSubArray_01().maxSubArray(new int[]{1}));
        System.out.println(new LC00053_MaxSubArray_01().maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    /**
     * [-2,1,-3,4,-1,2,1,-5,4]
     * dp[i]表示当前项的最大连续字串和
     * dp[i] = dp[i - 1] > 0?dp[i - 1] + nums[i] :nums[i]
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length < 1) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
