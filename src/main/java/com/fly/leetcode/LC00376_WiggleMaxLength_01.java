package com.fly.leetcode;

/**
 * 错误解法，原题目要求是子序列最长，也就是可以删除元素，组合最长的子序列
 * @author fly
 * @create 2024-04-21-23:29
 **/
public class LC00376_WiggleMaxLength_01 {

    public static void main(String[] args) {
        System.out.println(new LC00376_WiggleMaxLength_01().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
        System.out.println(new LC00376_WiggleMaxLength_01().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
    }

    public int wiggleMaxLength(int[] s) {
        if (s.length == 1) return 0;
        if (s.length == 2) return s[1] == s[0] ? 0 : 2;
        int[] dp = new int[s.length];
        dp[0] = 1;
        dp[1] = s[1] == s[0] ? 0 : 2;
        int maxLen = 0;
        for (int n = 2; n < s.length; n++) {
            boolean isNegative = (s[n] - s[n - 1]) * (s[n - 1] - s[n - 2]) < 0;
            boolean isequal = s[n] == s[n - 1];
            dp[n] = isNegative ? dp[n - 1] + 1 : isequal ? 0 : 2;
            maxLen = Math.max(maxLen, dp[n]);
        }
        return maxLen;
    }
}
