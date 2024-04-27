package com.fly.leetcode.sort;

import java.util.Arrays;

/**
 * @author fly
 * @create 2024-04-26-12:51
 **/
public class T0002_InsertSort {
    public static void main(String[] args) {

        //System.out.println(Arrays.toString(new T0002_InsertSort().sort(new int[]{1, 2, 3, 2, 1})));
        //System.out.println(Arrays.toString(new T0002_InsertSort().sort(new int[]{1, 0})));

        System.out.println(Arrays.toString(new T0002_InsertSort().sort(new int[]{1, 2, 0, 3, 3, 2, 1})));
    }

    public int[] sort(int[] nums) {
        if (nums.length <= 1) return nums;
        int[] res = new int[nums.length];
        int count = 0;
        res[0] = nums[0];
        for (int r = 1; r < nums.length; r++) {
            int l = r;
            res[l] = nums[r];
            while (l > 0 && res[l] > res[l - 1]) {
                System.out.println(count++);
                res[l] = res[l - 1];
                res[l - 1] = nums[r];
                l--;
            }
            //res[l] = nums[r];
        }
        return res;
    }
}
