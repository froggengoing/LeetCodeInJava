package com.fly.leetcode.sort;

import java.util.Arrays;

/**
 * @author fly
 * @create 2024-04-28-10:45
 **/
public class T0006_QuickSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T0006_QuickSort().sort(new int[]{1, 2, 0, 4, 3, 3, 2, 1})));
    }

    public int[] sort(int[] nums) {
        return quickSort(nums, 0, nums.length - 1);
    }

    private int[] quickSort(int[] nums, int l, int r) {
        //这里是<1而不是<=1
        if (r - l < 1) return nums;
        int p = nums[l];

        int i, j, x;
        i = l;
        j = r;
        x = nums[i];

        while (i < j) {
            while (i < j && nums[j] < x) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] > x) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = x;
        //bug ,这里是i-1，而不是i
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);

        return nums;
    }
}
