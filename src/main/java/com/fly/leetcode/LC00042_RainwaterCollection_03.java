package com.fly.leetcode;

/**
 * [42]接雨水	63.5%	Hard	0.0%
 * 双指针，只需要保留一份maxLeftHeight、和一份maxLeftHeight，就可以了
 * 因为
 * 比如[2,0,1,3,0,6]
 * 对于当前index而言，最重要的是当前maxLeftHeight、maxLeftHeight比自己大，就能接水
 * 如果发现当前index就是最大高度，意味着，另一边可能是瓶颈，
 *
 * Runtime 0 ms
 * Beats 100.00% of users with Java
 * Memory 46.49 MB
 * Beats 20.64% of users with Java
 */
public class LC00042_RainwaterCollection_03 {
    public static void main(String[] args) {
        System.out.println(new LC00042_RainwaterCollection_03().trap(new int[]{0, 3, 0, 2, 3}));
        System.out.println(new LC00042_RainwaterCollection_03().trap(new int[]{0, 3, 1, 2, 3}));
        System.out.println(new LC00042_RainwaterCollection_03().trap(new int[]{0, 3, 1, 2, 3, 5, 2, 1, 3}));
        System.out.println(new LC00042_RainwaterCollection_03().trap(new int[]{0, 3, 1, 2, 3, 5, 2, 1, 3, 2}));
        System.out.println(new LC00042_RainwaterCollection_03().trap(new int[]{2, 0, 1, 5}));
    }

    /**
     * 遍历当前每个元素，找到左右最大的元素值，当前节点能获得最大水量为 min(max(h(r)),max(h(l))) - s[i]
     */
    public int trap(int[] height) {
        if (height.length <= 1) return 0;
        int maxRainVol = 0;
        int maxLeftHeight = 0;
        int maxRightHeight = 0;
        int li = 0;
        int ri = height.length - 1;
        while (li < ri) {
            int lh = height[li];
            int rh = height[ri];

            if (lh > rh) {
                maxLeftHeight = Math.max(maxLeftHeight, lh);
                if (maxRightHeight > rh) {
                    int waterHeight = Math.min(maxLeftHeight, maxRightHeight) - rh;
                    maxRainVol += waterHeight;
                } else {
                    maxRightHeight = rh;
                }
                ri--;
            } else {
                maxRightHeight = Math.max(maxRightHeight, rh);
                if (maxLeftHeight > lh) {
                    int waterHeight = Math.min(maxLeftHeight, maxRightHeight) - lh;
                    maxRainVol += waterHeight;
                } else {
                    maxLeftHeight = lh;
                }
                li++;
            }
        }

        return maxRainVol;
    }
}