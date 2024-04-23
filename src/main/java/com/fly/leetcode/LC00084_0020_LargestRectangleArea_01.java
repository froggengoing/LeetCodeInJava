package com.fly.leetcode;

/**
 * [84]柱状图中最大的矩形	45.7%	Hard	0.0%
 * https://leetcode.com/problems/largest-rectangle-in-histogram
 *
 * 暴力求解，Time Limit Exceeded
 * @author fly
 * @create 2024-04-23-13:36
 **/
public class LC00084_0020_LargestRectangleArea_01 {
    public static void main(String[] args) {
        System.out.println(new LC00084_0020_LargestRectangleArea_01().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(new LC00084_0020_LargestRectangleArea_01().largestRectangleArea(new int[]{5}));
        System.out.println(new LC00084_0020_LargestRectangleArea_01().largestRectangleArea(new int[]{5, 0}));
        System.out.println(new LC00084_0020_LargestRectangleArea_01().largestRectangleArea(new int[]{0, 5, 0}));
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max((j - i + 1) * minHeight, maxArea);
            }
        }
        return maxArea;
    }
}
