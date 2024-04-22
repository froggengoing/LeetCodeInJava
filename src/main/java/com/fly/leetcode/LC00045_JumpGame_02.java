package com.fly.leetcode;

/**
 * [55]跳跃游戏	43.3%	Medium	0.0%
 * 贪心算法
 * https://leetcode.com/problems/jump-game/submissions/1238881455/
 * Runtime 2 ms Beats 81.98% of users
 * with Java Memory 45.52 MB Beats 52.15% of users with Java
 * 遍历每个节点一次，判断当前节点是否之前可达，可达则继续，不可达
 * @author fly
 * @create 2024-04-22-14:12
 **/
public class LC00045_JumpGame_02 {

    public static void main(String[] args) {
        System.out.println(new LC00045_JumpGame_02().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new LC00045_JumpGame_02().canJump(new int[]{2, 3, 1, 1, 0, 4}));
        System.out.println(new LC00045_JumpGame_02().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new LC00045_JumpGame_02().canJump(new int[]{3, 1, 1, 1, 4}));
    }

    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int index = 0; index < nums.length && index <= maxIndex; index++) {
            maxIndex = Math.max(index + nums[index], maxIndex);
            if (maxIndex >= nums.length - 1) return true;
        }
        return false;
    }
}
