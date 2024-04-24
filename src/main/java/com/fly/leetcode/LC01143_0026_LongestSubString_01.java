package com.fly.leetcode;

/**
 * 1143. 最长公共子序列
 * https://leetcode.cn/problems/longest-common-subsequence/description/
 *
 * Runtime 22 ms Beats 47.26% of users
 * with Java Memory 50.69 MB Beats 62.48% of users with Java
 * @author fly
 * @create 2024-04-24-22:23
 **/
public class LC01143_0026_LongestSubString_01 {
    public static void main(String[] args) {
        //    示例 1：
        //
        //输入：text1 = "abcde", text2 = "ace"
        //输出：3
        //解释：最长公共子序列是 "ace" ，它的长度为 3 。
        System.out.println(new LC01143_0026_LongestSubString_01().longestCommonSubsequence("abcde", "ace"));
        System.out.println(new LC01143_0026_LongestSubString_01().longestCommonSubsequence("abc", "abc"));
        System.out.println(new LC01143_0026_LongestSubString_01().longestCommonSubsequence("adbc", "abc"));
        System.out.println(new LC01143_0026_LongestSubString_01().longestCommonSubsequence("a", "b"));
        System.out.println(new LC01143_0026_LongestSubString_01().longestCommonSubsequence("a", "a"));
    }

    /**
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {


        int l1 = text1.length();
        int l2 = text2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        int len = 0;
        //dp[i][j]表示[0-i][0-j]内最长子串数量
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
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
