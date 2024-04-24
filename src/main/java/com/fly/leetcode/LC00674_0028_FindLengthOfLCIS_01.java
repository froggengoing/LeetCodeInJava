package com.fly.leetcode;

/**
 * 674. 最长连续递增序列
 * https://leetcode.cn/problems/longest-continuous-increasing-subsequence/description/
 *
 * Runtime 2 ms Beats 35.07% of users
 * with Java Memory 44.14 MB Beats 79.31% of users with Java
 * @author fly
 * @create 2024-04-24-22:54
 **/
public class LC00674_0028_FindLengthOfLCIS_01 {


    public static void main(String[] args) {
        System.out.println(new LC00674_0028_FindLengthOfLCIS_01().findLengthOfLCIS(new int[]{1, 3, 5, 4}));
        System.out.println(new LC00674_0028_FindLengthOfLCIS_01().findLengthOfLCIS(new int[]{1, 2, 1, 2, 3, 5, 4}));
    }

    public int findLengthOfLCIS(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            len = Math.max(dp[i], len);
        }
        return len;
    }
}
