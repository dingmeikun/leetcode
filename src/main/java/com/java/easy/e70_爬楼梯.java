package com.java.easy;

public class e70_爬楼梯 {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 注意：给定 n 是一个正整数。
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     *
     * 递推：f(x) = f(x-1) + f(x-2)      // 实质上：属于 斐波那契数组，但是当输入的数据极大时，将会栈溢出，所以使用递归也可能存在问题。
     * 1    2   3   4   5   6   7   8
     * 1    2   3   5   8   13  21  34
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(climbStairs1(1));
        System.out.println(climbStairs1(2));
        System.out.println(climbStairs1(5));
        System.out.println(climbStairs1(8));
        System.out.println(climbStairs1(1836311903));
    }

    /**
     * 递归调用，形成斐波那契数组
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n-2)+climbStairs(n-1);
    }

    /**
     * 滚动数组，采用不断向前滚动的方式，累加数值
     *
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        int a=0,b=0,c=1;
        for (int i = 1; i <= n; ++i) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }

}
