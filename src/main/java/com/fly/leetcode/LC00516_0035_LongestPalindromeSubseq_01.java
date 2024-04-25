package com.fly.leetcode;

/**
 * [516]最长回文子序列	67.1%	Medium	0.0%
 * https://leetcode.cn/problems/longest-palindromic-subsequence/description/
 *
 * Runtime 48 ms Beats 51.29% of users
 * with Java Memory 55.24 MB Beats 28.38% of users with Java
 *
 * @author fly
 * @create 2024-04-25-14:45
 **/
public class LC00516_0035_LongestPalindromeSubseq_01 {
    public static void main(String[] args) {
        System.out.println(new LC00516_0035_LongestPalindromeSubseq_01().longestPalindromeSubseq("bbbab"));
        System.out.println(new LC00516_0035_LongestPalindromeSubseq_01().longestPalindromeSubseq("cbbd"));
        System.out.println(new LC00516_0035_LongestPalindromeSubseq_01().longestPalindromeSubseq("b"));
        System.out.println(new LC00516_0035_LongestPalindromeSubseq_01().longestPalindromeSubseq("bbbbb"));
    }

    // dp[i][j] = s[i]==s[j]? dp[i+1][[j-1])+2: max(dp[i][[j-1],dp[i+1][[j]),
    public int longestPalindromeSubseq(String s) {

        int[][] dp = new int[s.length() + 1][s.length() + 1];
        int len = 0;
        for (int i = s.length(); i > 0; i--) {
            for (int j = i; j <= s.length(); j++) {
                //默认值为1
                dp[i][j] = 1;
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    if (s.charAt(j - 1) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
                len = Math.max(len, dp[i][j]);
            }
        }
        return len;
    }
}
