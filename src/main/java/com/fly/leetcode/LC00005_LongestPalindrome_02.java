package com.fly.leetcode;

/**
 * 中心扩展法
 * 算法时间复杂度 o(n^2)
 * @author fly
 * @create 2024-04-20-14:14
 **/
public class LC00005_LongestPalindrome_02 {
    public static void main(String[] args) {
        System.out.println(new LC00005_LongestPalindrome_02().longestPalindrome("abcbca"));
        System.out.println(new LC00005_LongestPalindrome_02().longestPalindrome("abccbca"));
        System.out.println(new LC00005_LongestPalindrome_02().longestPalindrome("babc"));
        System.out.println(new LC00005_LongestPalindrome_02().longestPalindrome("a"));
    }

    public String longestPalindrome(String s) {
        String palindromeStr = "";
        for (int i = 0; i < s.length(); i++) {
            int k1 = subPalindrome(s, i, i + 1);
            int k2 = subPalindrome(s, i - 1, i + 1);
            int l1 = 2 * k1;
            int l2 = 2 * k2 + 1;
            if (l1 > palindromeStr.length()) {
                palindromeStr = s.substring(i - k1 + 1, i + k1 + 1);
            }
            if (l2 > palindromeStr.length()) {
                palindromeStr = s.substring(i - k2, i + k2 + 1);
            }
        }
        return palindromeStr;
    }

    private int subPalindrome(String s, int l, int r) {
        int maxLen = 0;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                maxLen++;
            } else {
                break;
            }
        }
        return maxLen;
    }
}
