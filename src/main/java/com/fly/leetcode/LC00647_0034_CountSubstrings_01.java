package com.fly.leetcode;

/**
 * 647. 回文子串
 * https://leetcode.cn/problems/palindromic-substrings/description/
 *
 * Runtime 32 ms Beats 23.18% of users
 * with Java Memory 55.16 MB Beats 5.14% of users with Java
 * @author fly
 * @create 2024-04-25-12:24
 **/
public class LC00647_0034_CountSubstrings_01 {

    public static void main(String[] args) {
        //System.out.println(new LC00647_0034_CountSubstrings_01().countSubstrings("aba"));
        System.out.println(new LC00647_0034_CountSubstrings_01().countSubstrings("abba"));
        System.out.println(new LC00647_0034_CountSubstrings_01().countSubstrings("fdsklf"));
    }

    public int countSubstrings(String s) {

        int[][] dp = new int[s.length() + 1][s.length() + 1];
        // dp[i][j]是否是回文串
        boolean[][] dp2 = new boolean[s.length() + 1][s.length() + 1];
        int max = 0;
        for (int i = s.length(); i >= 1; i--) {

            for (int j = i; j <= s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    dp2[i][j] = true;
                } else {
                    boolean isEqual = s.charAt(i - 1) == s.charAt(j - 1);
                    if (j - i == 1) {
                        dp2[i][j] = isEqual;
                    } else if (isEqual) {
                        dp2[i][j] = dp2[i + 1][j - 1];
                    }
                    // bug：这里不能只判断 char(i)==char(j)而要考虑[i..j]是否是回文
                    int tmp = dp2[i][j] ? 1 : 0;
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + tmp;
                }

                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }


}
