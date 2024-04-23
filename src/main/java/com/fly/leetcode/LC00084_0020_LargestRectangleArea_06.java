package com.fly.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * [84]柱状图中最大的矩形	45.7%	Hard	0.0%
 * 单调栈
 * 739的变式，739直接说明是找当前元素的下一个比他大的值
 * 而这里，转换为以当前高度构建的可能的最大矩形，意味着，找到左右两个，小于当前高度的位置
 *
 * 时间更久，说明queue的操作效率真不高
 * Runtime 28 ms Beats 82.45% of users
 * with Java Memory 61.08 MB Beats 8.31% of users with Java
 * @author fly
 * @create 2024-04-23-13:36
 **/
public class LC00084_0020_LargestRectangleArea_06 {
    public static void main(String[] args) {
        System.out.println(new LC00084_0020_LargestRectangleArea_06().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(new LC00084_0020_LargestRectangleArea_06().largestRectangleArea(new int[]{5}));
        System.out.println(new LC00084_0020_LargestRectangleArea_06().largestRectangleArea(new int[]{5, 0}));
        System.out.println(new LC00084_0020_LargestRectangleArea_06().largestRectangleArea(new int[]{0, 5, 0}));
        System.out.println(new LC00084_0020_LargestRectangleArea_06().largestRectangleArea(new int[]{5, 5, 0}));
        System.out.println(new LC00084_0020_LargestRectangleArea_06().largestRectangleArea(new int[]{5, 5, 5, 0}));
    }

    /**
     * 当前元素i，向左找比自己小的元素索引l，向右边找比自己小的元素索引l，当前元素最大矩形为 (r -l)*h[i]
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {

        int[] minorRight = new int[heights.length];
        //[优化1]减少遍历
        //for (int i = 0; i < minorRight.length; i++) minorRight[i] = heights.length;

        // 一次遍历中，其实就能知道，他的左右边界
        int[] minorLeft = new int[heights.length];
        // 必须初始化为-1，不能使用0作为业务判断
        //[优化1]减少遍历
        //for (int i = 0; i < minorLeft.length; i++) minorLeft[i] = -1;

        //当前元素i，左侧第一个比当前元素小的索引
        Deque<Integer> queueRight = new LinkedList<>();

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            minorRight[i] = heights.length;
            // 弹出，意味着确定被弹出者的有边界
            while (!queueRight.isEmpty() && heights[i] < heights[queueRight.peekLast()]) {
                Integer pop = queueRight.pollLast();
                minorRight[pop] = i;
                //    确定右边界，左边界肯定已经确定了，就可以计算面积了
                maxArea = Math.max(maxArea, (minorRight[pop] - minorLeft[pop] - 1) * heights[pop]);
            }
            // 没有弹出的，意味着比自己小，确定左边界
            minorLeft[i] = queueRight.isEmpty() ? -1 : queueRight.peekLast();
            queueRight.addLast(i);
        }

        //能进入这里循环，意味着ri == heights.length，所以其实可以省去两个数组的空间
        while (!queueRight.isEmpty()){
            Integer i = queueRight.pollLast();
            int ri = minorRight[i];
            int li = minorLeft[i];
            maxArea = Math.max(maxArea, (ri - li - 1) * heights[i]);
        }

        return maxArea;
    }
}
