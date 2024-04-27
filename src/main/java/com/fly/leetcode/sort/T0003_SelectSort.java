package com.fly.leetcode.sort;

import java.util.Arrays;

/**
 * @author fly
 * @create 2024-04-27-16:05
 **/
public class T0003_SelectSort {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new T0002_InsertSort().sort(new int[]{1, 2, 3, 2, 1})));
        System.out.println(Arrays.toString(new T0002_InsertSort().sort(new int[]{1, 0})));
        System.out.println(Arrays.toString(new T0002_InsertSort().sort(new int[]{1, 2, 0, 3, 3, 2, 1})));

    }
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int curMaxIndex = 0;
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[curMaxIndex] < nums[j]) {
                    curMaxIndex = j;
                }
            }
            int tmp = nums[curMaxIndex];
            nums[curMaxIndex] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmp;
        }

        return nums;
    }
}
