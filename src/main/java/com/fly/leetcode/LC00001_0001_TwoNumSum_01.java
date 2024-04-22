package com.fly.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.cn/problems/two-sum/description/
 * [1]两数之和	53.6%	Easy	0.0%
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * @author fly
 * @create 2024-04-19-21:41
 **/
public class LC00001_0001_TwoNumSum_01 {

    public static void main(String[] args) {
        LC00001_0001_TwoNumSum_01 solution = new LC00001_0001_TwoNumSum_01();
//        int[] result = solution.twoSum(new int[]{2, 7, 11, 15,8}, 10);
        int[] result = solution.twoSum(new int[]{3, 2, 4}, 6);
        if (result != null) {
            System.out.println(Arrays.toString(result));
        }
    }

    /**
     * 思路：
     * int[]转map
     * target - nums[i]在map是否存在
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 先初始化
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.put(num, i);
        }
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            Integer index = map.get(remain);
            // [bug]需要先判断index是否为null
            if (index != null && index != i) {
                return new int[]{i, index};
            }
        }
        return new int[]{-1, -1};
    }
}
