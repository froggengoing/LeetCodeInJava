package com.fly.leetcode;

/**
 * 300. 最长递增子序列
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/
 * <p>
 * Runtime 3 ms Beats 95.24% of users
 * with Java Memory 44.13 MB Beats 48.68% of users with Java
 *
 * @author fly
 * @create 2024-04-24-10:34
 **/
public class LC00300_0025_LengthOfLIS_02 {

    public static void main(String[] args) {
        //System.out.println(new LC00300_0025_LengthOfLIS_02().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        //System.out.println(new LC00300_0025_LengthOfLIS_02().lengthOfLIS(new int[]{7, 7, 7, 7}));
        //System.out.println(new LC00300_0025_LengthOfLIS_02().lengthOfLIS(new int[]{7}));
        //System.out.println(new LC00300_0025_LengthOfLIS_02().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(new LC00300_0025_LengthOfLIS_02().lengthOfLIS(new int[]{1, 2, -10, -8, -7}));
        //System.out.println(new LC00300_0025_LengthOfLIS_02().lengthOfLIS(new int[]{1, 2, 3, 4, 5, 1}));
    }

    public int lengthOfLIS(int[] nums) {
        int[] maxSubArr = new int[nums.length + 1];
        maxSubArr[1] = nums[0];

        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxSubArr[maxLen]) {
                maxSubArr[++maxLen] = nums[i];
            } else {
                int r = maxLen;
                // bug l初始值为1，而不是0
                int l = 1;
                //bug：这里需要初始化为0，否则结果不对
                int pos = 0;
                while (r >= l) {
                    int mid = (r + l) >> 1;
                    if (maxSubArr[mid] >= nums[i]) {
                        r = mid - 1;
                    } else {
                        pos = mid;
                        l = mid + 1;
                    }
                }
                //bug，退不出来
                //while (r > l) {
                //    int mid = (r + l) / 2;
                //    if (maxSubArr[mid] > nums[i]) {
                //        r = mid;
                //        pos = r;
                //    } else {
                //        l = mid;
                //        pos = l + 1;
                //    }
                //}
                maxSubArr[pos + 1] = nums[i];
            }
        }
        return maxLen;
    }
}
