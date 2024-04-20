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

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int r = 0, l = 0; r < n; r++) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(map.get(s.charAt(r)), l);
            }
            ans = Math.max(ans, r - l + 1);
            map.put(s.charAt(r), r + 1);
        }
        return ans;
    }
}