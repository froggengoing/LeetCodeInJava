package com.fly.leetcode;

/**
 * [42]接雨水	63.5%	Hard	0.0%
 * 动态规划，时间复杂度o(3n),运行时间1ms,比单调栈快，可能是栈操作花时间
 * Runtime 1 ms
 * Beats 71.24% of users with Java
 * Memory 45.79 MB Beats 75.50% of users with Java
 */
public class LC00042_0006_RainwaterCollection_02 {
    public static void main(String[] args) {
        System.out.println(new LC00042_0006_RainwaterCollection_02().trap(new int[]{0, 3, 0, 2, 3}));
        System.out.println(new LC00042_0006_RainwaterCollection_02().trap(new int[]{0, 3, 1, 2, 3}));
        System.out.println(new LC00042_0006_RainwaterCollection_02().trap(new int[]{0, 3, 1, 2, 3, 5, 2, 1, 3}));
        System.out.println(new LC00042_0006_RainwaterCollection_02().trap(new int[]{0, 3, 1, 2, 3, 5, 2, 1, 3, 2}));
        System.out.println(new LC00042_0006_RainwaterCollection_02().trap(new int[]{2, 0, 1, 5}));
    }

    /**
     * 遍历当前每个元素，找到左右最大的元素值，当前节点能获得最大水量为 min(max(h(r)),max(h(l))) - s[i]
     */
    public int trap(int[] height) {
        if (height.length <= 1) return 0;

        int[] maxLeftDp = new int[height.length];
        maxLeftDp[0] = 0;
        int[] maxRightDp = new int[height.length];
        maxRightDp[0] = 0;
        int maxRainVol = 0;
        for (int i = 1; i < height.length; i++) {
            maxLeftDp[i] = Math.max(maxLeftDp[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            maxRightDp[i] = Math.max(maxRightDp[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            //左右都比当前值大，说明当前有积水
            if (maxLeftDp[i] > height[i] && maxRightDp[i] > height[i]) {
                maxRainVol += Math.min(maxLeftDp[i], maxRightDp[i]) - height[i];
            }
        }
        return maxRainVol;
    }
}