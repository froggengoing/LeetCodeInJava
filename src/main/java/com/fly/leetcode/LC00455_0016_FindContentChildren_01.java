package com.fly.leetcode;

import java.util.Arrays;

/**
 *✔	[455]分发饼干	56.1%	Easy	0.0%
 *
 * 这里思路和[11]盛水的容器，本质是对二维数组优化搜索空间
 * @author fly
 * @create 2024-04-21-22:42
 **/
public class LC00455_0016_FindContentChildren_01 {

    public static void main(String[] args) {
        System.out.println(new LC00455_0016_FindContentChildren_01().findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1, 2, 3}));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int si = 0;
        int gj = 0;
        while (si < s.length && gj < g.length) {
            if (s[si] >= g[gj]) {
                count++;
                si++;
                gj++;
            } else {
                si++;
            }
        }
        return count;
    }
}
