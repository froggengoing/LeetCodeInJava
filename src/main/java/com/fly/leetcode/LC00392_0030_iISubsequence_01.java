package com.fly.leetcode;

/**
 * 392. 判断子序列
 * https://leetcode.cn/problems/is-subsequence/description/
 *
 * Runtime 7 ms Beats 5.70% of users
 * with Java Memory 42.12 MB Beats 5.00% of users with Java
 *
 * @author fly
 * @create 2024-04-24-23:31
 **/
public class LC00392_0030_iISubsequence_01 {
    public static void main(String[] args) {

        //System.out.println(new LC00392_0030_iISubsequence_01().isSubsequence("abc", "dcabc"));
        System.out.println(new LC00392_0030_iISubsequence_01().isSubsequence("abc", "ahbgdc"));
        //System.out.println(new LC00392_0030_iISubsequence_01().isSubsequence("cd", "dcabc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() < 1) return true;
        if (t.length() < 1) return false;
        int l1 = s.length() + 1;
        int l2 = t.length() + 1;
        boolean[][] dp = new boolean[l1][l2];
        // bug初始化
        for (int j = 0; j <= t.length(); j++) dp[0][j] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (t.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
                if (i == s.length() && dp[s.length()][j]) {
                    return true;
                }
            }

        }
        return false;
    }
}
