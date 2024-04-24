package com.fly.leetcode;

/**
 *
 * 718. 最长重复子数组
 * https://leetcode.cn/problems/maximum-length-of-repeated-subarray/description/
 *
 *
 * Runtime 27 ms Beats 42.02% of users
 * with Java Memory 54.96 MB Beats 26.99% of users with Java
 * @author fly
 * @create 2024-04-24-23:14
 **/
public class LC00718_0029_FindLength_01 {
    /**
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
     * 输出：3
     * 解释：长度最长的公共子数组是 [3,2,1] 。
     * 示例 2：
     * <p>
     * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
     * 输出：5
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(new LC00718_0029_FindLength_01().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(new LC00718_0029_FindLength_01().findLength(new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}));
    }

    public int findLength(int[] nums1, int[] nums2) {

        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        int len = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                len = Math.max(len, dp[i][j]);
            }
        }
        return len;
    }
}
