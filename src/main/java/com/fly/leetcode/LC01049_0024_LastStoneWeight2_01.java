package com.fly.leetcode;

/**
 * 1049. 最后一块石头的重量 II
 * https://leetcode.cn/problems/last-stone-weight-ii/description/
 * <p>
 * https://leetcode.cn/problems/last-stone-weight-ii/solutions/818362/gong-shui-san-xie-xiang-jie-wei-he-neng-jgxik
 * <p>
 * 转换为[494]目标和，即对数组中任意元素价+或-，得到最小值
 * 即选中元素，在 sum/2内最大
 * Runtime 4 ms Beats 58.82% of users
 * with Java Memory 41.57 MB Beats 40.40% of users with Java
 *
 * @author fly
 * @create 2024-04-23-21:18
 **/
public class LC01049_0024_LastStoneWeight2_01 {
    public static void main(String[] args) {
        //System.out.println(new LC01049_0024_LastStoneWeight2_01().lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(new LC01049_0024_LastStoneWeight2_01().lastStoneWeightII(new int[]{1, 2}));
    }

    public int lastStoneWeightII(int[] nums) {
        int sum = 0;
        // bug: 负数要纠正为正数，因为是等价的
        //target = Math.abs(target);
        for (int i = 0; i < nums.length; i++) sum += nums[i];

        int target = sum / 2;

        int[][] dp = new int[nums.length][target + 1];
        //dp[0][0] = 0;


        for (int j = 1; j < target + 1; j++) {
            if (j >= nums[0]) dp[0][j] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= val) {
                    //如果nums[i-1]==0 相当于 在上一个的基础上*2
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - val] + val);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return sum - 2 * dp[nums.length - 1][target];
    }
}
