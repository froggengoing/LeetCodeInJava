package com.fly.leetcode;

/**
 * [63]不同路径 II	41.3%	Medium	0.0%
 * https://leetcode.cn/problems/unique-paths-ii/solutions/316968/bu-tong-lu-jing-ii-by-leetcode-solution-2/
 * Runtime 0 ms Beats 100.00% of users
 * with Java Memory 41.90 MB Beats 16.75% of users with Java
 * @author fly
 * @create 2024-04-25-17:00
 **/
public class LC00063_0035_UniquePathsWithObstacles_01 {
    public static void main(String[] args) {
        //System.out.println(new LC00063_0035_UniquePathsWithObstacles_01().uniquePathsWithObstacles(new int[][]{
        //        {0, 0, 0}, {0, 1, 0}, {0, 0, 0}
        //}));

        System.out.println(new LC00063_0035_UniquePathsWithObstacles_01().uniquePathsWithObstacles(new int[][]{
                {0, 0, 0}
        }));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int lr = obstacleGrid.length;
        int lc = obstacleGrid[0].length;

        int[][] dp = new int[lr][lc];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < lr; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            }/* else {
                dp[i][0] = 0;
            }*/
        }
        for (int j = 1; j < lc; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j-1];
            }
        }

        for (int i = 1; i < lr; i++) {
            for (int j = 1; j < lc; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[lr - 1][lc - 1];
    }
}

