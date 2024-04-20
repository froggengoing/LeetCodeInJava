package com.fly.leetcode;

import java.util.HashMap;
import java.util.Map;

class LC00003_MaxSubStrLen_02 {
    public static void main(String[] args) {
        System.out.println( new LC00003_MaxSubStrLen_02().lengthOfLongestSubstring("abcdecaehcb"));
        System.out.println( new LC00003_MaxSubStrLen_02().lengthOfLongestSubstring("bbbb"));
        System.out.println( new LC00003_MaxSubStrLen_02().lengthOfLongestSubstring("b"));
        System.out.println( new LC00003_MaxSubStrLen_02().lengthOfLongestSubstring("babcd"));
    }
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();


        for (int l = 0, r = 0; r < s.length(); r++) {
            char ls = s.charAt(l);
            char rs = s.charAt(r);

            Integer rIndex = map.get(rs);
            if (rIndex != null && rIndex >= l) {
                l = rIndex + 1;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            map.put(rs, r);
        }
        return maxLen;
    }
}