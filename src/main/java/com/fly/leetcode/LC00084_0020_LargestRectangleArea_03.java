package com.fly.leetcode;

/**
 * [84]柱状图中最大的矩形	45.7%	Hard	0.0%
 * 动态规划
 *
 * @author fly
 * @create 2024-04-23-13:36
 **/
public class LC00084_0020_LargestRectangleArea_03 {
    public static void main(String[] args) {
        System.out.println(new LC00084_0020_LargestRectangleArea_03().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(new LC00084_0020_LargestRectangleArea_03().largestRectangleArea(new int[]{5}));
        System.out.println(new LC00084_0020_LargestRectangleArea_03().largestRectangleArea(new int[]{5, 0}));
        System.out.println(new LC00084_0020_LargestRectangleArea_03().largestRectangleArea(new int[]{0, 5, 0}));
    }

    /**
     * 当前元素i，向左找比自己小的元素索引l，向右边找比自己小的元素索引l，当前元素最大矩形为 (r -l)*h[i]
     * 其实和dp一样,但转换了一种思想，这样可以引出单调栈，解决l、r的问题
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        int length = heights.length;
        for (int i = 0; i < length; i++) {
            int l = i;
            int r = i;
            while (r < length && heights[r] >= heights[i]) {
                r++;
            }
            while (l >= 0 && heights[l] >= heights[i]) {
                l--;
            }
            maxArea = Math.max((r - l - 1) * heights[i], maxArea);
        }


        return maxArea;
    }
}
