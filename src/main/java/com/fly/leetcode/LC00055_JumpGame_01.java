package com.fly.leetcode;

/**
 * [55]跳跃游戏	43.3%	Medium	0.0%
 * https://leetcode.com/problems/jump-game/submissions/1238881455/
 *
 * 3 ms Beats 55.63% of users with Java
 * Memory 45.35 MB Beats 77.86% of users with Java
 *
 * @author fly
 * @create 2024-04-22-14:12
 **/
public class LC00055_JumpGame_01 {

    public static void main(String[] args) {
        System.out.println(new LC00055_JumpGame_01().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new LC00055_JumpGame_01().canJump(new int[]{2, 3, 1, 1, 0, 4}));
        System.out.println(new LC00055_JumpGame_01().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new LC00055_JumpGame_01().canJump(new int[]{3, 1, 1, 1, 4}));
    }

    public boolean canJump(int[] nums) {
        for (int index = 0; index < nums.length; ) {
            int step = nums[index];
            if (index + step >= nums.length - 1) return true;
            //step为0，则不是最后一个
            if (step == 0) return false;

            int nextIndex = 0;
            int maxNextIndex = 0;
            //去本次能到的最远地方
            for (int j = index + 1; j <= index + step; j++) {
                if (nums[j] + j >= maxNextIndex) {
                    maxNextIndex = nums[j] + j;
                    nextIndex = j;
                }
            }
            index = nextIndex;
        }
        return false;
    }
}
