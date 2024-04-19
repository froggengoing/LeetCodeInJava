package com.fly.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author fly
 * @create 2024-04-19-21:41
 **/
public class LC00001_TwoNumSum_02 {

    public static void main(String[] args) {
        LC00001_TwoNumSum_02 solution = new LC00001_TwoNumSum_02();
//        int[] result = solution.twoSum(new int[]{2, 7, 11, 15,8}, 10);
//        int[] result = solution.twoSum(new int[]{3, 2, 4}, 6);
        int[] result = solution.twoSum(new int[]{3, 3}, 6);
        if (result != null) {
            System.out.println(Arrays.toString(result));
        }
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int remain = target - num;
            Integer index = map.get(remain);
            if (index != null && index != i) {
                return new int[]{i, index};
            }
            map.put(num, i);
        }
        return new int[2];
    }
}
