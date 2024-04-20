package com.fly.leetcode;

class LC00003_MaxSubStrLen_03 {
    public static void main(String[] args) {
        System.out.println(new LC00003_MaxSubStrLen_03().lengthOfLongestSubstring("abcdecaehcb"));
        System.out.println(new LC00003_MaxSubStrLen_03().lengthOfLongestSubstring("bbbb"));
        System.out.println(new LC00003_MaxSubStrLen_03().lengthOfLongestSubstring("b"));
        System.out.println(new LC00003_MaxSubStrLen_03().lengthOfLongestSubstring("babcd"));
        System.out.println(new LC00003_MaxSubStrLen_03().lengthOfLongestSubstring(" "));
    }

    /**
     * 错误写法
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int[] charArr = new int[256];
        for (int l = 0, r = 0; r < s.length(); r++) {
            char rs = s.charAt(r);
//            int i = rs - 'a';
            int rIndex = charArr[rs];
            l = Math.max(rIndex, l);
            maxLen = Math.max(maxLen, r - l + 1);
//            这里存的是下一个位置，避免了与默认值0冲突的问题
            charArr[rs] = r + 1;
        }
        return maxLen;
    }

//    public int lengthOfLongestSubstring(String s) {
//        int maxLen = 0;
//
//        int[] charArr = new int[128];
//        for (int l = 0, r = 0; r < s.length(); r++) {
//            l = Math.max(charArr[s.charAt(r)], l);
//            maxLen = Math.max(maxLen, r - l + 1);
//            charArr[s.charAt(r)] = r + 1;
//        }
//        return maxLen;
//    }
}