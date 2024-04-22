package com.fly.leetcode;

/**
 * [55]跳跃游戏	43.3%	Medium	0.0%
 * 贪心算法
 * https://leetcode.com/problems/jump-game/submissions/1238881455/
 * Runtime 3 ms Beats 55.63% of users
 * with Java Memory 45.70 MB Beats 39.77% of users with Java
 * 遍历每个节点一次，判断当前节点是否之前可达，可达则继续，不可达
 *
 * @author fly
 * @create 2024-04-22-14:12
 **/
public class LC00055_JumpGame_03 {

    public static void main(String[] args) {
        System.out.println(new LC00055_JumpGame_03().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new LC00055_JumpGame_03().canJump(new int[]{2, 3, 1, 1, 0, 4}));
        System.out.println(new LC00055_JumpGame_03().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new LC00055_JumpGame_03().canJump(new int[]{3, 1, 1, 1, 4}));
    }

    /**
     * 默认返回true，代码更简洁
     */
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int index = 0; index < nums.length; index++) {
            if (index > maxIndex) return false;
            maxIndex = Math.max(index + nums[index], maxIndex);
        }
        return true;
    }
}
