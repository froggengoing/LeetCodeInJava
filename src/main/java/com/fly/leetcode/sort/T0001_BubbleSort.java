package com.fly.leetcode.sort;

import java.util.Arrays;

/**
 * @author fly
 * @create 2024-04-26-12:51
 **/
public class T0001_BubbleSort {
    public static void main(String[] args) {
        int[] r1 = new T0001_BubbleSort().sort(new int[]{1, 2, 3, 2, 1});
        int[] r2 = new T0001_BubbleSort().sort(new int[]{1, 2, 0, 3, 3, 2, 1});
        int[] r3 = new T0001_BubbleSort().sort(new int[]{1});
        int[] r4 = new T0001_BubbleSort().sort(new int[]{1, 1});
        System.out.println(Arrays.toString(r1));
        System.out.println(Arrays.toString(r2));
        System.out.println(Arrays.toString(r3));
        System.out.println(Arrays.toString(r4));
        System.out.println(Arrays.toString(new T0001_BubbleSort().sort(new int[]{1, 0})));

    }

    public int[] sort(int nums[]) {
        for (int l = 0; l < nums.length - 1; l++) {
            for (int r = 0; r < nums.length - l - 1; r++) {
                if (nums[r + 1] > nums[r]) {
                    int tmp = nums[r];
                    nums[r] = nums[r + 1];
                    nums[r + 1] = tmp;
                }
            }
        }
        return nums;
    }
}
