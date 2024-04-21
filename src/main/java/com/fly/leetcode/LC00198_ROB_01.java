package com.fly.leetcode;

/**
 * [198]打家劫舍	55.0%	Medium	0.0%
 * https://leetcode.cn/problems/house-robber/description/
 *
 * @author fly
 * @create 2024-04-21-13:55
 **/
public class LC00198_ROB_01 {

    public static void main(String[] args) {
        System.out.println(new LC00198_ROB_01().rob(new int[]{1}));
        System.out.println(new LC00198_ROB_01().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new LC00198_ROB_01().rob(new int[]{1, 4, 4, 3, 2, 1}));
    }
    /**
     * dp[n] = max(dp[n-2]+s[n],dp[n-1])
     */
    public int rob(int[] nums) {
        int maxRob = 0;
        if (nums.length < 1) return maxRob;
        int[] dp = new int[nums.length];

        if (nums.length == 1) return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
