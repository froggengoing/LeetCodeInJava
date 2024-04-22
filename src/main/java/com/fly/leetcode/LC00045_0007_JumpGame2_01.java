package com.fly.leetcode;

/**
 * [45]跳跃游戏 II	44.4%	Medium	0.0%
 * https://leetcode.cn/problems/jump-game-ii/
 * Runtime 1 ms Beats 99.02% of users
 * with Java Memory 45.02 MB Beats 51.52% of users with Java
 * @author fly
 * @create 2024-04-22-18:05
 **/
public class LC00045_0007_JumpGame2_01 {
    public static void main(String[] args) {
        //System.out.println(new LC00045_JumpGame2_01().canJump(new int[]{2, 3, 1, 1, 4}));
        //System.out.println(new LC00045_JumpGame2_01().canJump(new int[]{2, 3, 1, 1, 0, 4}));
        //System.out.println(new LC00045_JumpGame2_01().canJump(new int[]{3, 2, 1, 0, 4}));
        //System.out.println(new LC00045_JumpGame2_01().canJump(new int[]{3, 1, 1, 1, 4}));
        //System.out.println(new LC00045_JumpGame2_01().canJump(new int[]{3, 1, 1, 1, 1, 1, 4}));
        System.out.println(new LC00045_0007_JumpGame2_01().jump(new int[]{0,0}));
        System.out.println(new LC00045_0007_JumpGame2_01().jump(new int[]{1,0,0}));

    }

    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int count = 0;
        for (int index = 0; index < nums.length; ) {
            int step = nums[index];
            if (index + step >= nums.length - 1) return count + 1;
            //step为0，则不是最后一个
            if (step == 0) return 0;

            int nextIndex = 0;
            int maxNextIndex = 0;
            //下次能到的最远地方
            for (int j = index + 1; j <= index + step; j++) {
                if (nums[j] + j >= maxNextIndex) {
                    maxNextIndex = nums[j] + j;
                    nextIndex = j;
                }
            }
            count++;
            index = nextIndex;
        }
        return 0;
    }
}
