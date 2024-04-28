package com.fly.leetcode.sort;

import java.util.Arrays;

/**
 * @author fly
 * @create 2024-04-28-16:07
 **/
public class T0008_CountingSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T0008_CountingSort().sort2(new int[]{-10, 10, 20, 0, 40, 30})));
        System.out.println(Arrays.toString(new T0008_CountingSort().sort2(new int[]{10, 20, 3, 40, 30})));
        System.out.println(Arrays.toString(new T0008_CountingSort().sort2(new int[]{-5, 1, 2, 0, 4, 3, 3, 2, 1})));
        System.out.println(Arrays.toString(new T0008_CountingSort().sort2(new int[]{-5})));
    }

    /**
     * 计数排序，将数转为数组的位置，
     *
     * @param nums
     * @return
     */
    public int[] sort(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        int[] countArr = new int[max - min + 1];

        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] - min;
            countArr[index]++;
        }


        int[] res = new int[nums.length];
        //这里会导致时间复杂度为n*k
        for (int i = 0, j = 0; i < nums.length && j < countArr.length; j++) {
            int count = countArr[j];
            if (count != 0) {
                for (int k = 0; k < count; k++) {
                    res[i++] = j + min;
                }
            }
        }

        return res;
    }

    public int[] sort2(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        int[] countArr = new int[max - min + 1];

        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] - min;
            countArr[index]++;
        }

        //对计数做累计求和
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }

        int[] res = new int[nums.length];

        // countArr中的计数-1即为在数组中的位置，秒啊
        for (int i = 0; i < nums.length; i++) {
            int index = countArr[nums[i] - min] - 1;
            res[index] = nums[i];
            countArr[nums[i] - min] -= 1;
        }

        return res;
    }
}
