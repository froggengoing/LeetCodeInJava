package com.fly.leetcode;

import java.util.*;

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
public class LC00015_0038_ThreeNumSum_01 {

    public static void main(String[] args) {
        System.out.println(new LC00015_0038_ThreeNumSum_01().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new LC00015_0038_ThreeNumSum_02().threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
        System.out.println(new LC00015_0038_ThreeNumSum_01().threeSum(new int[]{-1, 0, -1}));
        System.out.println(new LC00015_0038_ThreeNumSum_01().threeSum(new int[]{-1, 0, 1, 1}));
        System.out.println(new LC00015_0038_ThreeNumSum_01().threeSum(new int[]{0}));
        System.out.println(new LC00015_0038_ThreeNumSum_01().threeSum(new int[]{0, 0, 0}));
        System.out.println(new LC00015_0038_ThreeNumSum_01().threeSum(new int[]{0, 0, 0, 0}));
    }

    /**
     * 这里存在重复的元素，所以需要先排序，确保输入的三元组是顺序的，
     * 并使用LinkedHashSet去重复
     *
     * @param nums
     * @return
     */

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        LinkedHashSet<List<Integer>> res = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int target = -nums[i] - nums[j];
                if (map.containsKey(target)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(target);
                    res.add(list);
                } else {
                    map.put(nums[j], 1);
                }
            }
        }
        return res.stream().toList();
    }
}
