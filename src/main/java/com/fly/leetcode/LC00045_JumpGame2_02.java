package com.fly.leetcode;

/**
 * [45]跳跃游戏 II	44.4%	Medium	0.0%
 * https://leetcode.cn/problems/jump-game-ii/
 *
 * Runtime 2 ms Beats 76.69% of users
 * with Java Memory 44.50 MB Beats 94.34% of users with Java
 * 解法本质与官方一直，这里优化以下代码
 *
 * @author fly
 * @create 2024-04-22-18:05
 **/
public class LC00045_JumpGame2_02 {
    public static void main(String[] args) {
        System.out.println(new LC00045_JumpGame2_02().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new LC00045_JumpGame2_02().jump(new int[]{2, 3, 1, 1, 0, 4}));
        System.out.println(new LC00045_JumpGame2_02().jump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new LC00045_JumpGame2_02().jump(new int[]{3, 1, 1, 1, 4}));
        System.out.println(new LC00045_JumpGame2_02().jump(new int[]{3, 1, 1, 1, 1, 1, 4}));
        System.out.println(new LC00045_JumpGame2_02().jump(new int[]{0, 0}));
        System.out.println(new LC00045_JumpGame2_02().jump(new int[]{1, 0, 0}));

    }

    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int count = 0;
        //在lastIndex和nextIndex之间，找到最优值，下一次的
        int nextIndex = 0;
        int curCircleMaxNextIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > nextIndex) return 0;
            if (i == nums.length - 1) return count;
            curCircleMaxNextIndex = Math.max(curCircleMaxNextIndex, i + nums[i]);
            // 这里的nextIndex扮演 01解法中的，内部循环
            if (i == nextIndex) {
                nextIndex = curCircleMaxNextIndex;
                count++;
            }
        }
        return count;
    }

}
