package com.fly.leetcode;

/**
 * 343. 整数拆分
 * https://leetcode.cn/problems/integer-break/solutions/352875/zheng-shu-chai-fen-by-leetcode-solution/
 *
 * Runtime 0 ms Beats 100.00% of users
 * with Java Memory 40.15 MB Beats 63.94% of users with Java
 * @author fly
 * @create 2024-04-25-18:02
 **/
public class LC00343_0036_IntegerBreak_01 {

    public static void main(String[] args) {
        System.out.println(new LC00343_0036_IntegerBreak_01().integerBreak(5));
        System.out.println(new LC00343_0036_IntegerBreak_01().integerBreak(6));
        System.out.println(new LC00343_0036_IntegerBreak_01().integerBreak(7));
        System.out.println(new LC00343_0036_IntegerBreak_01().integerBreak(8));
        System.out.println(new LC00343_0036_IntegerBreak_01().integerBreak(9));
        System.out.println(new LC00343_0036_IntegerBreak_01().integerBreak(10));
        System.out.println(new LC00343_0036_IntegerBreak_01().integerBreak(11));
    }

    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        int[] dp = new int[n + 1];
        if (n >= 4) dp[4] = 4;
        if (n >= 5) dp[5] = 6;
        if (n >= 6) dp[6] = 9;
        for (int i = 7; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] * 2, dp[i - 3] * 3);
        }
        return dp[n];
    }
}
