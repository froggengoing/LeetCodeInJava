package com.fly.leetcode;
/**
 * [5]最长回文子串	38.3%	Medium	0.0%
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * Related Topics
 * 字符串
 * 动态规划
 */

/**
 * Runtime 15 ms Beats 87.85% of users
 * with Java Memory 41.80 MB Beats 93.57% of users with Java
 *
 * @author fly
 * @create 2024-04-20-14:14
 **/
public class LC00005_0004_LongestPalindrome_02_01 {
    public static void main(String[] args) {
        System.out.println(new LC00005_0004_LongestPalindrome_02_01().longestPalindrome("abcbca"));
        System.out.println(new LC00005_0004_LongestPalindrome_02_01().longestPalindrome("abc"));
        System.out.println(new LC00005_0004_LongestPalindrome_02_01().longestPalindrome("a"));
    }

    // 中心扩展
    public String longestPalindrome(String s) {

        int maxLen = 0;
        int begin = 0;
        int end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {

            for (int j = i ; j < s.length(); j++) {
                if(i==j){
                    dp[i][i] = true;
                }else if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]= j-i<2?true:dp[i+1][j-1];
                }
                if(dp[i][j] && j-i>maxLen){
                    begin = i;
                    end = j;
                }
            }

        }

        return s.substring(begin, end +1);
    }
}
