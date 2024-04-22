package com.fly.leetcode;
/**
 * [5]最长回文子串	38.3%	Medium	0.0%
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * Related Topics
 * 字符串
 * 动态规划
 */

/**
 * 暴力破解
 * 时间复杂度o(n^3)
 * @author fly
 * @create 2024-04-20-14:14
 **/
public class LC00005_0004_LongestPalindrome_01 {
    public static void main(String[] args) {
        System.out.println(new LC00005_0004_LongestPalindrome_01().longestPalindrome("abcbca"));
        System.out.println(new LC00005_0004_LongestPalindrome_01().longestPalindrome("abc"));
        System.out.println(new LC00005_0004_LongestPalindrome_01().longestPalindrome("a"));
    }

    public String longestPalindrome(String s) {
        String palindromeStr = "";
        for (int l = 0; l < s.length(); l++) {
            for (int r = l + 1; r <= s.length(); r++) {
                String subStr = s.substring(l, r);
                if (isPalindrome(subStr)) {
                    palindromeStr = subStr.length() > palindromeStr.length() ? subStr : palindromeStr;
                }
            }
        }
        return palindromeStr;
    }

    private boolean isPalindrome(String subStr) {
        for (int i = 0; i < subStr.length() / 2; i++) {
            char l = subStr.charAt(i);
            char r = subStr.charAt(subStr.length() - 1 - i);
            if (l != r) {
                return false;
            }
        }
        return true;
    }
}
