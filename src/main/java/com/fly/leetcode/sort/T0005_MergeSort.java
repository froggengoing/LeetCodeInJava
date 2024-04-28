package com.fly.leetcode.sort;

import java.util.Arrays;

/**
 * @author fly
 * @create 2024-04-27-16:05
 **/
public class T0005_MergeSort {

    int count = 0;

    public static void main(String[] args) {

        //System.out.println(Arrays.toString(new T0003_MergeSort().sort(new int[]{1, 2, 3, 2, 1})));
        //System.out.println(Arrays.toString(new T0003_MergeSort().sort(new int[]{1, 0})));
        //System.out.println(Arrays.toString(new T0003_MergeSort().sort(new int[]{1, 2, 0, 3, 3, 2, 1})));
        System.out.println(Arrays.toString(new T0005_MergeSort().sort(new int[]{1, 2, 0, 3, 3, 2, 1})));
        System.out.println(Arrays.toString(new T0005_MergeSort().sort(new int[]{1, 2, 0, 4, 3, 3, 2, 1})));

    }

    public int[] sort(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int[] mergeSort(int[] nums, int l, int r) {
        if (r - l < 1) {
            return nums;
        }
        if (r - l <= 1) {
            if (nums[r] > nums[l]) {
                int tmp = nums[r];
                nums[r] = nums[l];
                nums[l] = tmp;
            }
            System.out.println(count++);
            return nums;
        }
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        mergeSort(nums, l, r, mid);

        return nums;
    }

    private void mergeSort(int[] nums, int l, int r, int mid) {
        int wl = l;
        int wr = mid + 1;
        int[] res = new int[r - l + 1];

        int i = 0;
        while (wl <= wr && i < res.length) {
            // wl超边界
            if (wl >= mid + 1) {
                res[i] = nums[wr];
                wr++;
            } else if (wr >= r + 1) {// wr超边界
                res[i] = nums[wl];
                wl++;
            } else if (nums[wl] > nums[wr]) {//左比右边大
                res[i] = nums[wl];
                wl++;
            } else {// 右边比左边大
                res[i] = nums[wr];
                wr++;
            }
            System.out.println(count++);
            i++;
        }

        System.arraycopy(res, 0, nums, l, res.length);
    }


}
