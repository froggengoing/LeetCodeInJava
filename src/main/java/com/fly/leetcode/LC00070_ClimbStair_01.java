package com.fly.leetcode;

/**
 * [70]爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author fly
 * @create 2024-04-21-0:43
 **/
public class LC00070_ClimbStair_01 {


    /**
     * dp[n] = dp[n-1]+dp[n-2]
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int count;
        int[] steps = new int[n];
        steps[0] = 1;
        steps[1] = 2;

        for (int i = 2; i < n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n - 1];
    }
}
