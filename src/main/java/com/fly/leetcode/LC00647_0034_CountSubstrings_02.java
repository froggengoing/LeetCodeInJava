package com.fly.leetcode;

/**
 * 647. 回文子串
 * https://leetcode.cn/problems/palindromic-substrings/description/
 * <p>
 * Runtime 32 ms Beats 23.18% of users
 * with Java Memory 55.16 MB Beats 5.14% of users with Java
 *
 * @author fly
 * @create 2024-04-25-12:24
 **/
public class LC00647_0034_CountSubstrings_02 {

    public static void main(String[] args) {
        System.out.println(new LC00647_0034_CountSubstrings_02().countSubstrings("aba"));
        System.out.println(new LC00647_0034_CountSubstrings_02().countSubstrings("abba"));
        System.out.println(new LC00647_0034_CountSubstrings_02().countSubstrings("fdsklf"));
    }

    public int countSubstrings(String s) {

        // dp[i][j]是否是回文串
        boolean[][] dp2 = new boolean[s.length() + 1][s.length() + 1];
        int count = 0;
        for (int i = s.length(); i >= 1; i--) {

            for (int j = i; j <= s.length(); j++) {
                if (i == j) {
                    dp2[i][j] = true;
                } else {
                    boolean isEqual = s.charAt(i - 1) == s.charAt(j - 1);
                    if (j - i == 1) {
                        dp2[i][j] = isEqual;
                    } else if (isEqual) {
                        dp2[i][j] = dp2[i + 1][j - 1];
                    }
                }
                if (dp2[i][j]) count++;
            }
        }
        return count;
    }


}
