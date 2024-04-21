package com.fly.leetcode;

/**
 * ✔	[62]不同路径	68.2%	Medium	0.0%
 * 动态规划
 */
class LC00062_UniquePaths_01 {
    public static void main(String[] args) {
        System.out.println(new LC00062_UniquePaths_01().uniquePaths(3, 7));
        System.out.println(new LC00062_UniquePaths_01().uniquePaths(3, 2));
    }
    //dp[m,n]=dp[m,n-1]+dp[m-1,n]
    public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }

        int[][] dp = new int[m][n];
        //初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        dp[0][1] = 1;
        dp[1][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}