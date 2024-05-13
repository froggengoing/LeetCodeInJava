package com.fly.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode.cn/problems/3sum/description/
 * <p>
 * Runtime 1076 ms Beats 7.51% of users
 * with Java Memory 54.27 MB Beats 5.00% of users with Java
 *
 * @author fly
 * @create 2024-05-11-14:50
 **/
public class LC00015_0038_ThreeNumSum_02 {

    public static void main(String[] args) {
        System.out.println(new LC00015_0038_ThreeNumSum_02().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new LC00015_0038_ThreeNumSum_02().threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
        System.out.println(new LC00015_0038_ThreeNumSum_02().threeSum(new int[]{-1, 0, -1}));
        System.out.println(new LC00015_0038_ThreeNumSum_02().threeSum(new int[]{-1, 0, 1, 1}));
        System.out.println(new LC00015_0038_ThreeNumSum_02().threeSum(new int[]{0}));
        System.out.println(new LC00015_0038_ThreeNumSum_02().threeSum(new int[]{0, 0, 0}));
    }


    public List<List<Integer>> threeSum(int[] nums) {
        //    15. 三数之和

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
