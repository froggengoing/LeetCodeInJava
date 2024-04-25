package com.fly.leetcode;

/**
 * 72. 编辑距离
 * https://leetcode.cn/problems/edit-distance/description/
 *
 * Runtime 6 ms Beats 17.73% of users with Java Memory 44.91 MB Beats 40.00% of users with Java
 * @author fly
 * @create 2024-04-25-11:04
 **/
public class LC00072_0033_MinDistance_01 {
    public static void main(String[] args) {

        //System.out.println(new LC00072_0033_MinDistance_01().minDistance("", ""));
        System.out.println(new LC00072_0033_MinDistance_01().minDistance("horse", "ros"));
        System.out.println(new LC00072_0033_MinDistance_01().minDistance("horse", "ore"));
        System.out.println(new LC00072_0033_MinDistance_01().minDistance("horse", "r"));
        System.out.println(new LC00072_0033_MinDistance_01().minDistance("intention", "execution"));
    }

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= word2.length(); j++) dp[0][j] = j;

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 这里是最后，硬测试出来的，
                    // 理解这个dp的含义
                    // dp[i - 1][j] + 1 表示 "a" "ab" 第一个字符串加一个字符 "ad" => "ab"
                    // dp[i][j - 1] + 1 表示 "a" "ab" 第二个字符串加一个字符 "a" => "abc"
                    // dp[i][j] + 1 表示 "a" "ab" 同时加一个字符并且不相等"ad" => "abc"
                    // dp[i][j] 表示 "a" "ab" 同时加一个字符并且相等"ac" => "abc"

                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
