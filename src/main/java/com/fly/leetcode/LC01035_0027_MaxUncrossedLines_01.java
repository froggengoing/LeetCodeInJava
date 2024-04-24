package com.fly.leetcode;

/**
 * 1035. 不相交的线
 * https://leetcode.cn/problems/uncrossed-lines/description/
 * 和1049题目一摸一样
 *
 * Runtime 7 ms Beats 27.25% of users
 * with Java Memory 43.67 MB Beats 82.65% of users with Java
 * @author fly
 * @create 2024-04-24-21:16
 **/
public class LC01035_0027_MaxUncrossedLines_01 {

    public static void main(String[] args) {

        System.out.println(new LC01035_0027_MaxUncrossedLines_01().maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        System.out.println(new LC01035_0027_MaxUncrossedLines_01().maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 4, 4}));
        System.out.println(new LC01035_0027_MaxUncrossedLines_01().maxUncrossedLines(new int[]{2, 2, 2}, new int[]{2, 4, 2}));
        System.out.println(new LC01035_0027_MaxUncrossedLines_01().maxUncrossedLines(new int[]{2, 2, 2}, new int[]{2, 2, 2}));
        System.out.println(new LC01035_0027_MaxUncrossedLines_01().maxUncrossedLines(new int[]{2}, new int[]{2}));
    }

        public int maxUncrossedLines ( int[] nums1, int[] nums2){

            int l1 = nums1.length + 1;
            int l2 = nums2.length + 1;
            int[][] dp = new int[l1][l2];

            int len = 0;
            //bug 这里是<=
            for (int i = 1; i <= nums1.length; i++) {
                for (int j = 1; j <= nums2.length; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                    len = Math.max(len, dp[i][j]);
                }
            }
            return len;
        }
    }
