package com.fly.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * [3]无重复字符的最长子串	39.7%	Medium	0.0%
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * 示例 1:

 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 */
class LC00003_0003_MaxSubStrLen_01 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        for (int l = 0, r = 0; l < s.length() || r < s.length(); ) {
            char ls = s.charAt(l);
            char rs = s.charAt(r);
            if (!set.contains(rs)) {
                set.add(rs);
                //对比大小
                maxLen = Math.max(r - l, maxLen);
                r++;
            } else {
                set.remove(ls);
                l++;
            }
        }

        return maxLen;
    }
}