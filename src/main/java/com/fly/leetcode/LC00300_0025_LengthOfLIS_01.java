package com.fly.leetcode;

/**
 * 300. 最长递增子序列
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/
 *
 * Runtime 41 ms Beats 60.60% of users
 * with Java Memory 44.13 MB Beats 48.68% of users with Java
 * @author fly
 * @create 2024-04-24-10:34
 **/
public class LC00300_0025_LengthOfLIS_01 {

    public static void main(String[] args) {
        System.out.println(new LC00300_0025_LengthOfLIS_01().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(new LC00300_0025_LengthOfLIS_01().lengthOfLIS(new int[]{7, 7, 7, 7}));
        System.out.println(new LC00300_0025_LengthOfLIS_01().lengthOfLIS(new int[]{7}));
        System.out.println(new LC00300_0025_LengthOfLIS_01().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(new LC00300_0025_LengthOfLIS_01().lengthOfLIS(new int[]{1, 2, 3, 4, 5, 1}));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // bug，这里要判断最大值
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }
}
