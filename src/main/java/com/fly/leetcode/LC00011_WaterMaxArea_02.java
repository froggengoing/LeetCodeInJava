package com.fly.leetcode;

/**
 * 一直不理解11盛水的容器，为什么是往短板走，有没有可能漏的问题，知道看到了这篇文章
 * https://leetcode.cn/problems/container-with-most-water/solutions/94102/on-shuang-zhi-zhen-jie-fa-li-jie-zheng-que-xing-tu/
 * 暴力破解中实际，就是一个n^2的二维数组，优化就是设计算法减少二维数组的遍历次数
 *
 * @author fly
 * @create 2024-04-20-23:48
 **/
public class LC00011_WaterMaxArea_02 {
    public static void main(String[] args) {
        System.out.println(new LC00011_WaterMaxArea_02().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int hr = height[r];
            int hl = height[l];
            maxArea = Math.max((r - l) * Math.min(hr, hl), maxArea);
            if (hr > hl) l++;
            if (hr <= hl) r--;
        }
        return maxArea;
    }
}
