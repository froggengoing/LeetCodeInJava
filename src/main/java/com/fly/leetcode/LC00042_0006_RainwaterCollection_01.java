package com.fly.leetcode;

import java.util.Stack;

/**
 *  [42]接雨水	63.5%	Hard	0.0%
 *  https://leetcode.cn/problems/trapping-rain-water/description/
 *  单调栈，运行时间7ms
 */
public class LC00042_0006_RainwaterCollection_01 {
    public static void main(String[] args) {
        System.out.println(new LC00042_0006_RainwaterCollection_01().trap(new int[]{0, 3, 0, 2, 3}));
        System.out.println(new LC00042_0006_RainwaterCollection_01().trap(new int[]{0, 3, 1, 2, 3}));
        System.out.println(new LC00042_0006_RainwaterCollection_01().trap(new int[]{0, 3, 1, 2, 3, 5, 2, 1, 3}));
        System.out.println(new LC00042_0006_RainwaterCollection_01().trap(new int[]{0, 3, 1, 2, 3, 5, 2, 1, 3, 2}));
        System.out.println(new LC00042_0006_RainwaterCollection_01().trap(new int[]{2, 0, 1, 5}));
    }

    /**
     * 单调栈，不单调说明要出栈，执行相应操作
     * 栈中存放的是index，计算宽度
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length <= 1) return 0;
        Stack<Integer> stack = new Stack<>();

        int maxRainVol = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                Integer cur = stack.pop();
                //这还要做一次判断保证，被pop的栈，左边也是有东西的
                if (!stack.isEmpty() && height[cur] <= height[stack.peek()]) {
                    int w = i - stack.peek() - 1;
                    int h = Math.min(height[i], height[stack.peek()]) - height[cur];
                    maxRainVol += w * h;
                }
            }
            // 卡在了这里，存放index,用于计算宽度
            stack.push(i);
        }

        return maxRainVol;
    }
}