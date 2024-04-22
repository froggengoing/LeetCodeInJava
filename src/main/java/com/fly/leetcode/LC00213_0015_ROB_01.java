package com.fly.leetcode;

/**
 * [213]打家劫舍 II	45.0%	Medium	0.0%
 * https://leetcode.cn/problems/house-robber-ii/
 *
 * @author fly
 * @create 2024-04-21-13:55
 **/
public class LC00213_0015_ROB_01 {

    public static void main(String[] args) {
        //System.out.println(new LC00213_ROB_01().rob(new int[]{1}));
        //System.out.println(new LC00213_ROB_01().rob(new int[]{1, 2, 3, 1}));
        //System.out.println(new LC00213_ROB_01().rob(new int[]{1, 4, 4, 3, 2, 1}));
        //System.out.println(new LC00213_ROB_01().rob(new int[]{1, 4, 4, 3, 2, 1, 7}));
        System.out.println(new LC00213_0015_ROB_01().rob(new int[]{2,1,1,2}));
    }

    /**
     * dp[n] = max(dp[n-2]+s[n],dp[n-1])
     */
    public int rob(int[] nums) {
        return 0;
    }
}
