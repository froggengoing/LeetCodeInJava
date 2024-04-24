package com.fly.leetcode;

/**
 * 392. 判断子序列
 * https://leetcode.cn/problems/is-subsequence/description/
 * <p>
 * 1 ms Beats 90.62% of users
 * with Java Memory 41.28 MB Beats 64.83% of users with Java
 *
 * @author fly
 * @create 2024-04-24-23:31
 **/
public class LC00392_0030_iISubsequence_02 {
    public static void main(String[] args) {

        System.out.println(new LC00392_0030_iISubsequence_01().isSubsequence("abc", "dcabc"));
        System.out.println(new LC00392_0030_iISubsequence_02().isSubsequence("abc", "ahbgdc"));
        System.out.println(new LC00392_0030_iISubsequence_01().isSubsequence("cd", "dcabc"));
        System.out.println(new LC00392_0030_iISubsequence_01().isSubsequence("aaaaaa", "bbaaaa"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() < 1) return true;
        if (t.length() < 1) return false;

        int l = 0, r = 0;
        while (r < t.length() && l < s.length()) {
            while (r < t.length()) {
                if (s.charAt(l) == t.charAt(r)) {
                    l++;
                    //bug，这里也要往前走，因为坑已经被占了
                    r++;
                    if (l == s.length()) {
                        return true;
                    }
                    break;
                } else {
                    r++;
                }
            }
        }
        return false;
    }
}
