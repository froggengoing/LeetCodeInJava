package com.fly.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * [503]下一个更大元素 II	67.4%	Medium	0.0%
 * https://leetcode.cn/problems/next-greater-element-ii/
 *
 * Runtime 5 ms Beats 96.10% of users
 * with Java Memory 45.17 MB Beats 99.38% of users with Java
 * @author fly
 * @create 2024-04-23-16:11
 **/
public class LC00503_0021_NextGreaterElements_01 {

    public static void main(String[] args) {
        int[] r1 = new LC00503_0021_NextGreaterElements_01().nextGreaterElements(new int[]{1, 2, 3, 4, 3});
        int[] r2 = new LC00503_0021_NextGreaterElements_01().nextGreaterElements(new int[]{1, 2, 1});
        int[] r3 = new LC00503_0021_NextGreaterElements_01().nextGreaterElements(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(r1));
        System.out.println(Arrays.toString(r2));
        System.out.println(Arrays.toString(r3));
    }

    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length * 2 - 1; i++) {
            while (!queue.isEmpty() && nums[i % nums.length] > nums[queue.peekLast()]) {
                Integer pop = queue.pollLast();
                res[pop] = nums[i % nums.length] ;
            }
            queue.addLast(i % nums.length);
        }
        return res;
    }
    //public int[] nextGreaterElements(int[] nums) {
    //    int n = nums.length;
    //    int[] ret = new int[n];
    //    Arrays.fill(ret, -1);
    //    Deque<Integer> stack = new LinkedList<Integer>();
    //    for (int i = 0; i < n * 2 - 1; i++) {
    //        while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
    //            ret[stack.pop()] = nums[i % n];
    //        }
    //        stack.push(i % n);
    //    }
    //    return ret;
    //}

}
