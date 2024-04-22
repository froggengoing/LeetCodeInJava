package com.fly.leetcode;

/**
 * 动态规划，没有02示例好，因为02示例会有break情况
 * 算法时间复杂度 o(n^2)
 *
 * @author fly
 * @create 2024-04-20-14:14
 **/
public class LC00005_0004_LongestPalindrome_03 {
    public static void main(String[] args) {
        System.out.println(new LC00005_0004_LongestPalindrome_03().longestPalindrome("abcbca"));
        System.out.println(new LC00005_0004_LongestPalindrome_03().longestPalindrome("abccbca"));
        System.out.println(new LC00005_0004_LongestPalindrome_03().longestPalindrome("babc"));
        System.out.println(new LC00005_0004_LongestPalindrome_03().longestPalindrome("a"));
    }

    /**
     * dp[i][j] 表示i..j的字符串，值为true，则为回文
     * s[i-1] = s[j+1] && dp[i][j] = true，则dp[i-1][j+1]为true
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String maxStr = "";
        if (s == null || s.length() == 0) return maxStr;


        boolean[][] dp = new boolean[s.length()][s.length()];

//       i=j dp[i][j] = true
        for (int i = 0; i < s.length(); i++) dp[i][i] = true;

//     * dp[i][j] 表示i..j的字符串，值为true，则为回文
//     * s[i] = s[j] && dp[i+1][j-1] = true，则dp[i][j]为true
        int maxLeft = 0;
        int maxRight = 0;
        int maxLength = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i > 2) {
                        if (dp[i + 1][j - 1]) dp[i][j] = true;
                    } else {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] && (j - i) > maxLength) {
                    maxLeft = j;
                    maxRight = i;
                    maxLength = j - i;
                }

            }
        }
        return s.substring(maxRight, maxLeft + 1);
    }


}
