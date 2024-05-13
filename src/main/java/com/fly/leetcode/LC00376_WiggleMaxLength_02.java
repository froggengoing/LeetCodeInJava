package com.fly.leetcode;

/**
 * 暴力求解，根本做不好，组合数为2^n-1
 * [1,17,5,10,13,15,10,5,16,8]
 * <p>
 * 看了网上的解法才知道怎么做，画图就好理解了
 * https://programmercarl.com/0376.%E6%91%86%E5%8A%A8%E5%BA%8F%E5%88%97.html#%E6%80%9D%E8%B7%AF
 * 尽可能保留更多的峰
 * </p>
 *
 * @author fly
 * @create 2024-04-21-23:29
 **/
public class LC00376_WiggleMaxLength_02 {

    public static void main(String[] args) {
        System.out.println(new LC00376_WiggleMaxLength_02().wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(new LC00376_WiggleMaxLength_02().wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
    }

    public int wiggleMaxLength(int[] s) {


        for (int i = 0; i < s.length; i++) {

        }
        return 0;
    }


}
