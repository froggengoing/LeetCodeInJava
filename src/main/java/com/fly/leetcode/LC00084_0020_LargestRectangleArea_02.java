package com.fly.leetcode;

/**
 * [84]柱状图中最大的矩形	45.7%	Hard	0.0%
 * 动态规划
 *
 * @author fly
 * @create 2024-04-23-13:36
 **/
public class LC00084_0020_LargestRectangleArea_02 {
    public static void main(String[] args) {
        System.out.println(new LC00084_0020_LargestRectangleArea_02().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(new LC00084_0020_LargestRectangleArea_02().largestRectangleArea(new int[]{5}));
        System.out.println(new LC00084_0020_LargestRectangleArea_02().largestRectangleArea(new int[]{5, 0}));
        System.out.println(new LC00084_0020_LargestRectangleArea_02().largestRectangleArea(new int[]{0, 5, 0}));
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        // [i][j]之间最小值
        int[][] dp = new int[heights.length][heights.length];

        for (int i = heights.length - 1; i >= 0; i--) {
            for (int j = i; j < heights.length; j++) {
                if (i == j) {
                    dp[i][j] = heights[i];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
                maxArea = Math.max((j - i + 1) * dp[i][j], maxArea);
            }
        }

        return maxArea;
    }
}
