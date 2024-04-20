package com.fly.leetcode;

import java.util.HashSet;
import java.util.Set;

class LC00003_MaxSubStrLen_01 {
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