package com.fly.interview.kedaxunfei;

/**
 * @author fly
 * @create 2024-05-13-12:21
 **/
public class L000_BinaryNum {
    public static void main(String[] args) {
        //System.out.println(new L000_BinaryNum().changeNum(1));
        //System.out.println(new L000_BinaryNum().changeNum(2));
        //System.out.println(new L000_BinaryNum().changeNum(3));
        //System.out.println(new L000_BinaryNum().changeNum(4));
        //System.out.println(new L000_BinaryNum().changeNum(5));
        System.out.println(new L000_BinaryNum().changeNum(10));
    }

    /**
     * 1、将一个数的二进制倒数第二位0换成1，输出替换后的结果
     * 输入一个数如10，起二进制表达为1010，将倒是第二位0换成1，输出结果1110，即14
     * 例如2，二进制表达10，倒数第二个0换成1后是110，即6
     * <p>
     * 作者：知更鸟女孩！！
     * 链接：https://www.nowcoder.com/creation/subject/cf0834b50edc462db79e121a8bdb6600
     * 来源：牛客网
     */

    public int changeNum(int number) {
        int n = number;
        int bin = 0;
        int i = 0;
        int t = 0;
        int tmp = 0;
        while (n != 0) {
            i = n % 2;
            n = n >> 1;
            if (i != 0) {
                bin = bin + (int) Math.pow(10, t);
            }else {
                tmp =  (int) Math.pow(2, t);
            }
            t++;
        }

        return number + tmp;
        //return bin;
    }
}
