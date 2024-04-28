package com.fly.leetcode.sort;

import java.util.Arrays;

/**
 *
 * https://www.geeksforgeeks.org/heap-sort/
 * https://developer.aliyun.com/article/1046883
 * @author fly
 * @create 2024-04-28-14:53
 **/
public class T0007_HeapSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T0007_HeapSort().sort(new int[]{10, 20, 0, 40, 30})));
        System.out.println(Arrays.toString(new T0007_HeapSort().sort(new int[]{1, 2, 0, 4, 3, 3, 2, 1})));
    }

    public int[] sort(int[] nums) {
        //构建大顶堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            heapify(nums, i, 0);
        }

        return nums;
    }

    //构建大顶堆，升序排序
    private int[] heapify(int[] nums, int n, int i) {
        while (true) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int maxNi = i;

            if (l < n && nums[l] > nums[maxNi]) {
                maxNi = l;
            }
            if (r < n && nums[r] > nums[maxNi]) {
                maxNi = r;
            }
            if (maxNi == i) {
                break;
            }

            int tmp = nums[i];
            nums[i] = nums[maxNi];
            nums[maxNi] = tmp;

            //向下继续遍历
            i = maxNi;
        }
        return nums;
    }

}
