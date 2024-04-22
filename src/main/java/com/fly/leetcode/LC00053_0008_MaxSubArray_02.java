package com.fly.leetcode;

/**
 * [53]最大子数组和	55.3%	Medium	0.0%
 * https://leetcode.cn/problems/maximum-subarray/description/
 * <p>
 * 贪心算法
 * Runtime 1 ms Beats 99.39% of users
 * with Java Memory 56.72 MB Beats 76.33% of users with Java
 *
 * @author fly
 * @create 2024-04-22-23:29
 **/
public class LC00053_0008_MaxSubArray_02 {

    public static void main(String[] args) {
        System.out.println(new LC00053_0008_MaxSubArray_02().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new LC00053_0008_MaxSubArray_02().maxSubArray(new int[]{1}));
        System.out.println(new LC00053_0008_MaxSubArray_02().maxSubArray(new int[]{-1}));
        System.out.println(new LC00053_0008_MaxSubArray_02().maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    /**
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length < 1) return 0;
        // [bug]，默认值为0，则和为负数时会错误修改为0
        int maxSum = Integer.MIN_VALUE;
        int sumTmp = 0;
        for (int i = 0; i < nums.length; i++) {
            sumTmp += nums[i];
            maxSum = Math.max(maxSum, sumTmp);
            //这里意味着吧前面的丢弃，
            if (sumTmp < 0) sumTmp = 0;
        }
        return maxSum;
    }
}
