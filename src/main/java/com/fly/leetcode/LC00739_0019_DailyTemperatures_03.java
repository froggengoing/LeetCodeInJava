package com.fly.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * [739]每日温度	68.7%	Medium	0.0%
 * https://leetcode.cn/problems/daily-temperatures
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *
 *
 * Runtime 26 ms Beats 81.24% of users
 * with Java Memory 59.79 MB Beats 75.41% of users with Java
 * @author fly
 * @create 2024-04-23-12:32
 **/
public class LC00739_0019_DailyTemperatures_03 {

    public static void main(String[] args) {
        int[] r1 = new LC00739_0019_DailyTemperatures_03().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(r1));
        int[] r2 = new LC00739_0019_DailyTemperatures_03().dailyTemperatures(new int[]{30, 40, 50, 60});
        System.out.println(Arrays.toString(r2));
    }

    public int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!queue.isEmpty() && temperatures[i] > temperatures[queue.peekLast()]) {
                Integer pop = queue.pollLast();
                res[pop] = i - pop;
            }
            queue.addLast(i);
        }

        return res;
    }
}
