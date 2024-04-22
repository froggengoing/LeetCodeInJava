package com.fly.leetcode;

/**
 * [55]跳跃游戏	43.3%	Medium	0.0%
 * 动态规范，但其实和前面的示例没有区别
 * https://leetcode.com/problems/jump-game/submissions/1238881455/
 * Runtime 4 ms Beats 22.58% of users
 * with Java Memory 45.68 MB Beats 39.77% of users with Java
 * 遍历每个节点一次，判断当前节点是否之前可达，可达则继续，不可达
 *
 * @author fly
 * @create 2024-04-22-14:12
 **/
public class LC00055_JumpGame_04 {

    public static void main(String[] args) {
        System.out.println(new LC00055_JumpGame_04().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new LC00055_JumpGame_04().canJump(new int[]{2, 3, 1, 1, 0, 4}));
        System.out.println(new LC00055_JumpGame_04().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new LC00055_JumpGame_04().canJump(new int[]{3, 1, 1, 1, 4}));
    }

    /**
     *
     */
    public boolean canJump(int[] nums) {
        if (nums.length < 1) return true;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int index = 1; index < nums.length; index++) {
            if (index > dp[index - 1]) return false;
            dp[index] = Math.max(dp[index - 1], index + nums[index]);
        }
        return true;
    }
}
