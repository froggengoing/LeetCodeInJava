package com.fly.leetcode;

/**
 *
 * 贪心，不满足条件就重新计算
 * 同 {@link LC00053_0008_MaxSubArray_02}
 *
 * Runtime 1 ms Beats 99.66% of users
 * with Java Memory 44.02 MB Beats 88.42% of users with Java
 *
 * @author fly
 * @create 2024-04-24-22:54
 **/
public class LC00674_0028_FindLengthOfLCIS_02 {


    public static void main(String[] args) {
        System.out.println(new LC00674_0028_FindLengthOfLCIS_02().findLengthOfLCIS(new int[]{1, 3, 5, 4}));
        System.out.println(new LC00674_0028_FindLengthOfLCIS_02().findLengthOfLCIS(new int[]{1, 2, 1, 2, 3, 5, 4}));
    }

    public int findLengthOfLCIS(int[] nums) {

        int len = 1;
        int tmp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                tmp += 1;
            } else {
                tmp = 1;
            }
            len = Math.max(tmp, len);
        }
        return len;
    }
}
