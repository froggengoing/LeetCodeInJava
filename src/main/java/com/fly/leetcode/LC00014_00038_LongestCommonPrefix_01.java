package com.fly.leetcode;


/**
 * 14. 最长公共前缀
 * https://leetcode.cn/problems/longest-common-prefix/description/
 *
 * Runtime 1 ms Beats 75.48% of users
 * with Java Memory 41.28 MB Beats 72.53% of users with Java
 */
public class LC00014_00038_LongestCommonPrefix_01 {
    public String longestCommonPrefix(String[] strs) {
        int end = -1;
        outer:
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    break outer;
                }
            }
            end = i;
        }
        return end == -1 ? "" : strs[0].substring(0, end + 1);

    }
}