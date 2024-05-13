package com.fly.leetcode;

/**
 * 8. 字符串转换整数 (atoi)
 * https://leetcode.cn/problems/string-to-integer-atoi/description/
 *
 * Runtime 1 ms Beats 100.00% of users with Java Memory 41.84 MB Beats 95.91% of users with Java
 * @author fly
 * @create 2024-05-13-16:03
 **/
public class LC00008_0040_MyAtoi_01 {

    public static void main(String[] args) {
        //System.out.println(new LC00008_0040().myAtoi("  -347233ddd2"));
        //System.out.println(new LC00008_0040_MyAtoi_01().myAtoi("    2147483648"));
        System.out.println(new LC00008_0040_MyAtoi_01().myAtoi("  -91283472332"));
    }

    /**
     * @see Integer#parseInt(String, int)
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        if (s.length() <= 0) return 0;
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') i++;
        if (i >= s.length()) return 0;
        boolean isNegative = false;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            isNegative = s.charAt(i) == '-';
            i++;
            if (i >= s.length()) return 0;
        }
        // 去掉前导0
        while (i < s.length() && s.charAt(i) == '0') i++;
        if (i >= s.length()) return 0;
        int res = 0;
        // 参考Integer.parseInt(String s, int radix)
        int limit = isNegative ? Integer.MIN_VALUE : -Integer.MAX_VALUE;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';
            // 负数最大值  -2147483648
            //            -91283472332
            // 正数最大值  2147483647
            // 超边界在：
            // min > res * 10 - digit => min + digit > res * 10
            // max < res * 10 + digit => -max > -res * 10 - digit => -max + digit > -res * 10
            // 上面两个条件可以合并成：limit + digit > res * 10 则超边界，其中正数先使用负数表示
            //必须使用/而不能是*
            if (res  < (limit + digit)/10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else {
                res = res * 10 - digit;

            }
            i++;
        }
        return isNegative ? res : -res;
    }
}
