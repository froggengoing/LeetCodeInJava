package com.fly.leetcode.sort;

import java.util.Arrays;

/**
 * @author fly
 * @create 2024-04-27-16:05
 **/
public class T0003_ShellSort {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new T0003_ShellSort().sort(new int[]{1, 2, 3, 2, 1})));
        System.out.println(Arrays.toString(new T0003_ShellSort().sort(new int[]{1, 0})));
        System.out.println(Arrays.toString(new T0003_ShellSort().sort(new int[]{1, 2, 0, 3, 3, 2, 1})));
        //System.out.println(Arrays.toString(new T0003_ShellSort().shellSort(new int[]{1, 2, 0, 3, 3, 2, 1})));

    }

    public int[] sort(int[] nums) {
        int count = 0;
        for (int step = nums.length / 2; step > 0; step = step / 2) {
            for (int i = step; i < nums.length; i++) {
                int j = i - step;
                int tmp = nums[i];
                boolean b = false;
                while (j >= 0 && nums[j] < tmp) {
                    b = true;
                    System.out.println(count++);
                    nums[j + step] = nums[j];
                    j -= step;
                }
                if (!b) System.out.println(count++);
                nums[j + step] = tmp;
            }
        }

        return nums;
    }

    public int[] shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        int count = 0;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                boolean b = false;
                while (j >= 0 && arr[j] < temp) {
                    System.out.println(count++);
                    arr[j + step] = arr[j];
                    j -= step;
                }
                if (!b) System.out.println(count++);
                arr[j + step] = temp;
            }
        }
        return arr;
    }
}
