package com.fly.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * [84]柱状图中最大的矩形	45.7%	Hard	0.0%
 * 单调栈
 * 739的变式，739直接说明是找当前元素的下一个比他大的值
 * 而这里，转换为以当前高度构建的可能的最大矩形，意味着，找到左右两个，小于当前高度的位置
 *
 * Runtime 39 ms Beats 80.71% of users
 * with Java Memory 56.04 MB Beats 95.76% of users with Java
 * @author fly
 * @create 2024-04-23-13:36
 **/
public class LC00084_0020_LargestRectangleArea_04 {
    public static void main(String[] args) {
        System.out.println(new LC00084_0020_LargestRectangleArea_04().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(new LC00084_0020_LargestRectangleArea_04().largestRectangleArea(new int[]{5}));
        System.out.println(new LC00084_0020_LargestRectangleArea_04().largestRectangleArea(new int[]{5, 0}));
        System.out.println(new LC00084_0020_LargestRectangleArea_04().largestRectangleArea(new int[]{0, 5, 0}));
    }

    /**
     * 当前元素i，向左找比自己小的元素索引l，向右边找比自己小的元素索引l，当前元素最大矩形为 (r -l)*h[i]
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {

        int[] minorRight = new int[heights.length];
        for (int i = 0; i < minorRight.length; i++) minorRight[i] = heights.length;
        //当前元素i，左侧第一个比当前元素小的索引
        Deque<Integer> queueRight = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            while (!queueRight.isEmpty() && heights[i] < heights[queueRight.peekLast()]) {
                Integer pop = queueRight.pollLast();
                minorRight[pop] = i;
            }
            queueRight.addLast(i);
        }

        int[] minorLeft = new int[heights.length];
        // 必须初始化为-1，不能使用0作为业务判断
        for (int i = 0; i < minorLeft.length; i++) minorLeft[i] = -1;
        //当前元素i，左侧第一个比当前元素小的索引
        Deque<Integer> queueLeft = new LinkedList<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!queueLeft.isEmpty() && heights[i] < heights[queueLeft.peekLast()]) {
                Integer pop = queueLeft.pollLast();
                minorLeft[pop] = i;
            }
            queueLeft.addLast(i);
        }
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int ri = minorRight[i];
            int li = minorLeft[i];
            maxArea = Math.max(maxArea, (ri - li - 1) * heights[i]);
        }

        return maxArea;
    }
}
