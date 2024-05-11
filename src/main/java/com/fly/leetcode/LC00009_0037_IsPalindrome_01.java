package com.fly.leetcode;

/**
 * Runtime 5 ms Beats 75.17% of users
 * with Java Memory 43.68 MB Beats 82.75% of users with Java
 **/
public class LC00009_0037_IsPalindrome_01 {
    public static void main(String[] args) {
        System.out.println(new LC00009_0037_IsPalindrome_01().isPalindrome(1234));
        System.out.println(new LC00009_0037_IsPalindrome_01().isPalindrome(121));
        System.out.println(new LC00009_0037_IsPalindrome_01().isPalindrome(0));
    }

    /**
     *
     */
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for (int l = 0, r = s.length() - 1; l < r; l++, r--) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
        }
        return true;
    }


}
