package com.fly.leetcode;

/**
 * ✔	[509]斐波那契数	65.9%	Easy	0.0%
 * @author fly
 * @create 2024-04-21-15:23
 **/
public class LC00509_Fib_01 {

    public static void main(String[] args) {
        System.out.println(new LC00509_Fib_01().fib(1));
        System.out.println(new LC00509_Fib_01().fib(2));
        System.out.println(new LC00509_Fib_01().fib(3));
        System.out.println(new LC00509_Fib_01().fib(4));
        System.out.println(new LC00509_Fib_01().fib(5));
    }

    //F(0) = 0，F(1) = 1 F(n) = F(n - 1) + F(n - 2)，其中 n > 1
    public int fib(int n) {

        if (n <= 0) return 0;
        if (n <= 1) return 1;
        if (n <= 2) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
